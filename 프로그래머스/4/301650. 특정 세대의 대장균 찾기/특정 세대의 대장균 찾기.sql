-- 코드를 작성해주세요
SELECT C.ID
FROM ECOLI_DATA C
LEFT JOIN ECOLI_DATA P on C.PARENT_ID = P.ID
LEFT JOIN ECOLI_DATA PP on P.PARENT_ID = PP.ID
WHERE PP.PARENT_ID IS NULL AND
    PP.ID IS NOT NULL
ORDER BY C.ID