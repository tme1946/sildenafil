package com.jnshu.sildenafil.system.service.impl;

import com.jnshu.sildenafil.system.domain.Student;
import com.jnshu.sildenafil.system.mapper.StudentDao;
import com.jnshu.sildenafil.system.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-30
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}
