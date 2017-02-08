package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.seckill.entity.Seckill;


public interface SeckillDao {
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(long seckillId,Date killTime);
	
	
	/**
	 *根据id查询秒杀对象
	 * @param seckillId
	 * @return
	 */
	public Seckill queryById(long seckillId);
	
	
	/**
	 * 根据偏移量查询秒杀商品对象列表
	 * @param offet
	 * @param limit
	 * @return
	 */
	public List queryAll(int offet,int limit);
}
