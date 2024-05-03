package com.entity.vo;

import com.entity.GonglueOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预订
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gonglue_order")
public class GonglueOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "gonglue_order_uuid_number")
    private String gonglueOrderUuidNumber;


    /**
     * 攻略
     */

    @TableField(value = "gonglue_id")
    private Integer gonglueId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "gonglue_order_time")
    private Date gonglueOrderTime;


    /**
     * 订单类型
     */

    @TableField(value = "gonglue_order_types")
    private Integer gonglueOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getGonglueOrderUuidNumber() {
        return gonglueOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setGonglueOrderUuidNumber(String gonglueOrderUuidNumber) {
        this.gonglueOrderUuidNumber = gonglueOrderUuidNumber;
    }
    /**
	 * 设置：攻略
	 */
    public Integer getGonglueId() {
        return gonglueId;
    }


    /**
	 * 获取：攻略
	 */

    public void setGonglueId(Integer gonglueId) {
        this.gonglueId = gonglueId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getGonglueOrderTime() {
        return gonglueOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setGonglueOrderTime(Date gonglueOrderTime) {
        this.gonglueOrderTime = gonglueOrderTime;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getGonglueOrderTypes() {
        return gonglueOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setGonglueOrderTypes(Integer gonglueOrderTypes) {
        this.gonglueOrderTypes = gonglueOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
