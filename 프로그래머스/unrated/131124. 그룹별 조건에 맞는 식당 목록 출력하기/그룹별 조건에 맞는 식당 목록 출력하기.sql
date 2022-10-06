-- 코드를 입력하세요
SELECT MEMBER_NAME, REVIEW_TEXT, REVIEW_DATE
FROM MEMBER_PROFILE as a
    INNER JOIN REST_REVIEW as b
    ON a.MEMBER_ID = b.MEMBER_ID
    WHERE b.MEMBER_ID IN (
        SELECT MEMBER_ID FROM REST_REVIEW
        GROUP BY MEMBER_ID
        HAVING COUNT(REVIEW_ID) = (
                                SELECT COUNT(REVIEW_ID) FROM REST_REVIEW
                                GROUP BY MEMBER_ID
                                ORDER BY COUNT(REVIEW_ID) DESC
                                LIMIT 1
                              )
        ORDER BY COUNT(REVIEW_ID) DESC
    )
ORDER BY REVIEW_DATE ASC;
