package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DimingEntity;
import com.entity.view.DimingView;

import com.service.DimingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 * 地名
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
@RestController
@RequestMapping("/diming")
public class DimingController {
    @Autowired
    private DimingService dimingService;
    @Autowired
    private JavaSparkContext javaSparkContext;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DimingEntity diming,
		HttpServletRequest request){
        EntityWrapper<DimingEntity> ew = new EntityWrapper<DimingEntity>();

		PageUtils page = dimingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diming), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DimingEntity diming, 
		HttpServletRequest request){
        EntityWrapper<DimingEntity> ew = new EntityWrapper<DimingEntity>();

		PageUtils page = dimingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DimingEntity diming){
       	EntityWrapper<DimingEntity> ew = new EntityWrapper<DimingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diming, "diming")); 
        return R.ok().put("data", dimingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DimingEntity diming){
        EntityWrapper< DimingEntity> ew = new EntityWrapper< DimingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diming, "diming")); 
		DimingView dimingView =  dimingService.selectView(ew);
		return R.ok("查询地名成功").put("data", dimingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DimingEntity diming = dimingService.selectById(id);
        return R.ok().put("data", diming);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DimingEntity diming = dimingService.selectById(id);
        return R.ok().put("data", diming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DimingEntity diming, HttpServletRequest request){
    	diming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diming);
        dimingService.insert(diming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DimingEntity diming, HttpServletRequest request){
    	diming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(diming);
        dimingService.insert(diming);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DimingEntity diming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diming);
        dimingService.updateById(diming);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dimingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
