drop table if exists tb_file_tree;
create table  if not exists tb_file_tree(
    id int primary key  not null auto_increment,
    virtual_path varchar(255) not null,
    maxsize int not null,
    is_del int default 0,
    remark_1 varchar(255),
    remark_2 varchar(255),
    remark_3 varchar(255)
)engine=innodb,charset=utf8;


drop table if exists tb_file;
create table if not exists tb_file(
    id int primary key not null auto_increment comment 'id',
    f_file_name char(32) not null unique comment '文件名',
    f_short_name char(16) not null unique comment '脱敏数据',
    f_web_src varchar(255) unique  comment '网络连接',
    f_original_name varchar(255)   comment '原文件名',
    f_filetree_id int comment '在虚拟文件树所在的位置',
    f_filetree_virtual varchar(255) comment '在虚拟文件树所在的目录',
    f_absolute_src varchar(255) unique  comment '绝对路径 到/',
    f_position_path varchar(255) not null comment '相对路径 到 /' ,
    f_subfix varchar(8) not null comment '后缀',
    f_size int not null comment '大小',
    is_temp boolean default true comment '是否为临时文件默认是true',
    is_del boolean  default  false,
    remark_1 varchar(255),
    remark_2 varchar(255),
    remark_3 varchar(255),
    remark_4 varchar(255),
    remark_5 varchar(255),
    remark_6 varchar(255),
    remark_7 varchar(255),
    remark_8 varchar(255)
)engine=innodb,charset=utf8;

drop table if exists t_phontom;
create  table if not exists t_phontom(
   id int primary key not null auto_increment comment 'id',
   p_uniname char(32) unique  not null comment '唯一名字',
   p_title varchar(255) not null comment '作品名称',
   p_tel char(11) not null comment '手机号',
   p_start_tel char(11) not null comment '脱敏数据手机号',
   p_event_id int   comment '秩序册id',
   p_account_id char(16)  null comment '账号id',
   pet_name varchar(128)  null comment '昵称为空时匿名 项目初期',
   p_check tinyint not null default  0 comment '是否过审 1 过审, 0 未审核 ,-1 不过审',
   is_del boolean default false,
   create_time timestamp default current_timestamp comment '上传时间',
   remark_1 varchar(255),
   remark_2 varchar(255),
   remark_3 varchar(255),
   remark_4 varchar(255)
)engine=innodb,charset=utf8;

drop table if exists t_phontom_text;
create table if not exists  t_phontom_text(
   id int primary key not null auto_increment comment 'id',
   p_uniname char(32) unique  not null comment '唯一名字,一对一',
   p_text text,
   remark_1 varchar(255),
   remark_2 varchar(255),
   remark_3 varchar(255),
   remark_4 varchar(255)
)engine=innodb,charset=utf8;

drop table if exists t_phontom_file;
create table if not exists  t_phontom_file(
   id int primary key not null auto_increment comment 'id',
   p_uniname char(32)  not null comment '唯一名字,一对一',
   f_short_name char(16) not null  comment '文件脱敏数据',
   unique (p_uniname,f_short_name)
)engine=innodb,charset=utf8;

drop table if exists t_temp_account;
create table if not exists  t_temp_account(
  id int primary key not null auto_increment comment 'id',
  tel char(11) not null unique,
  short_account char(32) not null unique,
  pet_name varchar(255) not null,
  is_del int default 0
);



alter table t_group add column(uniname char(64) unique );
alter table t_group modify  uniname char(64) unique after  id;
alter table t_group_team_rel add column (uniname char(64));
alter table t_group_team_rel modify  uniname char(64)  after id;
alter table t_stage add column(uniname char(64) unique );
alter table t_stage modify  uniname char(64) unique after  id;
alter table t_stage_team_rel add column(uniname char(64) );
alter table t_stage_team_rel modify  uniname char(64)  after  id;

