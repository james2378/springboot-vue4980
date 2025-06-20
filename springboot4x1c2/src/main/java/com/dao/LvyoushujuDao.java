package com.dao;

import com.entity.LvyoushujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LvyoushujuVO;
import com.entity.view.LvyoushujuView;


/**
 * 旅游数据
 * 
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public interface LvyoushujuDao extends BaseMapper<LvyoushujuEntity> {
	
	List<LvyoushujuVO> selectListVO(@Param("ew") Wrapper<LvyoushujuEntity> wrapper);
	
	LvyoushujuVO selectVO(@Param("ew") Wrapper<LvyoushujuEntity> wrapper);
	
	List<LvyoushujuView> selectListView(@Param("ew") Wrapper<LvyoushujuEntity> wrapper);

	List<LvyoushujuView> selectListView(Pagination page,@Param("ew") Wrapper<LvyoushujuEntity> wrapper);
	
	LvyoushujuView selectView(@Param("ew") Wrapper<LvyoushujuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LvyoushujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LvyoushujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<LvyoushujuEntity> wrapper);



}
