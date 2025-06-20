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


import com.dao.LvyoushujuDao;
import com.entity.LvyoushujuEntity;
import com.service.LvyoushujuService;
import com.entity.vo.LvyoushujuVO;
import com.entity.view.LvyoushujuView;

@Service("lvyoushujuService")
public class LvyoushujuServiceImpl extends ServiceImpl<LvyoushujuDao, LvyoushujuEntity> implements LvyoushujuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LvyoushujuEntity> page = this.selectPage(
                new Query<LvyoushujuEntity>(params).getPage(),
                new EntityWrapper<LvyoushujuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LvyoushujuEntity> wrapper) {
		  Page<LvyoushujuView> page =new Query<LvyoushujuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LvyoushujuVO> selectListVO(Wrapper<LvyoushujuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LvyoushujuVO selectVO(Wrapper<LvyoushujuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LvyoushujuView> selectListView(Wrapper<LvyoushujuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LvyoushujuView selectView(Wrapper<LvyoushujuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<LvyoushujuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<LvyoushujuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<LvyoushujuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
