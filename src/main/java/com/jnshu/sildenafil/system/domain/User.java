package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.jnshu.sildenafil.common.validation.UserSave;
import com.jnshu.sildenafil.common.validation.UserUpdate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Taimur
 * @since 2018-10-31
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @NotNull(message ="{user.userId.validation.error}" ,groups = {UserUpdate.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 更新时间
     */
    @TableField("update_at")
    private Long updateAt;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 后台账户名
     */
    @Min(value = 6,message = "{user.userName.validation.minError}",groups = {UserSave.class})
    @Max(value = 16,message = "{user.userName.validation.maxError}",groups = {UserSave.class})
    @NotBlank(message ="{user.userName.validation.error}" ,groups = {UserSave.class})
    @TableField("user_name")
    private String userName;

    /**
     * 后台账户密码
     */
    @Min(value = 6,message = "{user.password.validation.minError}",groups = {UserSave.class,UserUpdate.class})
    @Max(value = 16,message = "{user.password.validation.maxError}",groups = {UserSave.class,UserUpdate.class})
    @NotBlank(message ="{user.password.validation.error}" ,groups = {UserSave.class,UserUpdate.class})
    @TableField("password")
    private String password;

    /**
     * 角色id
     */
    @NotNull(message ="{user.roleId.validation.error}" ,groups = {UserUpdate.class,UserSave.class})
    @TableField("role_id")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }
    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", userName=" + userName +
        ", password=" + password +
        ", roleId=" + roleId +
        "}";
    }
}
