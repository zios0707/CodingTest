-- 코드를 입력하세요
SELECT DISTINCT S1.USER_ID, S1.PRODUCT_ID
FROM ONLINE_SALE S1
JOIN ONLINE_SALE S2 ON
    S1.USER_ID = S2.USER_ID AND
    S1.PRODUCT_ID = S2.PRODUCT_ID AND
    S1.SALES_DATE <> S2.SALES_DATE
ORDER BY USER_ID, PRODUCT_ID DESC