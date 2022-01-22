create table mvc_user (
    account varchar2(30) primary key,
    password varchar2(30) not null,
    name varchar2(30) not null,
    reg_date timestamp default sysdate
);