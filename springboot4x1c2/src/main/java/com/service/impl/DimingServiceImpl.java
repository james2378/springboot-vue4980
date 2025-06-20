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


import com.dao.DimingDao;
import com.entity.DimingEntity;
import com.service.DimingService;
import com.entity.vo.DimingVO;
import com.entity.view.DimingView;

@Service("dimingService")
public class DimingServiceImpl extends ServiceImpl<DimingDao, DimingEntity> implements DimingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DimingEntity> page = this.selectPage(
                new Query<DimingEntity>(params).getPage(),
                new EntityWrapper<DimingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DimingEntity> wrapper) {
		  Page<DimingView> page =new Query<DimingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DimingVO> selectListVO(Wrapper<DimingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DimingVO selectVO(Wrapper<DimingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DimingView> selectListView(Wrapper<DimingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DimingView selectView(Wrapper<DimingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
