package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jnshu.sildenafil.common.exception.ParamIsNullException;
import com.jnshu.sildenafil.common.exception.ServiceException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-10-31
 */
@SuppressWarnings("unused")
public interface TeacherService extends IService<Teacher> {

    /**
     * 后台查询老师昵称List
     * @return 老师昵称List
     */
    List getTeacherNameList();
    /**
     * 后台通过id查询老师详情
     * @param teacherId 老师id
     * @return 查询到的老师详情
     */
    Teacher getTeacherById(Long teacherId);


    /**
     * 新增老师信息详情
     * @param teacher 老师
     * @return 新增后返回的老师详情
     * @throws ServiceException service错误
     * @throws ParamIsNullException 参数为空
     */
    Teacher saveTeacher(Teacher teacher) throws ServiceException, ParamIsNullException;

    /**
     * 后台删除老师
     * @param teacherId 老师id
     * @return 是否成功删除老师
     */
    Boolean removeTeacherById(Long teacherId);

}
