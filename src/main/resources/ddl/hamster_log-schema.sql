create table if not exists test.hamster_log(
    id int(6) unsigned comment '主键' primary key ,
    count_exp int(8) unsigned comment '异常数量' default 0,
    fcd datetime comment '首次修改时间' default current_timestamp,
    lcd datetime comment '最后修改时间' default current_timestamp on update current_timestamp,
    del enum('N','Y') default 'N' comment '是否已逻辑删除'
)Engine InnoDB comment '异常日志';

insert into test.hamster_log(id, count_exp) VALUES (1001, 0);
