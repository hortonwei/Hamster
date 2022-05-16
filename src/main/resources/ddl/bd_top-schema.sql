use test;
create table if not exists bd_top(
    id bigint(20) unsigned primary key unique comment '主键',
    type enum('all','mov','tv') not null comment '热搜类型',
    idx int(8) unsigned comment '热度/指数',
    title varchar(64) not null comment '标题',
    intro varchar(512) comment '简述',
    img varchar(512) comment '图片',
    fcd datetime default current_timestamp comment '首次修改时间',
    lcd datetime default current_timestamp on update current_timestamp comment '最后修改时间',
    lcu varchar(16) not null comment '最后修改者',
    del enum('N','Y') default 'N' comment '是否已逻辑删除',
    unique index uk_title (title)
) Engine InnoDB comment = '百度热搜';

drop index uk_title on bd_top;
create unique index uk_title_intro on bd_top (title, intro);

alter table bd_top add src enum('bd', 'sina') not null comment '来源' after id;

#修改用户权限
/*
update mysql.user
set Host='%',
    Select_priv='Y',
    Insert_priv='Y',
    Update_priv='Y',
    Delete_priv='N',
    Create_priv='Y',
    Drop_priv='N',
    Reload_priv='N',
    Shutdown_priv='N',
    Process_priv='N',
    File_priv='N',
    Grant_priv='N',
    References_priv='N',
    Index_priv='Y',
    Alter_priv='Y',
    Show_db_priv='N',
    Super_priv='N',
    Create_tmp_table_priv='Y',
    Lock_tables_priv='N',
    Execute_priv='N',
    Repl_slave_priv='N',
    Repl_client_priv='N',
    Create_view_priv='N',
    Show_view_priv='N',
    Create_routine_priv='N',
    Alter_routine_priv='N',
    Create_user_priv='N',
    Event_priv='N',
    Trigger_priv='N',
    Create_tablespace_priv='N'
where User='root1';
flush privileges;
*/


