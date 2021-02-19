package com.yx.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.mapper.CategoryExample;
import com.yx.mapper.CategoryMapper;
import com.yx.mapper.DBConnect;
import com.yx.mapper.DepartmentExample;
import com.yx.mapper.DepartmentMapper;
import com.yx.mapper.IndexdetailExample;
import com.yx.mapper.IndexdetailMapper;
import com.yx.mapper.TypeExample;
import com.yx.mapper.TypeExample.Criteria;
import com.yx.mapper.TypeMapper;

public class FileHandle extends DBConnect{

	public String checkFile(List<Indexdetail> idList) {
		String message = "";
		SqlSession ss = this.ssf.openSession(true);

		// 数据检证
		for (Indexdetail id : idList) {

			// 行数
			int index = id.getId();

			// 一级分类检证
			String category_detail = id.getCategory_detail();
			CategoryMapper categorymapper = ss.getMapper(CategoryMapper.class);
			CategoryExample categoryexample = new CategoryExample();
			categoryexample.createCriteria().andIdEqualTo(Integer.parseInt(category_detail));
			message = checkData(message, category_detail, index, categorymapper.countByExample(categoryexample), "一级分类");

			// 二级分类检证
			String type_detail = id.getType_detail();
			TypeMapper typemapper = ss.getMapper(TypeMapper.class);
			TypeExample typeexample = new TypeExample();
			Criteria criteria = typeexample.createCriteria();
			criteria.andIdEqualTo(Integer.parseInt(type_detail));
			message = checkData(message, type_detail, index, typemapper.countByExample(typeexample), "二级分类");

			// 一级分类与二级分类关联关系检证
			if (!category_detail.isEmpty() && !type_detail.isEmpty()) {
				criteria.andCategoryTypeEqualTo(category_detail);
				if (typemapper.countByExample(typeexample) == 0) {
					message = message + "一级分类(" + category_detail + ")与二级分类(" + type_detail + ")无关联关系，请确认。";
				}
			}

			// 部门检证
			String[] department = id.getDepartment().split(",");
			DepartmentMapper departmentmapper = ss.getMapper(DepartmentMapper.class);
			DepartmentExample departmentexample = new DepartmentExample();
			for (String dep : department) {
				departmentexample.clear();
				departmentexample.createCriteria().andNameEqualTo(dep);
				message = checkData(message, dep, index, departmentmapper.countByExample(departmentexample), "部门");
			}
		}
		return message;
	}

	private String checkData(String message, String arg, int index, int count, String type) {
		if (!arg.isEmpty()) {
			if (count == 0) {
				message = message + "第" + index + "行的" + type + "(" + arg + ")不存在，请检查。";
			}
		} else {
			message = message + "第" + index + "行的" + type + "为空，请检查。";
		}
		return message;
	}

	public String excute(List<Indexdetail> idList) {

		SqlSession ss = this.ssf.openSession(true);
		IndexdetailMapper indexdetailmapper = ss.getMapper(IndexdetailMapper.class);
		IndexdetailExample indexdetailexample = new IndexdetailExample();
		TypeMapper typemapper = ss.getMapper(TypeMapper.class);
		int index =indexdetailmapper.countByExample(indexdetailexample);

		for (Indexdetail id : idList) {
			id.setId(index);
			List<Type> ts = typemapper.selectByName(id.getCategory_detail(), id.getType_detail());
			if (ts.size() == 1) {
				id.setCategory_detail(ts.get(0).getCategoryType());
				id.setType_detail(ts.get(0).getId().toString());
			}
			indexdetailmapper.insert(id);
			index++;
		}
		return "数据插入成功！！";
	}
}