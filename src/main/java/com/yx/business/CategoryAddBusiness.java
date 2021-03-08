package com.yx.business;

import org.apache.ibatis.session.SqlSession;

import com.yx.domain.Category;
import com.yx.domain.Department;
import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;
import com.yx.mapper.CategoryExample;
import com.yx.mapper.CategoryMapper;
import com.yx.mapper.DBConnect;
import com.yx.mapper.DepartmentExample;
import com.yx.mapper.DepartmentMapper;
import com.yx.mapper.IndexdetailExample;
import com.yx.mapper.IndexdetailMapper;
import com.yx.mapper.TypeExample;
import com.yx.mapper.TypeMapper;

public class CategoryAddBusiness extends DBConnect {

	public String excute(CategoryAdd ca){
		String businessKey = ca.getBusinessKey();
		String message = "";
		SqlSession ss = this.ssf.openSession(true);
		if ("0".equals(businessKey)){
			Category cat = ca.getCategory();
			if (cat.getCategoryname().isEmpty()){
				message = "请填写一级指标名称！！";
			} else {
				CategoryMapper categorymapper = ss.getMapper(CategoryMapper.class);
				CategoryExample categoryexample = new CategoryExample();
				com.yx.mapper.CategoryExample.Criteria categorycriteria = categoryexample.createCriteria();
				categorycriteria.andAbatetimeIsNull();
				cat.setId(categorymapper.countByExample(categoryexample) + 1);
				if (categorymapper.insert(cat) > 0){
					message = "一级指标添加成功！！";
				} else {
					message = "一级指标添加失败！！";
				}
			}
		} else if ("1".equals(businessKey)) {
			Type type = ca.getType();
			if (type.getTypename().isEmpty()){
				message = "请填写二级指标名称！！";
			} else {
				TypeMapper typemapper = ss.getMapper(TypeMapper.class);
				TypeExample typeexample = new TypeExample();
				com.yx.mapper.TypeExample.Criteria typecriteria = typeexample.createCriteria();
				typecriteria.andAbatetimeIsNull();
				type.setId(typemapper.countByExample(typeexample) + 1);
				if (typemapper.insert(type) > 0){
					message = "二级指标添加成功！！";
				} else {
					message = "二级指标添加失败！！";
				}
			}
		} else if ("2".equals(businessKey)) {
			Indexdetail id = ca.getIndexdetail();
			if (id.getIndexName().isEmpty()){
				message = "请填写指标名称！！";
			} else {
				IndexdetailMapper indexdetailmapper = ss.getMapper(IndexdetailMapper.class);
				IndexdetailExample indexdetailexample = new IndexdetailExample();
				com.yx.mapper.IndexdetailExample.Criteria indexdetailcriteria = indexdetailexample.createCriteria();
				indexdetailcriteria.andAbatetimeIsNull();
				id.setId(indexdetailmapper.countByExample(indexdetailexample) + 1);
				if (indexdetailmapper.insert(id) > 0){
					message = "明细指标添加成功！！";
				} else {
					message = "明细指标添加失败！！";
				}
			}
		} else if ("3".equals(businessKey)) {
			Department dep =  ca.getDepartment();
			if (dep.getName().isEmpty()){
				message = "请填写部门名称！！";
			} else {
				DepartmentMapper departmentmapper = ss.getMapper(DepartmentMapper.class);
				DepartmentExample departmentexample = new DepartmentExample();
				com.yx.mapper.DepartmentExample.Criteria departmentcriteria = departmentexample.createCriteria();
				departmentcriteria.andAbatetimeIsNull();
				dep.setId(departmentmapper.countByExample(departmentexample) + 1);
				if (departmentmapper.insert(dep) > 0){
					message = "部门添加成功！！";
				} else {
					message = "部门添加失败！！";
				}
			}
		}
		ss.close();
		return message;
	}
}
