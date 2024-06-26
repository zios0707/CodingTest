-- 코드를 입력하세요
SELECT o.PRODUCT_ID, PRODUCT_NAME, SUM(AMOUNT) * PRICE AS TOTAL_SALES
FROM FOOD_ORDER o
JOIN FOOD_PRODUCT p on p.product_id = o.product_id
WHERE DATE_FORMAT(PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, o.PRODUCT_ID