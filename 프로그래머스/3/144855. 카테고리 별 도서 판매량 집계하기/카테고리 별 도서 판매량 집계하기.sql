-- 코드를 입력하세요
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES BS ON BS.BOOK_ID = B.BOOK_ID
WHERE YEAR(SALES_DATE) = "2022" AND
    MONTH(SALES_DATE) = "1"
GROUP BY CATEGORY

ORDER BY CATEGORY ASC;


# SELECT CATEGORY, B.BOOK_ID, SUM(SALES)
# FROM BOOK B
# JOIN BOOK_SALES BS ON BS.BOOK_ID = B.BOOK_ID
# GROUP BY CATEGORY, B.BOOK_ID
# ORDER BY CATEGORY, SALES DESC;