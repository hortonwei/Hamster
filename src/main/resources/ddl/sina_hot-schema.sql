use test;
create table if not exists sina_hot(
    mid bigint(20) unsigned primary key unique comment '主键',
    category varchar(18) not null comment '热搜类型',
    raw_hot int(8) unsigned comment '热度',
    word varchar(64) not null comment '标题',
    fun_word enum('N','Y') not null comment '是否娱乐词',
    channel_type enum('0','1') comment '频道 0-null 1-Entertainment',
    star_name varchar(32) default null comment '明星姓名',
    fcd datetime default current_timestamp comment '首次修改时间',
    lcd datetime default current_timestamp on update current_timestamp comment '最后修改时间',
    lcu varchar(16) not null comment '最后修改者',
    del enum('N','Y') default 'N' comment '是否已逻辑删除'
) comment = '微博热搜';

create index idx_word
    on sina_hot (word);
