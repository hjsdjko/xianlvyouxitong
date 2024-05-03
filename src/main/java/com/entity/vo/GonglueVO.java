package com.entity.vo;

import com.entity.GonglueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 旅游攻略
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gonglue")
public class GonglueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 景点
     */

    @TableField(value = "jingdian_id")
    private Integer jingdianId;


    /**
     * 攻略名称
     */

    @TableField(value = "gonglue_name")
    private String gonglueName;


    /**
     * 攻略编号
     */

    @TableField(value = "gonglue_uuid_number")
    private String gonglueUuidNumber;


    /**
     * 攻略照片
     */

    @TableField(value = "gonglue_photo")
    private String gongluePhoto;


    /**
     * 出发地点
     */

    @TableField(value = "gonglue_chu_address")
    private String gonglueChuAddress;


    /**
     * 目的地点
     */

    @TableField(value = "gonglue_mu_address")
    private String gonglueMuAddress;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 历史介绍
     */

    @TableField(value = "gonglue_content")
    private String gonglueContent;


    /**
     * 现代简介
     */

    @TableField(value = "gonglue_xiandai_content")
    private String gonglueXiandaiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "gonglue_delete")
    private Integer gonglueDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：景点
	 */
    public Integer getJingdianId() {
        return jingdianId;
    }


    /**
	 * 获取：景点
	 */

    public void setJingdianId(Integer jingdianId) {
        this.jingdianId = jingdianId;
    }
    /**
	 * 设置：攻略名称
	 */
    public String getGonglueName() {
        return gonglueName;
    }


    /**
	 * 获取：攻略名称
	 */

    public void setGonglueName(String gonglueName) {
        this.gonglueName = gonglueName;
    }
    /**
	 * 设置：攻略编号
	 */
    public String getGonglueUuidNumber() {
        return gonglueUuidNumber;
    }


    /**
	 * 获取：攻略编号
	 */

    public void setGonglueUuidNumber(String gonglueUuidNumber) {
        this.gonglueUuidNumber = gonglueUuidNumber;
    }
    /**
	 * 设置：攻略照片
	 */
    public String getGongluePhoto() {
        return gongluePhoto;
    }


    /**
	 * 获取：攻略照片
	 */

    public void setGongluePhoto(String gongluePhoto) {
        this.gongluePhoto = gongluePhoto;
    }
    /**
	 * 设置：出发地点
	 */
    public String getGonglueChuAddress() {
        return gonglueChuAddress;
    }


    /**
	 * 获取：出发地点
	 */

    public void setGonglueChuAddress(String gonglueChuAddress) {
        this.gonglueChuAddress = gonglueChuAddress;
    }
    /**
	 * 设置：目的地点
	 */
    public String getGonglueMuAddress() {
        return gonglueMuAddress;
    }


    /**
	 * 获取：目的地点
	 */

    public void setGonglueMuAddress(String gonglueMuAddress) {
        this.gonglueMuAddress = gonglueMuAddress;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：历史介绍
	 */
    public String getGonglueContent() {
        return gonglueContent;
    }


    /**
	 * 获取：历史介绍
	 */

    public void setGonglueContent(String gonglueContent) {
        this.gonglueContent = gonglueContent;
    }
    /**
	 * 设置：现代简介
	 */
    public String getGonglueXiandaiContent() {
        return gonglueXiandaiContent;
    }


    /**
	 * 获取：现代简介
	 */

    public void setGonglueXiandaiContent(String gonglueXiandaiContent) {
        this.gonglueXiandaiContent = gonglueXiandaiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getGonglueDelete() {
        return gonglueDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGonglueDelete(Integer gonglueDelete) {
        this.gonglueDelete = gonglueDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
