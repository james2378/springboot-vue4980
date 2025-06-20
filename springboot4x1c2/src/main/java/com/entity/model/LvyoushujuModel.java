package com.entity.model;

import com.entity.LvyoushujuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 旅游数据
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public class LvyoushujuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
