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
 * 预订
 *
 * @author 
 * @email
 */
@TableName("gonglue_order")
public class GonglueOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GonglueOrderEntity() {

	}

	public GonglueOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "gonglue_order_uuid_number")

    private String gonglueOrderUuidNumber;


    /**
     * 攻略
     */
    @ColumnInfo(comment="攻略",type="int(11)")
    @TableField(value = "gonglue_id")

    private Integer gonglueId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "gonglue_order_time")

    private Date gonglueOrderTime;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "gonglue_order_types")

    private Integer gonglueOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：订单编号
	 */
    public String getGonglueOrderUuidNumber() {
        return gonglueOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setGonglueOrderUuidNumber(String gonglueOrderUuidNumber) {
        this.gonglueOrderUuidNumber = gonglueOrderUuidNumber;
    }
    /**
	 * 获取：攻略
	 */
    public Integer getGonglueId() {
        return gonglueId;
    }
    /**
	 * 设置：攻略
	 */

    public void setGonglueId(Integer gonglueId) {
        this.gonglueId = gonglueId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getGonglueOrderTime() {
        return gonglueOrderTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setGonglueOrderTime(Date gonglueOrderTime) {
        this.gonglueOrderTime = gonglueOrderTime;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getGonglueOrderTypes() {
        return gonglueOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setGonglueOrderTypes(Integer gonglueOrderTypes) {
        this.gonglueOrderTypes = gonglueOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GonglueOrder{" +
            ", id=" + id +
            ", gonglueOrderUuidNumber=" + gonglueOrderUuidNumber +
            ", gonglueId=" + gonglueId +
            ", yonghuId=" + yonghuId +
            ", gonglueOrderTime=" + DateUtil.convertString(gonglueOrderTime,"yyyy-MM-dd") +
            ", gonglueOrderTypes=" + gonglueOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
