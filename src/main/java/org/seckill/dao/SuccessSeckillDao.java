package org.seckill.dao;

import org.seckill.entity.SuccessSeckill;

public interface SuccessSeckillDao {

	/**
	 * 插入购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int inserSuccessKilled(long seckillId,long userPhone);
	
	/**
	 * 查询SuccessSeckill的信息，并携带Seckill的对象实体
	 * @param seckillId
	 * @return
	 */
	SuccessSeckill queryByIdWithSeckill(long seckillId);
}
