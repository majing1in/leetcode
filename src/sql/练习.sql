-- https://blog.csdn.net/qq_41080850/article/details/84593860?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-1&spm=1001.2101.3001.4242
-- 查询01课程比02课程成绩高的学生信息及课程分数
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
-- 查询同时选修了01课程和02课程的学生的课程分数
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
-- 查询存在01课程但可能不存在02课程的情况
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
-- 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩
SELECT *
FROM (
         SELECT sid, avg(score) AS avg_score
         FROM grade
         GROUP BY sid
         HAVING avg_score > 60
     ) g1
         LEFT JOIN student USING (sid)
-- 查询没有学全所有课程的同学的信息
SELECT *
FROM student
         INNER JOIN (
    SELECT sid
    FROM grade
    GROUP BY sid
    HAVING count(cid) < 4
) c1 USING (sid)
-- 查询至少有一门课与学号为01 的同学所学相同的同学的信息
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
-- 查询没学过张衡老师讲授的任一门课程的学生姓名
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
-- 检索01课程分数小于 60，按分数降序排列的学生信息
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