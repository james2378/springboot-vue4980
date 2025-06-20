package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusslvyoushujuDao;
import com.entity.DiscusslvyoushujuEntity;
import com.service.DiscusslvyoushujuService;
import com.entity.vo.DiscusslvyoushujuVO;
import com.entity.view.DiscusslvyoushujuView;

@Service("discusslvyoushujuService")
public class DiscusslvyoushujuServiceImpl extends ServiceImpl<DiscusslvyoushujuDao, DiscusslvyoushujuEntity> implements DiscusslvyoushujuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslvyoushujuEntity> page = this.selectPage(
                new Query<DiscusslvyoushujuEntity>(params).getPage(),
                new EntityWrapper<DiscusslvyoushujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslvyoushujuEntity> wrapper) {
		  Page<DiscusslvyoushujuView> page =new Query<DiscusslvyoushujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslvyoushujuVO> selectListVO(Wrapper<DiscusslvyoushujuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslvyoushujuVO selectVO(Wrapper<DiscusslvyoushujuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslvyoushujuView> selectListView(Wrapper<DiscusslvyoushujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslvyoushujuView selectView(Wrapper<DiscusslvyoushujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
