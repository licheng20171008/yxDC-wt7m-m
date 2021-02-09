package com.yx.business;

import com.yx.DBConnect.DBOpration;
import com.yx.domain.Category;
import com.yx.domain.Department;
import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;

public class CategoryAddBusiness {

	public String excute(CategoryAdd ca){
		String businessKey = ca.getBusinessKey();
		String message = "";
		DBOpration dbo = new DBOpration();
		if ("0".equals(businessKey)){
			Category cat = new Category();
			cat = ca.getCategory();
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
			Type type = new Type();
			type = ca.getType();
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
			Indexdetail id = new Indexdetail();
			id = ca.getIndexDetail();
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
			Department dep = new Department();
			dep = ca.getDepartment();
			if (dep.getName().isEmpty()){
				message = "请填写部门名称！！";
			} else {
				if (dbo.excuteSQL(dbo.objInsertSql(dep))){
					message = "部门添加成功！！";
				} else {
					message = "部门添加失败！！";
				}
			}
		}
		return message;
	}
}
