-- 코드를 입력하세요
SELECT FLAVOR
FROM FIRST_HALF
NATURAL JOIN ICECREAM_INFO
WHERE TOTAL_ORDER > 3000 AND
    INGREDIENT_TYPE LIKE 'fruit%'

ORDER BY TOTAL_ORDER DESC