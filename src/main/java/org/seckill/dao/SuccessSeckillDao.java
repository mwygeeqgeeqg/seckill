package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessSeckill;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessSeckillDao {

	/**
	 * 插入购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int inserSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	/**
	 * 查询SuccessSeckill的信息，并携带Seckill的对象实体
	 * @param seckillId
	 * @return
	 */
	SuccessSeckill queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
