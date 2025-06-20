package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 旅游数据
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
@TableName("lvyoushuju")
public class LvyoushujuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LvyoushujuEntity() {
		
	}
	
	public LvyoushujuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 地名
	 */
					
	private String diming;
	
	/**
	 * 景点名
	 */
					
	private String jingdianming;
	
	/**
	 * 评论人数
	 */
					
	private Integer pinglunrenshu;
	
	/**
	 * 攻略数量
	 */
					
	private Integer gonglveshuliang;
	
	/**
	 * 排名
	 */
					
	private Integer paiming;
	
	/**
	 * 星级
	 */
					
	private String xingji;
	
	/**
	 * 经度
	 */
					
	private String jingdu;
	
	/**
	 * 纬度
	 */
					
	private String weidu;
	
	/**
	 * 封面图片
	 */
					
	private String fengmiantupian;
	
	/**
	 * 简介
	 */
					
	private String jianjie;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：地名
	 */
	public void setDiming(String diming) {
		this.diming = diming;
	}
	/**
	 * 获取：地名
	 */
	public String getDiming() {
		return diming;
	}
	/**
	 * 设置：景点名
	 */
	public void setJingdianming(String jingdianming) {
		this.jingdianming = jingdianming;
	}
	/**
	 * 获取：景点名
	 */
	public String getJingdianming() {
		return jingdianming;
	}
	/**
	 * 设置：评论人数
	 */
	public void setPinglunrenshu(Integer pinglunrenshu) {
		this.pinglunrenshu = pinglunrenshu;
	}
	/**
	 * 获取：评论人数
	 */
	public Integer getPinglunrenshu() {
		return pinglunrenshu;
	}
	/**
	 * 设置：攻略数量
	 */
	public void setGonglveshuliang(Integer gonglveshuliang) {
		this.gonglveshuliang = gonglveshuliang;
	}
	/**
	 * 获取：攻略数量
	 */
	public Integer getGonglveshuliang() {
		return gonglveshuliang;
	}
	/**
	 * 设置：排名
	 */
	public void setPaiming(Integer paiming) {
		this.paiming = paiming;
	}
	/**
	 * 获取：排名
	 */
	public Integer getPaiming() {
		return paiming;
	}
	/**
	 * 设置：星级
	 */
	public void setXingji(String xingji) {
		this.xingji = xingji;
	}
	/**
	 * 获取：星级
	 */
	public String getXingji() {
		return xingji;
	}
	/**
	 * 设置：经度
	 */
	public void setJingdu(String jingdu) {
		this.jingdu = jingdu;
	}
	/**
	 * 获取：经度
	 */
	public String getJingdu() {
		return jingdu;
	}
	/**
	 * 设置：纬度
	 */
	public void setWeidu(String weidu) {
		this.weidu = weidu;
	}
	/**
	 * 获取：纬度
	 */
	public String getWeidu() {
		return weidu;
	}
	/**
	 * 设置：封面图片
	 */
	public void setFengmiantupian(String fengmiantupian) {
		this.fengmiantupian = fengmiantupian;
	}
	/**
	 * 获取：封面图片
	 */
	public String getFengmiantupian() {
		return fengmiantupian;
	}
	/**
	 * 设置：简介
	 */
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	/**
	 * 获取：简介
	 */
	public String getJianjie() {
		return jianjie;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
