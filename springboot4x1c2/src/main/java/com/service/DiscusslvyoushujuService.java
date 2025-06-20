package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslvyoushujuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslvyoushujuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslvyoushujuView;


/**
 * 旅游数据评论表
 *
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public interface DiscusslvyoushujuService extends IService<DiscusslvyoushujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslvyoushujuVO> selectListVO(Wrapper<DiscusslvyoushujuEntity> wrapper);
   	
   	DiscusslvyoushujuVO selectVO(@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);
   	
   	List<DiscusslvyoushujuView> selectListView(Wrapper<DiscusslvyoushujuEntity> wrapper);
   	
   	DiscusslvyoushujuView selectView(@Param("ew") Wrapper<DiscusslvyoushujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslvyoushujuEntity> wrapper);
   	

}

