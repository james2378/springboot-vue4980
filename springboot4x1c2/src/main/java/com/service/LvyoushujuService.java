package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LvyoushujuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LvyoushujuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LvyoushujuView;


/**
 * 旅游数据
 *
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
public interface LvyoushujuService extends IService<LvyoushujuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LvyoushujuVO> selectListVO(Wrapper<LvyoushujuEntity> wrapper);
   	
   	LvyoushujuVO selectVO(@Param("ew") Wrapper<LvyoushujuEntity> wrapper);
   	
   	List<LvyoushujuView> selectListView(Wrapper<LvyoushujuEntity> wrapper);
   	
   	LvyoushujuView selectView(@Param("ew") Wrapper<LvyoushujuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LvyoushujuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<LvyoushujuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<LvyoushujuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<LvyoushujuEntity> wrapper);



}

