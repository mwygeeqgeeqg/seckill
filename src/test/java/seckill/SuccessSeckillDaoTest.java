package seckill;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SuccessSeckillDao;
import org.seckill.entity.SuccessSeckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessSeckillDaoTest {
//	@Resource
//	private SuccessSeckillDao successSeckillDao;
	
	@Test
	public void insertSeckillTest(){
//		Long seckillId = 1001L;
//		Long userPhone=13212344321L;
//		int inserCount=successSeckillDao.inserSuccessKilled(seckillId, userPhone);
//		System.out.println("insertCount"+inserCount);
	}
	@Test
	public void queryByIdWithSeckillTest(){
//		Long seckillId = 1001L;
//		Long userPhone=13212344321L;
//		SuccessSeckill ss=successSeckillDao.queryByIdWithSeckill(seckillId, userPhone);
//		System.out.println("aaaaaaa"+ss);
//		if (ss!=null) {
//			System.out.println(ss.getSeckillId()+"电话："+ss.getPhone());
//			System.out.println(ss.getSeckill());
//		}
	}

}
