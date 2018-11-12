package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.jnshu.sildenafil.common.validation.LikeAssetSave;
import com.jnshu.sildenafil.common.validation.LikeAssetUpdate;
import com.jnshu.sildenafil.common.validation.VideoUpdate;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihoo
 * @since 2018-10-31
 */
public class LikeAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞id
     */
    @NotNull(message = "{likeAsset.id.validation.error}", groups = { LikeAssetUpdate.class})
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
     * 学生id
     */
    @NotNull(message = "{likeAsset.studentId.validation.error}", groups = { LikeAssetUpdate.class})
    @TableField("student_id")
    private Long studentId;

    /**
     * 类型
     */
    @NotNull(message = "{likeAsset.type.validation.error}", groups = { LikeAssetUpdate.class,LikeAssetSave.class})
    @TableField("type")
    private Integer type;

    /**
     * 类型id
     */
    @NotNull(message = "{likeAsset.typeId.validation.error}", groups = { LikeAssetUpdate.class,LikeAssetSave.class})
    @TableField("type_id")
    private Long typeId;

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
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "LikeAsset{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", updateAt=" + updateAt +
        ", studentId=" + studentId +
        ", type=" + type +
        ", typeId=" + typeId +
        "}";
    }
}
