-- https://blog.csdn.net/qq_41080850/article/details/84593860?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-1&spm=1001.2101.3001.4242

-- 1、查询01课程比02课程成绩高的学生信息及课程分数
SELECT *
FROM (
         SELECT *
         FROM (
                  SELECT sid, score AS s1
                  FROM grade
                  WHERE grade.cid = '01'
              ) g1
                  INNER JOIN (
             SELECT sid, score AS s2
             FROM grade
             WHERE grade.cid = '02'
         ) g2 USING (sid)
         WHERE g1.s1 > g2.s2
     ) g3
         LEFT JOIN student USING (sid)
-- 2、查询同时选修了01课程和02课程的学生的课程分数
SELECT *
FROM (
         SELECT *
         FROM (
                  SELECT sid, score AS s1
                  FROM grade
                  WHERE grade.cid = '01'
              ) g1
                  INNER JOIN (
             SELECT sid, score AS s2
             FROM grade
             WHERE grade.cid = '02'
         ) g2 USING (sid)
         WHERE g1.s1 > g2.s2
     ) g3
         LEFT JOIN student USING (sid)
-- 3、查询存在01课程但可能不存在02课程的情况
SELECT *
FROM (
         SELECT sid, score AS s1
         FROM grade
         WHERE grade.cid = '01'
     ) g1INNER
         JOIN (
    SELECT sid, score AS s2
    FROM grade
    WHERE grade.cid = '01'
) AS g2USING (sid)
         LEFT JOIN student USING (sid)
-- 4、查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩
SELECT *
FROM (
         SELECT sid, avg(score) AS avg_score
         FROM grade
         GROUP BY sid
         HAVING avg_score > 60
     ) g1
         LEFT JOIN student USING (sid)
-- 5、查询没有学全所有课程的同学的信息
SELECT *
FROM student
         INNER JOIN (
    SELECT sid
    FROM grade
    GROUP BY sid
    HAVING count(cid) < 4
) c1 USING (sid)
-- 6、查询至少有一门课与学号为01 的同学所学相同的同学的信息
SELECT *
FROM student
WHERE sid IN (
    SELECT sid
    FROM grade
    WHERE cid IN (
        SELECT cid
        FROM grade
        WHERE sid = '01'
    )
    GROUP BY sid
)
  AND sid != '01'
-- 7、查询没学过张衡老师讲授的任一门课程的学生姓名
SELECT *
FROM student
WHERE sid NOT IN (
    SELECT sid
    FROM grade
    WHERE cid IN (
        SELECT cid
        FROM course
        WHERE tid IN (
            SELECT tid
            FROM teacher
            WHERE tname = '张衡'
        )
    )
    GROUP BY sid
)
-- 8、检索01课程分数小于 60，按分数降序排列的学生信息
SELECT t1.sid, t1.sname, t1.sbirth, t1.sgender, g1.score
FROM student t1
         INNER JOIN (
    SELECT sid, score
    FROM grade
    WHERE cid = '01'
      AND score < 60
) g1
                    ON t1.sid = g1.sid
GROUP BY score DESC
-- 9、检索01课程分数小于 60，按分数降序排列的学生信息
SELECT *
FROM student
         INNER JOIN (
    SELECT sid, score
    FROM grade
    WHERE cid = '01'
      AND score < 60
) g1 USING (sid)
ORDER BY g1.score DESC
-- 10、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩
SELECT grade.*, temp.avg_sc
FROM (
         SELECT sid, avg(score) AS avg_sc
         FROM grade
         GROUP BY sid
     ) temp
         LEFT JOIN grade USING (sid)
ORDER BY temp.avg_sc DESC
-- 11、查询选修了全部课程的学生信息
SELECT *
FROM student
WHERE sid IN (
    SELECT sid
    FROM grade
    GROUP BY sid
    HAVING count(cid) = (
        SELECT count(DISTINCT cid)
        FROM course
    )
)
-- 12、检索至少选修两门课程的学生信息
SELECT *
FROM student
WHERE sid IN (
    SELECT sid
    FROM grade
    GROUP BY sid
    HAVING count(cid) >= 2
)
-- 13、统计每门课程的学生选修人数（超过 5 人的课程才统计）
SELECT *
FROM course
WHERE cid IN (
    SELECT cid
    FROM grade
    GROUP BY cid
    HAVING count(sid) > 5
)
-- 14、成绩有重复的情况下，查询选修张衡老师所授课程的学生中，成绩最高的学生信息及其成绩
SELECT *
FROM student
WHERE sid IN (
    SELECT sid
    FROM grade g2
             INNER JOIN (
        SELECT score, cid
        FROM grade
        WHERE cid IN (
            SELECT cid
            FROM course
            WHERE tid = (
                SELECT tid
                FROM teacher
                WHERE tname = '张衡'
            )
        )
        GROUP BY score DESC
			LIMIT 1
    ) g1
                        ON g2.score = g1.score
)
-- 15、查询课程编号为 01 且课程成绩在 80 分以上的学生的学号和姓名
SELECT sid,sname
FROM student
WHERE sid IN (
    SELECT sid
    FROM grade
    WHERE cid = '01'
      AND score > 80
)
-- 16、查询有不及格学生的课程，并统计不及格学生的人数
SELECT cid, cname, c1.count_num
FROM course
         INNER JOIN (
    SELECT cid, count(sid) AS count_num
    FROM grade
    WHERE score < 60
    GROUP BY cid
) c1 USING (cid)
-- 17、查询有且仅有一门课程成绩在 70 分以上的学生的学号、姓名、课程名称和分数
SELECT sid, sname, c1.cname, g1.score
FROM student
         INNER JOIN (
    SELECT sid, score, cid
    FROM grade
    WHERE score > 70
    GROUP BY sid
    HAVING count(score) = 1
) g1 USING (sid)
         INNER JOIN course c1 ON c1.cid = g1.cid
-- 18、查询至少一门课程成绩在 70 分以上的学生的学号、姓名、课程名称和分数
SELECT sid, sname, cname, score
FROM grade
         LEFT JOIN student USING (sid)
         LEFT JOIN course USING (cid)
WHERE sid NOT IN (
    SELECT sid
    FROM grade
    GROUP BY sid
    HAVING max(score) <= 70
);
-- 19、查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列
SELECT c1.cname, g1.avg_score
FROM course c1
         LEFT JOIN (
    SELECT avg(g1.score) AS avg_score, g1.cid
    FROM grade g1
    GROUP BY cid
) g1
                   ON g1.cid = c1.cid
ORDER BY g1.avg_score DESC, c1.cid ASC
-- 20、查询出只选修两门课程的学生学号和姓名
SELECT sid, sname
FROM student
WHERE sid IN (
    SELECT sid
    FROM grade
    GROUP BY sid
    HAVING count(sid) = 2
)
-- 21、查询课程名称为数学，且分数低于 60 的学生姓名和分数
SELECT s1.sid, s1.sname, g1.score
FROM student s1
         LEFT JOIN (
    SELECT sid, score
    FROM grade
    WHERE cid = (
        SELECT cid
        FROM course
        WHERE cname = '数学'
    )
      AND score < 60
) g1
                   ON s1.sid = g1.sid
WHERE g1.score < 60