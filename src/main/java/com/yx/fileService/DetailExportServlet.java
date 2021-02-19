package com.yx.fileService;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yx.domain.Category;
import com.yx.domain.Department;
import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;
import com.yx.dto.Common;
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
import com.yx.servlet.RequestOperation;

/**
 * 初始化添加页面
 */
public class DetailExportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SqlSession ss = new DBConnect().ssf.openSession(true);
		String fileTitle = "";
		String[] itemArray = null;
		String servletPath = request.getSession().getServletContext().getRealPath("filePath") + File.separator ;
		CategoryAdd afp = (CategoryAdd) request.getAttribute("CategoryAdd") == null ? 
			new CategoryAdd() : (CategoryAdd) request.getAttribute("CategoryAdd");
			
		// 系统时间
		String sysDate = new Common().sysDate("yyyy-MM-dd");
		try {
			afp = (CategoryAdd) new RequestOperation().excute(request, response, afp);
		} catch (Exception e) {
			e.printStackTrace();
			afp.setMessage("参数出错！！");
		}
		String businessKey = afp.getBusinessKey();
		String selectBox = afp.getSelectBox();
		if ("0".equals(businessKey)) {
			afp.setCategory(new Category());
			afp.setType(new Type());
			afp.setIndexdetail(new Indexdetail());
			DepartmentMapper departmentmapper = ss.getMapper(DepartmentMapper.class);
			DepartmentExample departmentexample = new DepartmentExample();
			Department dep = afp.getDepartment();
			if (!dep.getName().isEmpty()) {
				if ("1".equals(selectBox)) {
					departmentexample.createCriteria().andNameLike("%" +dep.getName() + "%");
				} else {
					departmentexample.createCriteria().andNameEqualTo(dep.getName());
				}
			}
			fileTitle = "部门基本信息" + sysDate;
			itemArray = new String[3];
			itemArray[0] = "部门ID";
			itemArray[1] = "部门名称";
			itemArray[2] = "冻结时间";
			servletPath += fileTitle + ".xls";
			new ExportExcel().writeFile(departmentmapper.selectByExample(departmentexample), servletPath, itemArray, fileTitle);
		} else if ("1".equals(businessKey)) {
			afp.setDepartment(new Department());
			afp.setType(new Type());
			afp.setIndexdetail(new Indexdetail());
			CategoryMapper categorymapper = ss.getMapper(CategoryMapper.class);
			CategoryExample categoryexample = new CategoryExample();
			Category cat = afp.getCategory();
			if (!cat.getCategoryname().isEmpty()){
				if ("1".equals(selectBox)){
					categoryexample.createCriteria().andCategorynameLike("%" + cat.getCategoryname() + "%");
				} else {
					categoryexample.createCriteria().andCategorynameEqualTo(cat.getCategoryname());
				}
			}
			fileTitle = "一级分类信息" + sysDate;
			itemArray = new String[3];
			itemArray[0] = "一级分类ID";
			itemArray[1] = "一级分类名称";
			itemArray[2] = "冻结时间";
			servletPath += fileTitle + ".xls";
			new ExportExcel().writeFile(categorymapper.selectByExample(categoryexample), servletPath, itemArray, fileTitle);
		} else if ("2".equals(businessKey)) {
			afp.setDepartment(new Department());
			afp.setCategory(new Category());
			afp.setIndexdetail(new Indexdetail());
			TypeMapper typemapper = ss.getMapper(TypeMapper.class);
			TypeExample typeexample = new TypeExample();
			Type type = afp.getType();
			com.yx.mapper.TypeExample.Criteria typecriteria = typeexample.createCriteria();
			if (!type.getTypename().isEmpty()){
				if ("1".equals(selectBox)){
					typecriteria.andTypenameLike("%"+type.getTypename()+"%");
				} else {
					typecriteria.andTypenameEqualTo(type.getTypename());
				}
			}
			
			if (type.getCategoryType() != null && !type.getCategoryType().isEmpty()) {
				typecriteria.andCategoryTypeEqualTo(type.getCategoryType());
			}
			fileTitle = "二级分类信息" + sysDate;
			itemArray = new String[4];
			itemArray[0] = "二级分类ID";
			itemArray[1] = "二级分类名称";
			itemArray[2] = "关联一级类别";
			itemArray[3] = "冻结时间";
			servletPath += fileTitle + ".xls";
			new ExportExcel().writeFile(typemapper.selectByExample(typeexample), servletPath, itemArray, fileTitle);
		} else if ("3".equals(businessKey)) {
			afp.setDepartment(new Department());
			afp.setCategory(new Category());
			afp.setType(new Type());
			IndexdetailMapper indexdetailmapper = ss.getMapper(IndexdetailMapper.class);
			IndexdetailExample indexdetailexample = new IndexdetailExample();
			Indexdetail id = afp.getIndexdetail();
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
			fileTitle = "指标明细信息" + sysDate;
			itemArray = new String[12];
			itemArray[0] = "指标ID";
			itemArray[1] = "一级分类ID";
			itemArray[2] = "二级分类ID";
			itemArray[3] = "指标编号";
			itemArray[4] = "指标名称";
			itemArray[5] = "指标定义";
			itemArray[6] = "计算公式";
			itemArray[7] = "统计周期";
			itemArray[8] = "周期单位";
			itemArray[9] = "所属科室";
			itemArray[10] = "备注";
			itemArray[11] = "冻结时间";
			servletPath += fileTitle + ".xls";
			new ExportExcel().writeFile(indexdetailmapper.selectByExample(indexdetailexample), servletPath, itemArray, fileTitle);
		}
		new Common().download(servletPath, response);
		request.setAttribute("CategoryAdd", afp);
		request.getRequestDispatcher("/jsp/yxCategoryEdit.jsp");
		this.doGet(request, response);
	}
}