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
 * 景点
 *
 * @author 
 * @email
 */
@TableName("jingdian")
public class JingdianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingdianEntity() {

	}

	public JingdianEntity(T t) {
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
     * 景点名称
     */
    @ColumnInfo(comment="景点名称",type="varchar(200)")
    @TableField(value = "jingdian_name")

    private String jingdianName;


    /**
     * 景点编号
     */
    @ColumnInfo(comment="景点编号",type="varchar(200)")
    @TableField(value = "jingdian_uuid_number")

    private String jingdianUuidNumber;


    /**
     * 景点照片
     */
    @ColumnInfo(comment="景点照片",type="varchar(200)")
    @TableField(value = "jingdian_photo")

    private String jingdianPhoto;


    /**
     * 景点地点
     */
    @ColumnInfo(comment="景点地点",type="varchar(200)")
    @TableField(value = "jingdian_address")

    private String jingdianAddress;


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
    @TableField(value = "jingdian_content")

    private String jingdianContent;


    /**
     * 现代简介
     */
    @ColumnInfo(comment="现代简介",type="longtext")
    @TableField(value = "jingdian_xiandai_content")

    private String jingdianXiandaiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jingdian_delete")

    private Integer jingdianDelete;


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
	 * 获取：景点名称
	 */
    public String getJingdianName() {
        return jingdianName;
    }
    /**
	 * 设置：景点名称
	 */

    public void setJingdianName(String jingdianName) {
        this.jingdianName = jingdianName;
    }
    /**
	 * 获取：景点编号
	 */
    public String getJingdianUuidNumber() {
        return jingdianUuidNumber;
    }
    /**
	 * 设置：景点编号
	 */

    public void setJingdianUuidNumber(String jingdianUuidNumber) {
        this.jingdianUuidNumber = jingdianUuidNumber;
    }
    /**
	 * 获取：景点照片
	 */
    public String getJingdianPhoto() {
        return jingdianPhoto;
    }
    /**
	 * 设置：景点照片
	 */

    public void setJingdianPhoto(String jingdianPhoto) {
        this.jingdianPhoto = jingdianPhoto;
    }
    /**
	 * 获取：景点地点
	 */
    public String getJingdianAddress() {
        return jingdianAddress;
    }
    /**
	 * 设置：景点地点
	 */

    public void setJingdianAddress(String jingdianAddress) {
        this.jingdianAddress = jingdianAddress;
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
    public String getJingdianContent() {
        return jingdianContent;
    }
    /**
	 * 设置：历史介绍
	 */

    public void setJingdianContent(String jingdianContent) {
        this.jingdianContent = jingdianContent;
    }
    /**
	 * 获取：现代简介
	 */
    public String getJingdianXiandaiContent() {
        return jingdianXiandaiContent;
    }
    /**
	 * 设置：现代简介
	 */

    public void setJingdianXiandaiContent(String jingdianXiandaiContent) {
        this.jingdianXiandaiContent = jingdianXiandaiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJingdianDelete() {
        return jingdianDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJingdianDelete(Integer jingdianDelete) {
        this.jingdianDelete = jingdianDelete;
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
        return "Jingdian{" +
            ", id=" + id +
            ", jingdianName=" + jingdianName +
            ", jingdianUuidNumber=" + jingdianUuidNumber +
            ", jingdianPhoto=" + jingdianPhoto +
            ", jingdianAddress=" + jingdianAddress +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jingdianContent=" + jingdianContent +
            ", jingdianXiandaiContent=" + jingdianXiandaiContent +
            ", jingdianDelete=" + jingdianDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
