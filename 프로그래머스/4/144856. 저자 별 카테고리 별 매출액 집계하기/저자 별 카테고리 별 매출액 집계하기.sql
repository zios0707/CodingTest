-- 코드를 입력하세요

SELECT author.AUTHOR_ID, author.AUTHOR_NAME, CATEGORY, sum(price * sales) as TOTAL_SALES
from book
join author on book.author_id = author.author_id
join book_sales on book.book_id = book_sales.book_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by author_id, category
order by author_id asc, category desc;