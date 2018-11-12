package com.jnshu.sildenafil.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.jnshu.sildenafil.common.validation.TeacherSave;
import com.jnshu.sildenafil.common.validation.TeacherUpdate;
import com.jnshu.sildenafil.common.validation.VideoUpdate;

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
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 老师id
     */
    @NotNull(message = "{teacher.id.validation.error}", groups = { TeacherUpdate.class})
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private Long createAt;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 昵称
     */
    @NotBlank(message = "{teacher.nickname.validation.error}", groups = { TeacherUpdate.class, TeacherSave.class})
    @TableField("nickname")
    private String nickname;

    /**
     * 头像
     */
    @NotBlank(message = "{teacher.img.validation.error}", groups = { TeacherUpdate.class, TeacherSave.class})
    @TableField("img")
    private String img;

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
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "id=" + id +
        ", createAt=" + createAt +
        ", createBy=" + createBy +
        ", nickname=" + nickname +
        ", img=" + img +
        "}";
    }
}
