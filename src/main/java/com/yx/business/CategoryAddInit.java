package com.yx.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yx.domain.Category;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;
import com.yx.mapper.CategoryExample;
import com.yx.mapper.CategoryMapper;
import com.yx.mapper.DBConnect;
import com.yx.mapper.TypeExample;
import com.yx.mapper.TypeMapper;

public class CategoryAddInit extends DBConnect {

	public CategoryAdd excuteInit(CategoryAdd categoryadd){
		
		SqlSession ss = this.ssf.openSession(true);
		CategoryExample categoryexample = new CategoryExample();
		com.yx.mapper.CategoryExample.Criteria categorycriteria = categoryexample.createCriteria();
		categorycriteria.andAbatetimeIsNull();
		CategoryMapper categorymapper = ss.getMapper(CategoryMapper.class);
		List<Category> resultcList = categorymapper.selectByExample(categoryexample);
		List<Category> catList = new ArrayList<Category>();
		for (int i = 0; i < resultcList.size(); i++){
			catList.add(resultcList.get(i));
		}
		categoryadd.setCategoryList(catList);
		
		// 二级指标读取
		TypeExample typeexample = new TypeExample();
		com.yx.mapper.TypeExample.Criteria typecriteria = typeexample.createCriteria();
		typecriteria.andAbatetimeIsNull();

		if (categoryadd.getCategory_detailHidden() != null && !categoryadd.getCategory_detailHidden().isEmpty()) {
			typecriteria.andCategoryTypeEqualTo(categoryadd.getIndexdetail().getCategory_detail());
		}
		TypeMapper typemapper = ss.getMapper(TypeMapper.class);
		List<Type> typeList = new ArrayList<Type>();
		List<Type> resulttList = typemapper.selectByExample(typeexample);
		for (int i = 0; i < resulttList.size(); i++) {
			typeList.add(resulttList.get(i));
		}
		categoryadd.setTypeList(typeList);
		return categoryadd;
	}
}
