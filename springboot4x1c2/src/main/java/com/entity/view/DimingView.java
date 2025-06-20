package com.entity.view;

import com.entity.DimingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 地名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
@TableName("diming")
public class DimingView  extends DimingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DimingView(){
	}
 
 	public DimingView(DimingEntity dimingEntity){
 	try {
			BeanUtils.copyProperties(this, dimingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
