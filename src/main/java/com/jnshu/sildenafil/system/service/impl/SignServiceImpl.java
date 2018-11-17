package com.jnshu.sildenafil.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jnshu.sildenafil.common.annotation.UseLog;
import com.jnshu.sildenafil.system.domain.Sign;
import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.mapper.SignDao;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.SignService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-02
 */
@Service
@Slf4j
public class SignServiceImpl extends ServiceImpl<SignDao, Sign> implements SignService {
    private static final long NOW = System.currentTimeMillis();
    private static final int DAY_SECOND = 86400;
    private static final int BEAN = 5;

    private final StudentDao studentDao;
    private final SignDao signDao;

    @Autowired(required = false)
    public SignServiceImpl(StudentDao studentDao, SignDao signDao) {
        this.studentDao = studentDao;
        this.signDao = signDao;
    }

    /**
     * 学生签到
     *
     * @param studentId 实体对象
     * @return 签到是否成功
     */
    @Override
    @UseLog("前台签到")
    public boolean addSign(Long studentId) {
        log.info("args for sign is: {}", studentId);
        Sign sign = new Sign();
        Student student = new Student();
        QueryWrapper<Sign> qw = new QueryWrapper<>();
        qw.eq("student_id", studentId).orderByDesc("create_at").last("limit 1");
        Sign studentSign = signDao.selectOne(qw);
        log.info("studentSign is: {}", studentSign);
        Student selectStudent = studentDao.selectById(studentId);
        log.info("selectStudent is {}", selectStudent);
        if (selectStudent == null) {
            log.info("StudentId doesn't exist.");
            return false;
        } else {
            if (studentSign != null) {
                Long lastSignDay = (signDao.selectOne(qw).getCreateAt() + 3600*8) / 1000 / DAY_SECOND;
                Long systemNowDay = NOW / 1000 / DAY_SECOND;
                log.info("lastSignDay is: {}", lastSignDay);
                log.info("systemNowDay is: {}", systemNowDay);
                if (lastSignDay.equals(systemNowDay)) {
                    log.info("Today is signed.");
                    return false;
                } else if (lastSignDay + 1 == systemNowDay) {
                    log.info("Today is not sign, and you can continuous sign in.");
                    int newContinuousSign = selectStudent.getContSign() + 1;
                    int bean = selectStudent.getBean();
                    if (newContinuousSign < BEAN) {
                        bean = bean + newContinuousSign;
                    } else {
                        bean = bean + BEAN;
                    }
                    int maxContinuousSign = Math.max(selectStudent.getMaxContSign(),newContinuousSign);
                    student.setId(studentId);
                    student.setContSign(newContinuousSign);
                    student.setBean(bean);
                    student.setMaxContSign(maxContinuousSign);
                    studentDao.updateById(student);
                } else {
                    log.info("Today is not sign, but you can't continuous sign in.");
                    int newContinuousSign = 1;
                    int bean = selectStudent.getBean() + 1;
                    student.setId(studentId);
                    student.setContSign(newContinuousSign);
                    student.setBean(bean);
                    studentDao.updateById(student);
                }
            } else {
                student.setBean(1);
                student.setMaxContSign(1);
                student.setContSign(1);
                student.setTotalSign(1);
                studentDao.updateById(student);
                sign.setCreateAt(NOW);
                sign.setStudentId(studentId);
                log.info("First sign in success.");
            }
            sign.setCreateAt(NOW);
            sign.setStudentId(studentId);
            signDao.insert(sign);
            qw.eq("student_id", studentId);
            int oldTotalSign = signDao.selectCount(qw);
            student.setId(studentId);
            student.setTotalSign(oldTotalSign);
            studentDao.updateById(student);
            int newTotalSign = selectStudent.getTotalSign();
            log.info("newTotalSignCount：" + newTotalSign);
            log.info("Sign in success.");
            return true;
        }
    }

    /**
     * 进入签到页面
     * 查询一个月（31天）签到记录
     * 根据签到记录判断当天是否签到
     * @param studentId 学生id
     * @return 该学生签到记录List
     */
    @Override
    @UseLog("前台获取签到列表")
    public List getSignList(Long studentId) {
        log.info("args for getSignList is: {}", studentId);
        QueryWrapper<Sign> signQueryWrapper = new QueryWrapper<>();
        List<Sign> signList = signDao.selectList(signQueryWrapper);
        List signTimelineList = signList.stream().map(Sign::getCreateAt).collect(Collectors.toList());
        log.info("result of getSignList is: {}", signTimelineList);
        return signTimelineList;
    }

}
