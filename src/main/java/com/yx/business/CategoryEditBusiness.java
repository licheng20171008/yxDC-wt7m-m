package com.yx.business;

import java.util.Date;

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
import com.yx.mapper.IndexdetailExample.Criteria;
import com.yx.mapper.IndexdetailMapper;
import com.yx.mapper.TypeExample;
import com.yx.mapper.TypeMapper;

public class CategoryEditBusiness extends DBConnect{

	public CategoryAdd excute(CategoryAdd ca){
		String businessKey = ca.getBusinessKey();
		String operation = ca.getOperation();
		SqlSession ss = this.ssf.openSession(true);
		String selectBox = ca.getSelectBox();
		if ("0".equals(businessKey)){
			DepartmentMapper departmentmapper = ss.getMapper(DepartmentMapper.class);
			DepartmentExample departmentexample = new DepartmentExample();
			Department dep = ca.getDepartment();
			if ("1".equals(operation)) {
				if (departmentmapper.updateByPrimaryKeySelective(dep) > 0) {
					ca.setMessage("部门名称修改正确！！");
				} else {
					ca.setMessage("部门名称修改失败！！");
				}
			} else if ("2".equals(operation)) {
                departmentexample.createCriteria().andIdEqualTo(dep.getId()).andNameEqualTo(dep.getName());
				if (departmentmapper.countByExample(departmentexample) == 0) {
					ca.setMessage("请在修改部门名称后点击修改按钮，否则冻结/解冻操作不成功！！");
				} else {
					departmentexample.clear();
					departmentexample.createCriteria().andIdEqualTo(dep.getId()).andAbatetimeIsNull();
					if (departmentmapper.countByExample(departmentexample) != 0) {
						dep.setAbatetime(new Date());
					} else {
						dep.setAbatetime(null);
					}
					departmentexample.clear();
					if (departmentmapper.updateByPrimaryKey(dep) > 0) {
						ca.setMessage("部门冻结/解冻成功！！");
					} else {
						ca.setMessage("部门冻结/解冻失败！！");
					}
				}
			}
			if (!dep.getName().isEmpty()) {
				if ("1".equals(selectBox)) {
					departmentexample.createCriteria().andNameLike("%" +dep.getName() + "%");
				} else {
					departmentexample.createCriteria().andNameEqualTo(dep.getName());
				}
			}
			int depCount = departmentmapper.countByExample(departmentexample);
			ca.setDepCount(depCount);
			if (depCount%20 == 0){
				ca.setDepCountPage(depCount/20);
			} else {
				ca.setDepCountPage(depCount/20 + 1);
			}
			departmentexample.setLimitClause((ca.getDepCurPage() - 1)*20 + ", " + ca.getDepCurPage()*20);
			ca.setDepList(departmentmapper.selectByExample(departmentexample));
		} else if ("1".equals(businessKey)){
			CategoryMapper categorymapper = ss.getMapper(CategoryMapper.class);
			CategoryExample categoryexample = new CategoryExample();
			Category cat = ca.getCategory();
			if ("1".equals(operation)) {
				if (categorymapper.updateByPrimaryKeySelective(cat) > 0) {
					ca.setMessage("一级分类名称修改正确！！");
				} else {
					ca.setMessage("一级分类名称修改失败！！");
				}
			} else if ("2".equals(operation)) {
				categoryexample.createCriteria().andIdEqualTo(cat.getId()).andCategorynameEqualTo(cat.getCategoryname());
				if (categorymapper.countByExample(categoryexample) == 0) {
					ca.setMessage("请在修改一级分类名称后点击修改按钮，否则冻结/解冻操作不成功！！");
				} else {
					categoryexample.clear();
					categoryexample.createCriteria().andIdEqualTo(cat.getId()).andAbatetimeIsNull();
					if (categorymapper.countByExample(categoryexample) != 0) {
						cat.setAbatetime(new Date());
					} else {
						cat.setAbatetime(null);
					}
					categoryexample.clear();
					if (categorymapper.updateByPrimaryKey(cat) > 0) {
						ca.setMessage("一级分类冻结/解冻成功！！");
					} else {
						ca.setMessage("一级分类冻结/解冻失败！！");
					}
				}
			}
			if (!cat.getCategoryname().isEmpty()){
				if ("1".equals(selectBox)){
					categoryexample.createCriteria().andCategorynameLike("%" + cat.getCategoryname() + "%");
				} else {
					categoryexample.createCriteria().andCategorynameEqualTo(cat.getCategoryname());
				}
			}
			int catCount = categorymapper.countByExample(categoryexample);
			ca.setCatCount(catCount);
			if (catCount%20 == 0){
				ca.setCatCountPage(catCount/20);
			} else {
				ca.setCatCountPage(catCount/20 + 1);
			}
			categoryexample.setLimitClause((ca.getDepCurPage() - 1)*20 + ", " + ca.getDepCurPage()*20);
			ca.setCategoryViewList(categorymapper.selectByExample(categoryexample));
		} else if ("2".equals(businessKey)) {
			TypeMapper typemapper = ss.getMapper(TypeMapper.class);
			TypeExample typeexample = new TypeExample();
			Type type = ca.getType();
			if ("1".equals(operation)) {
				if (typemapper.updateByPrimaryKeySelective(type) > 0) {
					ca.setMessage("二级分类名称修改正确！！");
				} else {
					ca.setMessage("二级分类名称修改失败！！");
				}
			} else if ("2".equals(operation)) {
				typeexample.createCriteria().andIdEqualTo(type.getId()).andTypenameEqualTo(type.getTypename());
				if (typemapper.countByExample(typeexample) == 0) {
					ca.setMessage("请在修改二级分类名称后点击修改按钮，否则冻结/解冻操作不成功！！");
				} else {
					typeexample.clear();
					typeexample.createCriteria().andIdEqualTo(type.getId()).andAbatetimeIsNull();
					if (typemapper.countByExample(typeexample) != 0) {
						type.setAbatetime(new Date());
					} else {
						type.setAbatetime(null);
					}
					typeexample.clear();
					if (typemapper.updateByPrimaryKey(type) > 0) {
						ca.setMessage("二级分类冻结/解冻成功！！");
					} else {
						ca.setMessage("二级分类冻结/解冻失败！！");
					}
				}
			}
			if (!type.getTypename().isEmpty()){
				if ("1".equals(selectBox)){
					typeexample.createCriteria().andTypenameLike("%"+type.getTypename()+"%");
				} else {
					typeexample.createCriteria().andTypenameEqualTo(type.getTypename());
				}
			}
			int typeCount = typemapper.countByExample(typeexample);
			ca.setTypeCount(typeCount);
			if (typeCount%20 == 0){
				ca.setTypeCountPage(typeCount/20);
			} else {
				ca.setTypeCountPage(typeCount/20 + 1);
			}
			typeexample.setLimitClause((ca.getTypeCurPage() - 1)*20 + ", " + ca.getTypeCurPage()*20);
			ca.setTypeViewList(typemapper.selectByExample(typeexample));
		} else if ("3".equals(businessKey)) {
			IndexdetailMapper indexdetailmapper = ss.getMapper(IndexdetailMapper.class);
			IndexdetailExample indexdetailexample = new IndexdetailExample();
			Indexdetail id = ca.getIndexdetail();
			if ("1".equals(operation)) {
				if (indexdetailmapper.updateByPrimaryKeySelective(id) > 0) {
					ca.setMessage("指标明细修改正确！！");
				} else {
					ca.setMessage("指标明细修改失败！！");
				}
			} else if ("2".equals(operation)) {
				indexdetailexample.createCriteria().andIdEqualTo(id.getId())
				                                                                .andCategoryDetailEqualTo(id.getCategory_detail())
				                                                                .andTypeDetailEqualTo(id.getType_detail())
				                                                                .andIndexidEqualTo(id.getIndexID())
				                                                                .andIndexnameEqualTo(id.getIndexName())
				                                                                .andIndexdetailEqualTo(id.getIndexDetail())
				                                                                .andIndexformulaEqualTo(id.getIndexFormula())
				                                                                .andComputingcycleEqualTo(id.getComputingCycle())
				                                                                .andCycleunitEqualTo(id.getCycleUnit())
				                                                                .andDepartmentEqualTo(id.getDepartment())
				                                                                .andRemarkEqualTo(id.getRemark());
				if (indexdetailmapper.countByExample(indexdetailexample) == 0) {
					ca.setMessage("请在修改指标明细后点击修改按钮，否则冻结/解冻操作不成功！！");
				} else {
					indexdetailexample.clear();
					indexdetailexample.createCriteria().andIdEqualTo(id.getId()).andAbatetimeIsNull();
					if (indexdetailmapper.countByExample(indexdetailexample) != 0) {
						id.setAbateTime(new Date());
					} else {
						id.setAbateTime(null);
					}
					indexdetailexample.clear();
					if (indexdetailmapper.updateByPrimaryKey(id) > 0) {
						ca.setMessage("指标明细冻结/解冻成功！！");
					} else {
						ca.setMessage("指标明细冻结/解冻失败！！");
					}
				}
			}
			Criteria criteria = indexdetailexample.createCriteria();
			if ("1".equals(selectBox)){
				if (!id.getCategory_detail().isEmpty()) {
					criteria.andCategoryDetailLike("%"+id.getCategory_detail()+"%");
				}
				if (!id.getType_detail().isEmpty()) {
					criteria.andTypeDetailLike("%"+id.getType_detail()+"%");
				}
				if (!id.getIndexID().isEmpty()) {
					criteria.andIndexidLike("%"+id.getIndexID()+"%");
				}
				if (!id.getIndexName().isEmpty()) {
					criteria.andIndexnameLike("%"+id.getIndexName()+"%");
				}
				if (!id.getIndexDetail().isEmpty()) {
					criteria.andIndexdetailLike("%"+id.getIndexDetail()+"%");
				}
				if (!id.getIndexFormula().isEmpty()) {
					criteria.andIndexformulaLike("%"+id.getIndexFormula()+"%");
				}
				if (!id.getComputingCycle().isEmpty()) {
					criteria.andComputingcycleLike("%"+id.getComputingCycle()+"%");
				}
				if (!id.getCycleUnit().isEmpty()) {
					criteria.andCycleunitLike("%"+id.getCycleUnit()+"%");
				}
				if (!id.getDepartment().isEmpty()) {
					criteria.andDepartmentLike("%"+id.getDepartment()+"%");
				}
				if (!id.getRemark().isEmpty()) {
					criteria.andRemarkLike("%"+id.getRemark()+"%");
				}
			} else {
				if (!id.getCategory_detail().isEmpty()) {
					criteria.andCategoryDetailEqualTo(id.getCategory_detail());
				}
				if (!id.getType_detail().isEmpty()) {
					criteria.andTypeDetailEqualTo(id.getType_detail());
				}
				if (!id.getIndexID().isEmpty()) {
					criteria.andIndexidEqualTo(id.getIndexID());
				}
				if (!id.getIndexName().isEmpty()) {
					criteria.andIndexnameEqualTo(id.getIndexName());
				}
				if (!id.getIndexDetail().isEmpty()) {
					criteria.andIndexdetailEqualTo(id.getIndexDetail());
				}
				if (!id.getIndexFormula().isEmpty()) {
					criteria.andIndexformulaEqualTo(id.getIndexFormula());
				}
				if (!id.getComputingCycle().isEmpty()) {
					criteria.andComputingcycleEqualTo(id.getComputingCycle());
				}
				if (!id.getCycleUnit().isEmpty()) {
					criteria.andCycleunitEqualTo(id.getCycleUnit());
				}
				if (!id.getDepartment().isEmpty()) {
					criteria.andDepartmentEqualTo(id.getDepartment());
				}
				if (!id.getRemark().isEmpty()) {
					criteria.andRemarkEqualTo(id.getRemark());
				}
			}
			int idCount = indexdetailmapper.countByExample(indexdetailexample);
			ca.setIdCount(idCount);
			if (idCount%20 == 0){
				ca.setIdCountPage(idCount/20);
			} else {
				ca.setIdCountPage(idCount/20 + 1);
			}
			indexdetailexample.setLimitClause((ca.getIdCurPage() - 1)*20 + ", " + ca.getIdCurPage()*20);
			ca.setIdList(indexdetailmapper.selectByExample(indexdetailexample));
		}
		return ca;
	}
}
