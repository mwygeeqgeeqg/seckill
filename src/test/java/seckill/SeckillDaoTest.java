package seckill;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junitspring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	@Test
	public void testQueryByid() throws Exception{
		long  id=1000;
		System.out.println("ssssss");
		Seckill seckill= seckillDao.queryById(id);
		System.out.println("aaaaa");
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	@Test
	public void testQueryAll(){
		List<Seckill> seckillList = seckillDao.queryAll(0, 5);
		for (Seckill seckill : seckillList) {
			System.out.println(seckill);
		}
	}
	@Test
	public void testReduceNumber(){
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println(updateCount);
		
	}
}
