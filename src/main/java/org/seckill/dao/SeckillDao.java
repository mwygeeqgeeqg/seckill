package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.springframework.stereotype.Repository;

@Repository
public interface SeckillDao {
	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
	
	
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
	public List queryAll(@Param("offset")int offset,@Param("limit")int limit);
}
