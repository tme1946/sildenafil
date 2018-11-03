package com.jnshu.sildenafil.system.service;

import com.jnshu.sildenafil.system.domain.Sign;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public interface SignService extends IService<Sign> {

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param studentId 实体对象
     * @return 签到是否成功
     */
    boolean sign(Long studentId);

}
