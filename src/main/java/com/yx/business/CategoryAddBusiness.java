package com.yx.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yx.DBConnect.DBOpration;
import com.yx.domain.Category;
import com.yx.domain.Department;
import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;
import com.yx.mapper.DBConnect;
import com.yx.mapper.DepartmentMapper;

public class CategoryAddBusiness extends DBConnect {

	public String excute(CategoryAdd ca){
		String businessKey = ca.getBusinessKey();
		String message = "";
		DBOpration dbo = new DBOpration();
		if ("0".equals(businessKey)){
			Category cat = ca.getCategory();
			if (cat.getCategoryname().isEmpty()){
				message = "请填写一级指标名称！！";
			} else {
				if (dbo.excuteSQL(dbo.objInsertSql(cat))){
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
				if (dbo.excuteSQL(dbo.objInsertSql(type))){
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
				if (dbo.excuteSQL(dbo.objInsertSql(id))){
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
				SqlSession ss = this.ssf.openSession();
				DepartmentMapper departmentmapper = ss.getMapper(DepartmentMapper.class);
				int index = departmentmapper.insert(dep);
				System.out.println(index);
				if (index > 0){
					message = "部门添加成功！！";
				} else {
					message = "部门添加失败！！";
				}
			}
		}
		return message;
	}
}
