package org.seckill.service.impl;

import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessSeckillDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 业务逻辑的实现
 * @author liguotao
 *
 */
public class SeckillServiceImpl implements SeckillService {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	private SeckillDao seckillDao;
	private SuccessSeckillDao successSeckillDao;
	public List<Seckill> getSeckillList() {
		
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getSeckillById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}
	

	public Exposer exportSeckillUrl(long seckillId) {
		return null;
	}

	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		return null;
	}

}
