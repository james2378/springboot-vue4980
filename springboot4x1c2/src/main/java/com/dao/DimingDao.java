package com.dao;

import com.entity.DimingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DimingVO;
import com.entity.view.DimingView;


/**
 * 地名
 * 
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public interface DimingDao extends BaseMapper<DimingEntity> {
	
	List<DimingVO> selectListVO(@Param("ew") Wrapper<DimingEntity> wrapper);
	
	DimingVO selectVO(@Param("ew") Wrapper<DimingEntity> wrapper);
	
	List<DimingView> selectListView(@Param("ew") Wrapper<DimingEntity> wrapper);

	List<DimingView> selectListView(Pagination page,@Param("ew") Wrapper<DimingEntity> wrapper);
	
	DimingView selectView(@Param("ew") Wrapper<DimingEntity> wrapper);
	

}
