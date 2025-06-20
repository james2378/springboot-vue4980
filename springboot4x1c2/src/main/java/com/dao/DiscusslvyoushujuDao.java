package com.dao;

import com.entity.DiscusslvyoushujuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslvyoushujuVO;
import com.entity.view.DiscusslvyoushujuView;


/**
 * 旅游数据评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public interface DiscusslvyoushujuDao extends BaseMapper<DiscusslvyoushujuEntity> {
	
	List<DiscusslvyoushujuVO> selectListVO(@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);
	
	DiscusslvyoushujuVO selectVO(@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);
	
	List<DiscusslvyoushujuView> selectListView(@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);

	List<DiscusslvyoushujuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);
	
	DiscusslvyoushujuView selectView(@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);
	

}
