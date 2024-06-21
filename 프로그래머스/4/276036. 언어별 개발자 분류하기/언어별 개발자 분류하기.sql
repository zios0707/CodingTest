-- 코드를 작성해주세요

WITH FRONT AS (
    SELECT SUM(CODE) AS F
    FROM SKILLCODES
    WHERE CATEGORY LIKE 'Front End'
    GROUP BY CATEGORY
)

SELECT GRADE, ID, EMAIL
FROM (
    SELECT
        IF(
            F & SKILL_CODE > 0 &&
            (SELECT CODE FROM SKILLCODES WHERE NAME LIKE 'Python') & SKILL_CODE > 0
        , 'A',

        IF(
            (SELECT CODE FROM SKILLCODES WHERE NAME LIKE 'C#') & SKILL_CODE > 0
        , 'B',

        IF(
            F & SKILL_CODE > 0
        , 'C', 'D'))) AS GRADE,
    ID, EMAIL
    FROM DEVELOPERS, FRONT) VAL
WHERE GRADE IN ("A", "B", "C")

ORDER BY GRADE, ID