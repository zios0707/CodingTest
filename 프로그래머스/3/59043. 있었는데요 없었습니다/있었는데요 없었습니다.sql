-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS ins
JOIN ANIMAL_OUTS outs on ins.animal_id = outs.animal_id
WHERE ins.DATETIME > outs.DATETIME
ORDER BY ins.DATETIME