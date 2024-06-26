-- 코드를 작성해주세요
WITH RECURSIVE GEN AS (
    SELECT ID, PARENT_ID, 0 AS GENER
    FROM ECOLI_DATA
    UNION ALL
    SELECT ECOLI_DATA.ID, ECOLI_DATA.PARENT_ID, GENER + 1 FROM GEN
    JOIN ECOLI_DATA on GEN.ID = ECOLI_DATA.PARENT_ID
    WHERE ECOLI_DATA.ID IS NOT NULL

)

SELECT COUNT(*) COUNT, GE + 1 GENERATION
FROM (SELECT ID, MAX(GENER) GE
FROM GEN
GROUP BY ID) G
LEFT JOIN ECOLI_DATA E on E.PARENT_ID = G.ID
WHERE E.ID IS NULL
GROUP BY GE

ORDER BY GENERATION
