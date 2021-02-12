package com.yx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yx.DBConnect.DBOpration;
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
		DBOpration dbo = new DBOpration();
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
				categoryadd.setDepartment((Department) dbo.InitBean(Department.class));

				// 二级分类指标
				categoryadd.setType((Type) dbo.InitBean(Type.class));

				// 指标标准表单
				categoryadd.setIndexdetail((Indexdetail) dbo.InitBean(Indexdetail.class));
			}else if ("1".equals(businessKey)) {
				// 部门
				categoryadd.setDepartment((Department) dbo.InitBean(Department.class));
				
				// 一级分类指标
				categoryadd.setCategory((Category) dbo.InitBean(Category.class));
				
				// 指标标准表单
				categoryadd.setIndexdetail((Indexdetail) dbo.InitBean(Indexdetail.class));
			}else if ("2".equals(businessKey)) {
				// 部门
				categoryadd.setDepartment((Department) dbo.InitBean(Department.class));

				// 一级分类指标
				categoryadd.setCategory((Category) dbo.InitBean(Category.class));

				// 二级分类指标
				categoryadd.setType((Type) dbo.InitBean(Type.class));
			}else if ("3".equals(businessKey)) {
				// 一级分类指标
				categoryadd.setCategory((Category) dbo.InitBean(Category.class));

				// 二级分类指标
				categoryadd.setType((Type) dbo.InitBean(Type.class));

				// 指标标准表单
				categoryadd.setIndexdetail((Indexdetail) dbo.InitBean(Indexdetail.class));
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
			categoryadd.setDepartment((Department) dbo.InitBean(Department.class));
			
			// 一级分类指标
			categoryadd.setCategory((Category) dbo.InitBean(Category.class));
			
			// 二级分类指标
			categoryadd.setType((Type) dbo.InitBean(Type.class));
			
			// 指标标准表单
			categoryadd.setIndexdetail((Indexdetail) dbo.InitBean(Indexdetail.class));
			request.setAttribute("CategoryAdd", categoryadd);
			request.getRequestDispatcher("/jsp/yxCategoryAdd.jsp").forward(request, response);
		}
		this.doGet(request, response);
	}
}