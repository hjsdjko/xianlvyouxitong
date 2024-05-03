package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingdianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 旅游景点收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingdian_collection")
public class JingdianCollectionView extends JingdianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jingdianCollectionValue;

	//级联表 景点
		/**
		* 景点名称
		*/

		@ColumnInfo(comment="景点名称",type="varchar(200)")
		private String jingdianName;
		/**
		* 景点编号
		*/

		@ColumnInfo(comment="景点编号",type="varchar(200)")
		private String jingdianUuidNumber;
		/**
		* 景点照片
		*/

		@ColumnInfo(comment="景点照片",type="varchar(200)")
		private String jingdianPhoto;
		/**
		* 景点地点
		*/

		@ColumnInfo(comment="景点地点",type="varchar(200)")
		private String jingdianAddress;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 历史介绍
		*/

		@ColumnInfo(comment="历史介绍",type="longtext")
		private String jingdianContent;
		/**
		* 现代简介
		*/

		@ColumnInfo(comment="现代简介",type="longtext")
		private String jingdianXiandaiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jingdianDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public JingdianCollectionView() {

	}

	public JingdianCollectionView(JingdianCollectionEntity jingdianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jingdianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJingdianCollectionValue() {
		return jingdianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJingdianCollectionValue(String jingdianCollectionValue) {
		this.jingdianCollectionValue = jingdianCollectionValue;
	}


	//级联表的get和set 景点

		/**
		* 获取： 景点名称
		*/
		public String getJingdianName() {
			return jingdianName;
		}
		/**
		* 设置： 景点名称
		*/
		public void setJingdianName(String jingdianName) {
			this.jingdianName = jingdianName;
		}

		/**
		* 获取： 景点编号
		*/
		public String getJingdianUuidNumber() {
			return jingdianUuidNumber;
		}
		/**
		* 设置： 景点编号
		*/
		public void setJingdianUuidNumber(String jingdianUuidNumber) {
			this.jingdianUuidNumber = jingdianUuidNumber;
		}

		/**
		* 获取： 景点照片
		*/
		public String getJingdianPhoto() {
			return jingdianPhoto;
		}
		/**
		* 设置： 景点照片
		*/
		public void setJingdianPhoto(String jingdianPhoto) {
			this.jingdianPhoto = jingdianPhoto;
		}

		/**
		* 获取： 景点地点
		*/
		public String getJingdianAddress() {
			return jingdianAddress;
		}
		/**
		* 设置： 景点地点
		*/
		public void setJingdianAddress(String jingdianAddress) {
			this.jingdianAddress = jingdianAddress;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 历史介绍
		*/
		public String getJingdianContent() {
			return jingdianContent;
		}
		/**
		* 设置： 历史介绍
		*/
		public void setJingdianContent(String jingdianContent) {
			this.jingdianContent = jingdianContent;
		}

		/**
		* 获取： 现代简介
		*/
		public String getJingdianXiandaiContent() {
			return jingdianXiandaiContent;
		}
		/**
		* 设置： 现代简介
		*/
		public void setJingdianXiandaiContent(String jingdianXiandaiContent) {
			this.jingdianXiandaiContent = jingdianXiandaiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJingdianDelete() {
			return jingdianDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJingdianDelete(Integer jingdianDelete) {
			this.jingdianDelete = jingdianDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "JingdianCollectionView{" +
			", jingdianCollectionValue=" + jingdianCollectionValue +
			", jingdianName=" + jingdianName +
			", jingdianUuidNumber=" + jingdianUuidNumber +
			", jingdianPhoto=" + jingdianPhoto +
			", jingdianAddress=" + jingdianAddress +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jingdianContent=" + jingdianContent +
			", jingdianXiandaiContent=" + jingdianXiandaiContent +
			", jingdianDelete=" + jingdianDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
