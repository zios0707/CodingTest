-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, sum(price) as TOTAL_SALEs
from used_goods_board
join used_goods_user on writer_id = user_id
where status = 'done'
group by user_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES ASC