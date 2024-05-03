package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 旅游攻略
 *
 * @author 
 * @email
 */
@TableName("gonglue")
public class GonglueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GonglueEntity() {

	}

	public GonglueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 景点
     */
    @ColumnInfo(comment="景点",type="int(11)")
    @TableField(value = "jingdian_id")

    private Integer jingdianId;


    /**
     * 攻略名称
     */
    @ColumnInfo(comment="攻略名称",type="varchar(200)")
    @TableField(value = "gonglue_name")

    private String gonglueName;


    /**
     * 攻略编号
     */
    @ColumnInfo(comment="攻略编号",type="varchar(200)")
    @TableField(value = "gonglue_uuid_number")

    private String gonglueUuidNumber;


    /**
     * 攻略照片
     */
    @ColumnInfo(comment="攻略照片",type="varchar(200)")
    @TableField(value = "gonglue_photo")

    private String gongluePhoto;


    /**
     * 出发地点
     */
    @ColumnInfo(comment="出发地点",type="varchar(200)")
    @TableField(value = "gonglue_chu_address")

    private String gonglueChuAddress;


    /**
     * 目的地点
     */
    @ColumnInfo(comment="目的地点",type="varchar(200)")
    @TableField(value = "gonglue_mu_address")

    private String gonglueMuAddress;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 历史介绍
     */
    @ColumnInfo(comment="历史介绍",type="longtext")
    @TableField(value = "gonglue_content")

    private String gonglueContent;


    /**
     * 现代简介
     */
    @ColumnInfo(comment="现代简介",type="longtext")
    @TableField(value = "gonglue_xiandai_content")

    private String gonglueXiandaiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "gonglue_delete")

    private Integer gonglueDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：景点
	 */
    public Integer getJingdianId() {
        return jingdianId;
    }
    /**
	 * 设置：景点
	 */

    public void setJingdianId(Integer jingdianId) {
        this.jingdianId = jingdianId;
    }
    /**
	 * 获取：攻略名称
	 */
    public String getGonglueName() {
        return gonglueName;
    }
    /**
	 * 设置：攻略名称
	 */

    public void setGonglueName(String gonglueName) {
        this.gonglueName = gonglueName;
    }
    /**
	 * 获取：攻略编号
	 */
    public String getGonglueUuidNumber() {
        return gonglueUuidNumber;
    }
    /**
	 * 设置：攻略编号
	 */

    public void setGonglueUuidNumber(String gonglueUuidNumber) {
        this.gonglueUuidNumber = gonglueUuidNumber;
    }
    /**
	 * 获取：攻略照片
	 */
    public String getGongluePhoto() {
        return gongluePhoto;
    }
    /**
	 * 设置：攻略照片
	 */

    public void setGongluePhoto(String gongluePhoto) {
        this.gongluePhoto = gongluePhoto;
    }
    /**
	 * 获取：出发地点
	 */
    public String getGonglueChuAddress() {
        return gonglueChuAddress;
    }
    /**
	 * 设置：出发地点
	 */

    public void setGonglueChuAddress(String gonglueChuAddress) {
        this.gonglueChuAddress = gonglueChuAddress;
    }
    /**
	 * 获取：目的地点
	 */
    public String getGonglueMuAddress() {
        return gonglueMuAddress;
    }
    /**
	 * 设置：目的地点
	 */

    public void setGonglueMuAddress(String gonglueMuAddress) {
        this.gonglueMuAddress = gonglueMuAddress;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：历史介绍
	 */
    public String getGonglueContent() {
        return gonglueContent;
    }
    /**
	 * 设置：历史介绍
	 */

    public void setGonglueContent(String gonglueContent) {
        this.gonglueContent = gonglueContent;
    }
    /**
	 * 获取：现代简介
	 */
    public String getGonglueXiandaiContent() {
        return gonglueXiandaiContent;
    }
    /**
	 * 设置：现代简介
	 */

    public void setGonglueXiandaiContent(String gonglueXiandaiContent) {
        this.gonglueXiandaiContent = gonglueXiandaiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGonglueDelete() {
        return gonglueDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGonglueDelete(Integer gonglueDelete) {
        this.gonglueDelete = gonglueDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gonglue{" +
            ", id=" + id +
            ", jingdianId=" + jingdianId +
            ", gonglueName=" + gonglueName +
            ", gonglueUuidNumber=" + gonglueUuidNumber +
            ", gongluePhoto=" + gongluePhoto +
            ", gonglueChuAddress=" + gonglueChuAddress +
            ", gonglueMuAddress=" + gonglueMuAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", gonglueContent=" + gonglueContent +
            ", gonglueXiandaiContent=" + gonglueXiandaiContent +
            ", gonglueDelete=" + gonglueDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
