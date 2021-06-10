select * from tab;
select * from MEMBER;
select * from notice;

create sequence notice_seq 
increment by 1 start with 1 nocache; 

insert into member values('admin','1234','123','123','123','123','123','123','123','123','123','123',sysdate,1,0)