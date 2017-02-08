--数据库初始化脚本


--创建数据库
CREATE database seckill;

--使用数据库

use seckill;

--创建秒杀数据库表

create table seckill(

	'seckill_ids' bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
	'name' varchar(60) NOT NULL COMMENT '商品名称',
	'number' int not null comment '库存数量',
	'start_time' timestamp not null comment '秒杀开启时间',
	'end_time' timestamp not null comment '秒杀结束时间',
	'create_time' timestamp not null default current_timestamp comment '创建时间',
	primary key (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT charset=utf8  comment='库存秒杀表' ;

--初始化数据

insert into seckill(name,number,start_time,end_time,create_time) values(
'100元秒杀iphone7',100,'2017-01-01 00:00:00','2017-01-03 00:00:00',
'50元秒杀ipad3',100,'2017-01-01 00:00:00','2017-01-03 00:00:00',
'30元秒杀mi5',100,'2017-01-01 00:00:00','2017-01-03 00:00:00',
'10元秒杀华为荣耀7',100,'2017-01-01 00:00:00','2017-01-03 00:00:00'
);


create table success_seckill(

'seckill_id' bigint not null comment '秒杀产品的ID',
'phone' bigint not null comment '秒杀成功的手机号',
'status' tinyint not null comment '秒杀状态：0-秒杀成功,1已付款,-1无效',
'create_time' timestamp not null default current_timestamp comment '创建时间',
primary key (seckill_id,phone),
key idx_create_time(create_time)

)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT charset=utf8  comment='秒杀成功明细表' ;



