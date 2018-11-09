package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jnshu.sildenafil.util.MyPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface StudentService extends IService<Student> {
    /**
     * 用户查询（通过openId） 
     * @param [openId]
     * @return  com.jnshu.sildenafil.system.domain.Student
     */
    Student login (String openId);
    /**
     * 模糊查询用户列表 
     * @param [page, size, id, nickname, grade, email, phone, status, minBean, maxBean]
     * @return  com.baomidou.mybatisplus.core.metadata.IPage
     */
    IPage studentFuzzySelect(Integer page, Integer size,
                             Long id, String nickname, Integer grade
            , String email, Long phone, Integer status
            , Integer minBean, Integer maxBean);
}
