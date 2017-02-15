package org.seckill.dto;

import org.seckill.entity.SuccessSeckill;

/**
 * 封装秒杀执行后结果
 * 
 * @author liguotao
 *
 */
public class SeckillExecution {
	private long seckillId;
	// 秒杀状态
	private int state;
	// 状态表示
	private String stateInfo;
	// 秒杀成功对象
	private SuccessSeckill seccessSeckill;

	public SeckillExecution(long seckillId, int state, String stateInfo) {
		super();
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public SeckillExecution(long seckillId, int state, String stateInfo, SuccessSeckill seccessSeckill) {
		super();
		this.seckillId = seckillId;
		this.state = state;
		this.stateInfo = stateInfo;
		this.seccessSeckill = seccessSeckill;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessSeckill getSeccessSeckill() {
		return seccessSeckill;
	}

	public void setSeccessSeckill(SuccessSeckill seccessSeckill) {
		this.seccessSeckill = seccessSeckill;
	}

}
