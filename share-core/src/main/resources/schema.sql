create table t_share_user(
    id bigint not null auto_increment comment '用户ID',
    username varchar(32) not null comment '用户名',
    password varchar(32) not null comment '用户密码',
    nickname varchar(32) not null comment '昵称',
    create_time timestamp not null default current_timestamp comment '创建时间',
    modify_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    unique key (username)
)engine=innodb charset=utf8 comment '用户表';

create table t_share_movie(
    id bigint not null auto_increment comment '电影ID',
    title varchar(64) not null comment '电影名称',
    description varchar(500) not null comment '电影描述',
    url varchar(100) not null comment '观影地址',
    cover_image_url varchar(100) not null comment '封面图片地址',
    score float not null comment '评分',
    create_time timestamp not null default current_timestamp comment '创建时间',
    modify_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (id),
    key `score` (score),
    unique key (title)
)engine=innodb charset=utf8 comment '电影表';