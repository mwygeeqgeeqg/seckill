package org.seckill.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessSeckillDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessSeckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * 业务逻辑的实现
 * @author liguotao
 *
 */
//@Component  @Service  @Controller @Dao
@Service
public class SeckillServiceImpl implements SeckillService {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessSeckillDao successSeckillDao;

	private final String slat="adsfasdfa2342423dfe987983423@@#3223434#";
	public List<Seckill> getSeckillList() {
		
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getSeckillById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}
	

	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if(seckill==null){
			return  new Exposer(false,seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime= seckill.getEndTime();
		 //系统当前时间
		 Date nowTime = new Date();
		if (nowTime.getTime()<startTime.getTime()||nowTime.getTime()>endTime.getTime()){
			return  new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		//转化特定字符串的过程，特点不可逆。
		String md5=getMD5(seckillId);
		return new Exposer(true,md5,seckillId);
	}
@Transactional
/**
 * 使用注解控制事务方法的有点
 * 1、开发团队达成一直约定，明确标注事务方法的编程的风格
 * 2、保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC／HTTP请求或者剥离到事务方法外部。
 * 3、不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {

		if (md5==null||md5.equals(getMD5(seckillId))){
			//数据被篡改
			throw new SeckillException("seckill data rewtrite");
		}
		Date nowTime= new Date();
		try{
			//减库存
			int updateCount = seckillDao.reduceNumber(seckillId,nowTime);
			if (updateCount<=0){
				//秒杀关闭
				throw  new SeckillCloseException("seckill close");
			}else{
				// 插入购买明细
				int insertCount = successSeckillDao.inserSuccessKilled(seckillId,userPhone);
				if (insertCount<=0){
					//重复秒杀
					throw new RepeatKillException("seckill repeat");
				}else{
					//秒杀成功
					SuccessSeckill successSeckill= successSeckillDao.queryByIdWithSeckill(seckillId,userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successSeckill);
				}
			}
		}catch (SeckillCloseException e1){
			throw e1;
		}catch (RepeatKillException e2){
			throw e2;
		}catch (Exception e ){
			//编译器异常转化成为运行时异常
			throw new SeckillException("seckill inner error"+e.getMessage());
		}

	}
//md5 加密
	private String getMD5(long seckillID){
		String base =seckillID+"/" +slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

}
