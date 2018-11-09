package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface StudentService extends IService<Student> {
    Student login (String openId);
    IPage studentFuzzySelect(Integer page, Integer size,
            Long id,String nickname,Integer grade
            ,String email,Long phone,Integer status
            ,Integer minBean,Integer maxBean);
}
