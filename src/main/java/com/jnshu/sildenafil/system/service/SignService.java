package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.Sign;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihoo
 * @since 2018-11-02
 */
public interface SignService extends IService<Sign> {

    /**
     * 学生签到
     *
     * @param studentId 实体对象
     * @return 签到是否成功
     */
    boolean sign(Long studentId);


//    进入签到页面。加一个查询当天签到状态

}
