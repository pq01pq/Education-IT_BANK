-- 게시판 테이블 생성
create table mvc_board(
    board_no number primary key,
    title varchar2(100) not null,
    content varchar2(300) not null,
    writer varchar2(50) not null,
    reg_date date default sysdate,
    view_cnt number default 0
);

-- board_no에 대한 시퀀스 객체 생성
create sequence board_seq
    start with 1 increment by 1 maxvalue 100
    nocyle nocache;