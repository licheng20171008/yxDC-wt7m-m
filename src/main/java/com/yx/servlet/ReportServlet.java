package com.yx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yx.business.CategoryAddInit;
import com.yx.business.CategoryEditBusiness;
import com.yx.domain.Category;
import com.yx.domain.Department;
import com.yx.domain.Indexdetail;
import com.yx.domain.Type;
import com.yx.dto.CategoryAdd;

/**
 * 初始化添加页面
 */
public class ReportServlet extends HttpServlet {

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
		HttpSession session = request.getSession(true);
		CategoryEditBusiness ceb = new CategoryEditBusiness();
		String hiddenValue = request.getParameter("hiddenValue");
		CategoryAdd afp = (CategoryAdd) request.getAttribute("CategoryAdd") == null?
			new CategoryAdd():(CategoryAdd) request.getAttribute("CategoryAdd");
		if (hiddenValue == null || hiddenValue.isEmpty()) {
			try {
				afp = (CategoryAdd) new RequestOperation().excute(request, response, afp);
			} catch (Exception e) {
				e.printStackTrace();
				afp.setMessage("参数出错！！");
			}
			String businessKey = afp.getBusinessKey();
			if ("0".equals(businessKey)){
				// 一级分类指标
				afp.setCategory(new Category());

				// 二级分类指标
				afp.setType(new Type());

				// 指标标准表单
				afp.setIndexdetail(new Indexdetail());
				if (afp.getDepCurPage() == 0){
					afp.setDepCurPage(1);
					session.setAttribute("department", afp.getDepartment());
				} else {
					afp.setDepartment((Department) session.getAttribute("department"));
				}
			} else if ("1".equals(businessKey)){
				// 部门
				afp.setDepartment(new Department());

				// 二级分类指标
				afp.setType(new Type());

				// 指标标准表单
				afp.setIndexdetail(new Indexdetail());
				if (afp.getCatCurPage() == 0){
					afp.setCatCurPage(1);
					session.setAttribute("category", afp.getCategory());
				} else {
					afp.setCategory((Category) session.getAttribute("category"));
				}
			} else if ("2".equals(businessKey)){
				// 部门
				afp.setDepartment(new Department());
				
				// 一级分类指标
				afp.setCategory(new Category());
				
				// 指标标准表单
				afp.setIndexdetail(new Indexdetail());
				if (afp.getTypeCurPage() == 0){
					afp.setTypeCurPage(1);
					session.setAttribute("type", afp.getType());
				} else {
					afp.setType((Type) session.getAttribute("type"));
				}
			} else if ("3".equals(businessKey)){
				// 部门
				afp.setDepartment(new Department());

				// 一级分类指标
				afp.setCategory(new Category());

				// 二级分类指标
				afp.setType(new Type());
				if (afp.getIdCurPage() == 0){
					afp.setIdCurPage(1);
					session.setAttribute("indexdetail", afp.getIndexdetail());
				} else {
					afp.setIndexdetail((Indexdetail) session.getAttribute("indexdetail"));
				}
			}
			afp = ceb.excute(afp);
			afp = new CategoryAddInit().excuteInit(afp);
			request.setAttribute("CategoryAdd", afp);
			request.getRequestDispatcher("/jsp/yxCategoryEdit.jsp").forward(request, response);
		} else {
			afp = new CategoryAddInit().excuteInit(afp);
			
			// 选项初始化
			afp.setBusinessKey("0");
			afp.setSelectBox("1");
			
			// 页面信息
			afp.setMessage("");
			
			// 部门
			afp.setDepartment(new Department());

			// 一级分类指标
			afp.setCategory(new Category());

			// 二级分类指标
			afp.setType(new Type());

			// 指标标准表单
			afp.setIndexdetail(new Indexdetail());
			request.setAttribute("CategoryAdd", afp);
			request.getRequestDispatcher("/jsp/yxCategoryEdit.jsp").forward(request, response);
		}
		this.doGet(request, response);
	}
}