package com.entity.model;

import com.entity.JingdianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 景点
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JingdianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 景点名称
     */
    private String jingdianName;


    /**
     * 景点编号
     */
    private String jingdianUuidNumber;


    /**
     * 景点照片
     */
    private String jingdianPhoto;


    /**
     * 景点地点
     */
    private String jingdianAddress;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 历史介绍
     */
    private String jingdianContent;


    /**
     * 现代简介
     */
    private String jingdianXiandaiContent;


    /**
     * 逻辑删除
     */
    private Integer jingdianDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
