-- 코드를 작성해주세요
SELECT fi.ID, fni.FISH_NAME, fi.LENGTH
FROM FISH_INFO fi
JOIN FISH_NAME_INFO fni on fi.FISH_TYPE = fni.FISH_TYPE
WHERE fi.LENGTH = (SELECT MAX(fi2.LENGTH)
              FROM FISH_INFO fi2
              WHERE fi2.FISH_TYPE = fi.FISH_TYPE )
ORDER BY ID