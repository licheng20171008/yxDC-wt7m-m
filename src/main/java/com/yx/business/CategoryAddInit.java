package com.yx.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yx.DBConnect.DBOpration;
import com.yx.domain.Category;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;
import com.yx.mapper.CategoryExample;
import com.yx.mapper.CategoryExample.Criteria;
import com.yx.mapper.CategoryMapper;
import com.yx.mapper.DBConnect;

public class CategoryAddInit extends DBConnect {

	public CategoryAdd excuteInit(CategoryAdd ca){
		
		SqlSession ss = this.ssf.openSession();
		CategoryExample cge = new CategoryExample();
		Criteria c = cge.createCriteria();
		c.andAbatetimeIsNull();
		CategoryMapper cm = ss.getMapper(CategoryMapper.class);
		List<Category> resultcList = cm.selectByExample(cge);
		DBOpration dbo = new DBOpration();
		// 一级指标的读取
		//String categorySql = dbo.tableforAll("category");
		//categorySql = categorySql + " where abateTime is null";
		List<Category> catList = new ArrayList<Category>();
		//List<Object> resultList = dbo.excuteSQL(categorySql, Category.class);
		for (int i = 0; i < resultcList.size(); i++){
			catList.add(resultcList.get(i));
		}
		ca.setCategoryList(catList);
		
		if (ca.getCategory_detailHidden() != null && !ca.getCategory_detailHidden().isEmpty()){
			
			// 二级指标读取
			Map<String, String> map = new HashMap<String, String>();
			map.put("category_type", ca.getIndexDetail().getCategory_detail());
			String typeSql = dbo.selectWhere("type", map);
			typeSql = typeSql + " and abateTime is null";
			List<Type> typeList = new ArrayList<Type>();
			List<Object> resultList = dbo.excuteSQL(typeSql, Type.class);
			for (int i = 0; i < resultList.size(); i++){
				typeList.add((Type) resultList.get(i));
			}
			ca.setTypeList(typeList);
		} else {
			String typeSql = dbo.tableforAll("type");
			typeSql = typeSql + " where abateTime is null";
			List<Type> typeList = new ArrayList<Type>();
			List<Object> resultList = dbo.excuteSQL(typeSql, Type.class);
			for (int i = 0; i < resultList.size(); i++){
				typeList.add((Type) resultList.get(i));
			}
			ca.setTypeList(typeList);
		}
		return ca;
	}
}
