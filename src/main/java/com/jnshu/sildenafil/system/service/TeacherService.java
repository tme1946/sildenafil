package com.jnshu.sildenafil.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jnshu.sildenafil.system.domain.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-10-31
 */
public interface TeacherService extends IService<Teacher> {

//    IPage getTeacherPage(Integer page, Integer size, );

    /**
     * 后台通过id查询老师详情
     * @param teacherId 老师id
     * @return 查询到的老师详情
     */
    Teacher getTeacherById(Long teacherId);

    /**
     * 后台新增老师详情
     * @param teacher 老师
     * @return 新增后返回的老师详情
     */
    Teacher saveTeacher(Teacher teacher);

    /**
     * 后台删除老师
     * @param teacherId 老师id
     * @return 是否成功删除老师
     */
    Boolean removeTeacherById(Long teacherId);

}
