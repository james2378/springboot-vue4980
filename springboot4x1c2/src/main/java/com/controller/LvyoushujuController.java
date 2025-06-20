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

import com.entity.LvyoushujuEntity;
import com.entity.view.LvyoushujuView;

import com.service.LvyoushujuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.service.StoreupService;
import com.entity.StoreupEntity;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

/**
 * 旅游数据
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-27 15:59:27
 */
@RestController
@RequestMapping("/lvyoushuju")
public class LvyoushujuController {
    @Autowired
    private LvyoushujuService lvyoushujuService;
    @Autowired
    private JavaSparkContext javaSparkContext;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LvyoushujuEntity lvyoushuju,
		HttpServletRequest request){
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();

		PageUtils page = lvyoushujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyoushuju), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LvyoushujuEntity lvyoushuju, 
		HttpServletRequest request){
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();

		PageUtils page = lvyoushujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyoushuju), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LvyoushujuEntity lvyoushuju){
       	EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lvyoushuju, "lvyoushuju")); 
        return R.ok().put("data", lvyoushujuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LvyoushujuEntity lvyoushuju){
        EntityWrapper< LvyoushujuEntity> ew = new EntityWrapper< LvyoushujuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lvyoushuju, "lvyoushuju")); 
		LvyoushujuView lvyoushujuView =  lvyoushujuService.selectView(ew);
		return R.ok("查询旅游数据成功").put("data", lvyoushujuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LvyoushujuEntity lvyoushuju = lvyoushujuService.selectById(id);
		lvyoushuju.setClicknum(lvyoushuju.getClicknum()+1);
		lvyoushuju.setClicktime(new Date());
		lvyoushujuService.updateById(lvyoushuju);
        return R.ok().put("data", lvyoushuju);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LvyoushujuEntity lvyoushuju = lvyoushujuService.selectById(id);
		lvyoushuju.setClicknum(lvyoushuju.getClicknum()+1);
		lvyoushuju.setClicktime(new Date());
		lvyoushujuService.updateById(lvyoushuju);
        return R.ok().put("data", lvyoushuju);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LvyoushujuEntity lvyoushuju, HttpServletRequest request){
    	lvyoushuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lvyoushuju);
        lvyoushujuService.insert(lvyoushuju);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LvyoushujuEntity lvyoushuju, HttpServletRequest request){
    	lvyoushuju.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lvyoushuju);
        lvyoushujuService.insert(lvyoushuju);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LvyoushujuEntity lvyoushuju, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lvyoushuju);
        lvyoushujuService.updateById(lvyoushuju);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lvyoushujuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LvyoushujuEntity lvyoushuju, HttpServletRequest request,String pre){
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = lvyoushujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyoushuju), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,LvyoushujuEntity lvyoushuju, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "diming";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "lvyoushuju").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<LvyoushujuEntity> lvyoushujuList = new ArrayList<LvyoushujuEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                lvyoushujuList.addAll(lvyoushujuService.selectList(new EntityWrapper<LvyoushujuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = lvyoushujuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyoushuju), params), params));
        List<LvyoushujuEntity> pageList = (List<LvyoushujuEntity>)page.getList();
        if(lvyoushujuList.size()<limit) {
            int toAddNum = (limit-lvyoushujuList.size())<=pageList.size()?(limit-lvyoushujuList.size()):pageList.size();
            for(LvyoushujuEntity o1 : pageList) {
                boolean addFlag = true;
                for(LvyoushujuEntity o2 : lvyoushujuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    lvyoushujuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(lvyoushujuList.size()>limit) {
            lvyoushujuList = lvyoushujuList.subList(0, limit);
        }
        page.setList(lvyoushujuList);
        return R.ok().put("data", page);
    }



    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    LvyoushujuEntity lvyoushujuEntity =new LvyoushujuEntity();
                    lvyoushujuEntity.setId(new Date().getTime());
                    String diming = CommonUtil.getCellValue(row.getCell(0));
                    lvyoushujuEntity.setDiming(diming);
                    String jingdianming = CommonUtil.getCellValue(row.getCell(1));
                    lvyoushujuEntity.setJingdianming(jingdianming);
                    String pinglunrenshu = CommonUtil.getCellValue(row.getCell(2));
                    lvyoushujuEntity.setPinglunrenshu(Integer.parseInt(pinglunrenshu));
                    String gonglveshuliang = CommonUtil.getCellValue(row.getCell(3));
                    lvyoushujuEntity.setGonglveshuliang(Integer.parseInt(gonglveshuliang));
                    String paiming = CommonUtil.getCellValue(row.getCell(4));
                    lvyoushujuEntity.setPaiming(Integer.parseInt(paiming));
                    String xingji = CommonUtil.getCellValue(row.getCell(5));
                    lvyoushujuEntity.setXingji(xingji);
                    String jingdu = CommonUtil.getCellValue(row.getCell(6));
                    lvyoushujuEntity.setJingdu(jingdu);
                    String weidu = CommonUtil.getCellValue(row.getCell(7));
                    lvyoushujuEntity.setWeidu(weidu);
                    String jianjie = CommonUtil.getCellValue(row.getCell(8));
                    lvyoushujuEntity.setJianjie(jianjie);
                     
                    //想数据库中添加新对象
                    lvyoushujuService.insert(lvyoushujuEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }

    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        List<Map<String, Object>> result = lvyoushujuService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = lvyoushujuService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        List<Map<String, Object>> result = lvyoushujuService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = lvyoushujuService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        List<Map<String, Object>> result = lvyoushujuService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        List<Map<String, Object>> result2 = new ArrayList<Map<String,Object>>();
        for(Map<String, Object> m : result) {
            List<Tuple2<String, Object>> data = new ArrayList<>();
            for(String s : m.keySet()) {
                data.add(new Tuple2<>(s, m.get(s)));
            }
            JavaPairRDD<String, Object> originRDD = javaSparkContext.parallelizePairs(data);
            result2.add(originRDD.collectAsMap());
        }
        return R.ok().put("data", result2);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,LvyoushujuEntity lvyoushuju, HttpServletRequest request){
        EntityWrapper<LvyoushujuEntity> ew = new EntityWrapper<LvyoushujuEntity>();
        int count = lvyoushujuService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lvyoushuju), params), params));
        return R.ok().put("data", count);
    }


}
