package com.yx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yx.business.CategoryAddBusiness;
import com.yx.business.CategoryAddInit;
import com.yx.domain.Category;
import com.yx.domain.Department;
import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;

/**
 * 初始化添加页面
 */
public class InitServlet extends HttpServlet {

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
		CategoryAddBusiness cab = new CategoryAddBusiness();
		String hiddenValue = request.getParameter("hiddenValue");
		CategoryAdd categoryadd = (CategoryAdd) request.getAttribute("CategoryAdd") == null?new CategoryAdd():(CategoryAdd) request.getAttribute("CategoryAdd");
		if (hiddenValue == null || hiddenValue.isEmpty()) {
			try {
				categoryadd = (CategoryAdd) new RequestOperation().excute(request, response, categoryadd);
			} catch (Exception e) {
				e.printStackTrace();
				categoryadd.setMessage("参数出错！！");
			}
			String businessKey = categoryadd.getBusinessKey();
			if ("0".equals(businessKey)) {
				// 部门
				categoryadd.setDepartment(new Department());

				// 二级分类指标
				categoryadd.setType(new Type());

				// 指标标准表单
				categoryadd.setIndexdetail(new Indexdetail());
			}else if ("1".equals(businessKey)) {
				// 部门
				categoryadd.setDepartment(new Department());
				
				// 一级分类指标
				categoryadd.setCategory(new Category());
				
				// 指标标准表单
				categoryadd.setIndexdetail(new Indexdetail());
			}else if ("2".equals(businessKey)) {
				// 部门
				categoryadd.setDepartment(new Department());

				// 一级分类指标
				categoryadd.setCategory(new Category());

				// 二级分类指标
				categoryadd.setType(new Type());
			}else if ("3".equals(businessKey)) {
				// 一级分类指标
				categoryadd.setCategory(new Category());

				// 二级分类指标
				categoryadd.setType(new Type());

				// 指标标准表单
				categoryadd.setIndexdetail(new Indexdetail());
			}
			if ("0".equals(categoryadd.getCategory_detailHidden())){
				categoryadd.setMessage(cab.excute(categoryadd));
			}
			categoryadd = new CategoryAddInit().excuteInit(categoryadd);
			request.setAttribute("CategoryAdd", categoryadd);
			request.getRequestDispatcher("/jsp/yxCategoryAdd.jsp").forward(request, response);
		} else {
			categoryadd = new CategoryAddInit().excuteInit(categoryadd);
			
			// 初始化
			// 隐藏控制项
			categoryadd.setBusinessKey("3");
			
			// 页面信息
			categoryadd.setMessage("");
			
			// 部门
			categoryadd.setDepartment(new Department());
			
			// 一级分类指标
			categoryadd.setCategory(new Category());
			
			// 二级分类指标
			categoryadd.setType(new Type());
			
			// 指标标准表单
			categoryadd.setIndexdetail(new Indexdetail());
			request.setAttribute("CategoryAdd", categoryadd);
			request.getRequestDispatcher("/jsp/yxCategoryAdd.jsp").forward(request, response);
		}
		this.doGet(request, response);
	}
}