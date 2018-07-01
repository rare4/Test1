use board;
select * from board.boardtable;
-- 게시글 작성
INSERT INTO boardtable VALUES (5,'제목5','rare2',current_timestamp(),'지금으로부터 6000년전...',1,0404);
insert into boardtable(title,userid,content,password) values('제목제목1','rare44','7000년전..',4444);

-- 게시글 전체 조회(리스트 보기)

select num, title, userid, postdate, readcount from boardtable order by num desc;
select num, title, userid, postdate, readcount from boardtable where num=1;
-- 특정 게시글 조회(상세보기)
commit;
select * from boardtable where num='1';
update boardtable set readcount=readcount+1 where num=3;
-- 게시글 수정
select password from boardtable where num=3;
-- 비밀번호 확인
select password from boardtable where num=3;-- 글 번호를 넘겨주고 해당 글의 비밀번호를 얻어옴
select * from boardtable where num=3 && password=404;



update boardtable set title='바꿈제목1' where num=1;
update boardtable set readcount=readcount+1 where num=1;
update boardtable set content = '컨텐트수정', title = '제목수정' where num=2;
-- 게시글 삭제
-- 비밀번호 확인하고 유저가 입력한 값과 같다면,  

delete from board.boardtable where num=32;
commit;
select * from board.boardtable order by ref desc, step asc, reforder asc;

select * from boardtable order by ref desc, reforder asc;
commit;

select count(*) from boardtable where ref=8 and step=1;

select max(num) as num from boardtable;