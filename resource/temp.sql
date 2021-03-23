

/**
 配置文件表
 */
drop table if exists tb_match_temp;
create table  if not exists tb_match_temp(
    id int primary key  not null auto_increment,
    temp_uniname char(32) unique not null comment '模板名称',
    event_id int not null unique,
    temp_config JSON not null comment '模板基本配置',
    temp_count int default  0,
    outline_rule int default 0,
    start_time timestamp ,
    is_del int default 0,
    remark_1 varchar(255),
    remark_2 varchar(255),
    remark_3 varchar(255)
)engine=myisam,charset=utf8;



/**
 场馆地址表
 */
drop table if exists  tb_count_addr;
create table  if not exists tb_count_addr(
    id int primary key  not null auto_increment,
    addr_name char(32) unique not null comment '地址名称',
    addr_count tinyint not null default 4 comment '可用场地',
    addr varchar(2000) not null comment '详细地址',
    is_del int default 0,
    remark_1 varchar(255),
    remark_2 varchar(255),
    remark_3 varchar(255)
)engine=myisam,charset=utf8;
