package com.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Arrays;

/**
 * <p>
 * 
 * </p>
 *
 * @author doll
 * @since 2022-07-10
 */
@TableName("demo_personnel")
public class DemoPersonnel extends Model<DemoPersonnel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;
    /**
     * 状态(1：启用  2：关闭）
     */
    private Integer status;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 个人介绍
     */
    private String profile;
    /**
     * 相片
     */
    private String photo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DemoPersonnel{" +
        "id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", status=" + status +
        ", hobby=" + hobby +
        ", profile=" + profile +
        ", photo=" + photo +
        "}";
    }
}
