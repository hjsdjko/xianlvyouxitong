
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 旅游攻略
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/gonglue")
public class GonglueController {
    private static final Logger logger = LoggerFactory.getLogger(GonglueController.class);

    private static final String TABLE_NAME = "gonglue";

    @Autowired
    private GonglueService gonglueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonglueCollectionService gonglueCollectionService;//旅游攻略收藏
    @Autowired
    private GonglueOrderService gonglueOrderService;//预订
    @Autowired
    private JingdianService jingdianService;//景点
    @Autowired
    private JingdianCollectionService jingdianCollectionService;//旅游景点收藏
    @Autowired
    private JingdianLiuyanService jingdianLiuyanService;//景点留言
    @Autowired
    private NewsService newsService;//新闻资讯
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("gonglueDeleteStart",1);params.put("gonglueDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = gonglueService.queryPage(params);

        //字典表数据转换
        List<GonglueView> list =(List<GonglueView>)page.getList();
        for(GonglueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GonglueEntity gonglue = gonglueService.selectById(id);
        if(gonglue !=null){
            //entity转view
            GonglueView view = new GonglueView();
            BeanUtils.copyProperties( gonglue , view );//把实体数据重构到view中
            //级联表 景点
            //级联表
            JingdianEntity jingdian = jingdianService.selectById(gonglue.getJingdianId());
            if(jingdian != null){
            BeanUtils.copyProperties( jingdian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJingdianId(jingdian.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GonglueEntity gonglue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,gonglue:{}",this.getClass().getName(),gonglue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<GonglueEntity> queryWrapper = new EntityWrapper<GonglueEntity>()
            .eq("jingdian_id", gonglue.getJingdianId())
            .eq("gonglue_name", gonglue.getGonglueName())
            .eq("gonglue_chu_address", gonglue.getGonglueChuAddress())
            .eq("gonglue_mu_address", gonglue.getGonglueMuAddress())
            .eq("zan_number", gonglue.getZanNumber())
            .eq("cai_number", gonglue.getCaiNumber())
            .eq("gonglue_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GonglueEntity gonglueEntity = gonglueService.selectOne(queryWrapper);
        if(gonglueEntity==null){
            gonglue.setGonglueDelete(1);
            gonglue.setInsertTime(new Date());
            gonglue.setCreateTime(new Date());
            gonglueService.insert(gonglue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody GonglueEntity gonglue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,gonglue:{}",this.getClass().getName(),gonglue.toString());
        GonglueEntity oldGonglueEntity = gonglueService.selectById(gonglue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(gonglue.getGongluePhoto()) || "null".equals(gonglue.getGongluePhoto())){
                gonglue.setGongluePhoto(null);
        }

            gonglueService.updateById(gonglue);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<GonglueEntity> oldGonglueList =gonglueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<GonglueEntity> list = new ArrayList<>();
        for(Integer id:ids){
            GonglueEntity gonglueEntity = new GonglueEntity();
            gonglueEntity.setId(id);
            gonglueEntity.setGonglueDelete(2);
            list.add(gonglueEntity);
        }
        if(list != null && list.size() >0){
            gonglueService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<GonglueEntity> gonglueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            GonglueEntity gonglueEntity = new GonglueEntity();
//                            gonglueEntity.setJingdianId(Integer.valueOf(data.get(0)));   //景点 要改的
//                            gonglueEntity.setGonglueName(data.get(0));                    //攻略名称 要改的
//                            gonglueEntity.setGonglueUuidNumber(data.get(0));                    //攻略编号 要改的
//                            gonglueEntity.setGongluePhoto("");//详情和图片
//                            gonglueEntity.setGonglueChuAddress(data.get(0));                    //出发地点 要改的
//                            gonglueEntity.setGonglueMuAddress(data.get(0));                    //目的地点 要改的
//                            gonglueEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            gonglueEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            gonglueEntity.setGonglueContent("");//详情和图片
//                            gonglueEntity.setGonglueXiandaiContent("");//详情和图片
//                            gonglueEntity.setGonglueDelete(1);//逻辑删除字段
//                            gonglueEntity.setInsertTime(date);//时间
//                            gonglueEntity.setCreateTime(date);//时间
                            gonglueList.add(gonglueEntity);


                            //把要查询是否重复的字段放入map中
                                //攻略编号
                                if(seachFields.containsKey("gonglueUuidNumber")){
                                    List<String> gonglueUuidNumber = seachFields.get("gonglueUuidNumber");
                                    gonglueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> gonglueUuidNumber = new ArrayList<>();
                                    gonglueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("gonglueUuidNumber",gonglueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //攻略编号
                        List<GonglueEntity> gonglueEntities_gonglueUuidNumber = gonglueService.selectList(new EntityWrapper<GonglueEntity>().in("gonglue_uuid_number", seachFields.get("gonglueUuidNumber")).eq("gonglue_delete", 1));
                        if(gonglueEntities_gonglueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(GonglueEntity s:gonglueEntities_gonglueUuidNumber){
                                repeatFields.add(s.getGonglueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [攻略编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        gonglueService.insertBatch(gonglueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<GonglueView> returnGonglueViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = gonglueOrderService.queryPage(params1);
        List<GonglueOrderView> orderViewsList =(List<GonglueOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
//        for(GonglueOrderView orderView:orderViewsList){
//            Integer gonglueTypes = orderView.getGonglueTypes();
//            if(typeMap.containsKey(gonglueTypes)){
//                typeMap.put(gonglueTypes,typeMap.get(gonglueTypes)+1);
//            }else{
//                typeMap.put(gonglueTypes,1);
//            }
//        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("gonglueTypes",type);
            PageUtils pageUtils1 = gonglueService.queryPage(params2);
            List<GonglueView> gonglueViewList =(List<GonglueView>)pageUtils1.getList();
            returnGonglueViewList.addAll(gonglueViewList);
            if(returnGonglueViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = gonglueService.queryPage(params);
        if(returnGonglueViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnGonglueViewList.size();//要添加的数量
            List<GonglueView> gonglueViewList =(List<GonglueView>)page.getList();
            for(GonglueView gonglueView:gonglueViewList){
                Boolean addFlag = true;
                for(GonglueView returnGonglueView:returnGonglueViewList){
                    if(returnGonglueView.getId().intValue() ==gonglueView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnGonglueViewList.add(gonglueView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnGonglueViewList = returnGonglueViewList.subList(0, limit);
        }

        for(GonglueView c:returnGonglueViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnGonglueViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = gonglueService.queryPage(params);

        //字典表数据转换
        List<GonglueView> list =(List<GonglueView>)page.getList();
        for(GonglueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        GonglueEntity gonglue = gonglueService.selectById(id);
            if(gonglue !=null){


                //entity转view
                GonglueView view = new GonglueView();
                BeanUtils.copyProperties( gonglue , view );//把实体数据重构到view中

                //级联表
                    JingdianEntity jingdian = jingdianService.selectById(gonglue.getJingdianId());
                if(jingdian != null){
                    BeanUtils.copyProperties( jingdian , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJingdianId(jingdian.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody GonglueEntity gonglue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,gonglue:{}",this.getClass().getName(),gonglue.toString());
        Wrapper<GonglueEntity> queryWrapper = new EntityWrapper<GonglueEntity>()
            .eq("jingdian_id", gonglue.getJingdianId())
            .eq("gonglue_name", gonglue.getGonglueName())
            .eq("gonglue_uuid_number", gonglue.getGonglueUuidNumber())
            .eq("gonglue_chu_address", gonglue.getGonglueChuAddress())
            .eq("gonglue_mu_address", gonglue.getGonglueMuAddress())
            .eq("zan_number", gonglue.getZanNumber())
            .eq("cai_number", gonglue.getCaiNumber())
            .eq("gonglue_delete", gonglue.getGonglueDelete())
//            .notIn("gonglue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GonglueEntity gonglueEntity = gonglueService.selectOne(queryWrapper);
        if(gonglueEntity==null){
                gonglue.setZanNumber(1);
                gonglue.setCaiNumber(1);
            gonglue.setGonglueDelete(1);
            gonglue.setInsertTime(new Date());
            gonglue.setCreateTime(new Date());
        gonglueService.insert(gonglue);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

