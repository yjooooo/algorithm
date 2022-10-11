-- 코드를 입력하세요
SELECT A.PRODUCT_ID, PRODUCT_NAME, SUM(A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS A
INNER JOIN FOOD_ORDER AS B
ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE PRODUCE_DATE BETWEEN '2022-05-01 00:00:00' AND '2022-05-31 23:59:59'
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC;