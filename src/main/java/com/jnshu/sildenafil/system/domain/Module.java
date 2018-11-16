package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.jnshu.sildenafil.common.validation.Save;
import com.jnshu.sildenafil.common.validation.Update;

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
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模块id
     */
    @NotNull(message ="{module.id.validation.error}" ,groups = {Update.class})
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
     * 模块名称
     */
    @NotBlank(message ="{module.name.validation.error}" ,groups = {Update.class,Save.class})
    @TableField("name")
    private String name;

    /**
     * 权限标识
     */
    @NotBlank(message ="{module.permission.validation.error}" ,groups = {Update.class,Save.class})
    @TableField("permission")
    private String permission;

    /**
     * 模块地址
     */
    @NotBlank(message ="{module.url.validation.error}" ,groups = {Update.class,Save.class})
    @TableField("url")
    private String url;

    /**
     * 模块类型,0为菜单,1为按钮，默认为0；
     */
    @NotNull(message ="{module.type.validation.error}" ,groups = {Update.class,Save.class})
    @TableField("type")
    private Integer type;

    /**
     * 父模块id
     */
    @NotNull(message ="{module.parentId.validation.error}" ,groups = {Update.class,Save.class})
    @TableField("parent_id")
    private Long parentId;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Module{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", name=" + name +
        ", permission=" + permission +
        ", url=" + url +
        ", type=" + type +
        ", parentId=" + parentId +
        "}";
    }
}
