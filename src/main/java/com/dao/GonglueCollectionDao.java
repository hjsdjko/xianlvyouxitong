package com.dao;

import com.entity.GonglueCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GonglueCollectionView;

/**
 * 旅游攻略收藏 Dao 接口
 *
 * @author 
 */
public interface GonglueCollectionDao extends BaseMapper<GonglueCollectionEntity> {

   List<GonglueCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
