package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DimingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DimingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DimingView;


/**
 * 地名
 *
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public interface DimingService extends IService<DimingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DimingVO> selectListVO(Wrapper<DimingEntity> wrapper);
   	
   	DimingVO selectVO(@Param("ew") Wrapper<DimingEntity> wrapper);
   	
   	List<DimingView> selectListView(Wrapper<DimingEntity> wrapper);
   	
   	DimingView selectView(@Param("ew") Wrapper<DimingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DimingEntity> wrapper);
   	

}

