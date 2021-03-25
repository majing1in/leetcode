-- https://zhuanlan.zhihu.com/p/82845417

-- 1、求每门课程的学生人数
SELECT c1.CId, c1.Cname, s1.course_num
FROM Course c1
         LEFT JOIN (
    SELECT CId, count(CId) AS course_num
    FROM SC
    GROUP BY CId
) s1
                   ON s1.CId = c1.CId
-- 2、查询课程编号为 01 且课程成绩在 80 分及以上的学生的学号和姓名
SELECT SId, Sname
FROM Student
WHERE SId IN (
    SELECT SId
    FROM SC
    WHERE score >= 80
      AND CId = '01'
)
-- 3、统计每门课程的学生选修人数（超过 5 人的课程才统计）
SELECT co1.CId, co1.Cname, sc1.count_num
FROM Course co1
         LEFT JOIN (
    SELECT CId, count(SId) AS count_num
    FROM SC
    GROUP BY CId
    HAVING count(SId) > 5
) sc1
                   ON co1.CId = sc1.CId
-- 4、检索至少选修两门课程的学生学号
SELECT SId
FROM SC
GROUP BY SId
HAVING count(CId) >= 2
-- 5、选修了全部课程的学生信息
SELECT *
FROM Student
WHERE SId IN (
    SELECT SId
    FROM SC
    GROUP BY SId
    HAVING count(CId) = (
        SELECT count(DISTINCT CId)
        FROM Course
    )
)
-- 6、查询存在不及格的课程
SELECT c1.CId, c1.Cname
FROM Course c1
         LEFT JOIN (
    SELECT CId
    FROM SC
    WHERE score < 60
    GROUP BY CId
) s1
                   ON c1.CId = s1.CId
-- 7、查询任何一门课程成绩在 70 分以上的学生姓名、课程名称和分数
SELECT t1.Sname, c1.Cname, s1.score
FROM Student t1
         LEFT JOIN (
    SELECT score, CId, SId
    FROM SC
    WHERE score > 70
) s1
                   ON s1.SId = t1.SId
         LEFT JOIN Course c1 ON c1.CId = s1.CId
WHERE s1.score > 70
-- 8、查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）
SELECT t1.Sname, C1.Cname, s1.score
FROM Student t1
         LEFT JOIN (
    SELECT *
    FROM SC
) s1
                   ON s1.SId = t1.SId
         LEFT JOIN Course c1 ON c1.CId = s1.CId
-- 9、查询课程名称为「数学」，且分数低于 60 的学生姓名和分数
SELECT t1.Sname, s1.score
FROM student t1
         LEFT JOIN (
    SELECT SId, score
    FROM SC
    WHERE CId = (
        SELECT CId
        FROM Course
        WHERE Cname = '数学'
    )
      AND score < 60
) s1
                   ON t1.SId = s1.SId
WHERE s1.score < 60
-- 10、查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩
SELECT t1.SId, t1.Sname, s1.avg_score
FROM Student t1
         LEFT JOIN (
    SELECT SId, avg(score) AS avg_score
    FROM SC
    GROUP BY SId
    HAVING avg(score) >= 85
) s1
                   ON s1.SId = t1.SId
WHERE s1.avg_score >= 85


