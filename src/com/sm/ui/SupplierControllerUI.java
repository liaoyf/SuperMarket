package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.Paging;
import com.sm.mybatis.mb.*;

@Controller
public class SupplierControllerUI {

	@Autowired
	private SupplierMapper dao;

	@Autowired
	private LPRoleMapper Lpdao;

	@RequestMapping("/main/suppliers")
	public String search(Integer mes,Integer pageNum,Integer supplierId,String supplierName,HttpSession ss, ModelMap mm) throws UnsupportedEncodingException{
		//如果拥有这个权限则可以进入
		
				if (check(ss,10))
					return "/err";
				
				if (null != mes && 1 == mes)
					mm.addAttribute("msg", "新增成功！");
				else if (null != mes && 2 == mes)
					mm.addAttribute("msg", "修改成功！");
				else if (null != mes && 3 == mes)
					mm.addAttribute("msg", "刪除成功！");
				else if (null != mes && 5 == mes)
					mm.addAttribute("msg", "无此供应商！");
				
				Map<String, Object> params = new HashMap<String, Object>();

				System.out.println(supplierName);
				Paging page = new Paging();
				page.setPageSize(2);
				if (null == pageNum) {
					page.setPageNum(1);
				} else {
					page.setPageNum(pageNum);
				}
				mm.addAttribute("supplierId", supplierId);
				mm.addAttribute("supplierName",supplierName);
				
				params.put("supplierName", supplierName);
				params.put("supplierId", supplierId);
				int count = dao.selectCountBySupplier(params);
				System.out.println("页的大小" + count);
				page.setTotalCount(count);
				params.put("page", page);

				System.out.println("页的大小" + page.getPageSize());

				System.out.println("总页数" + page.getTotalPage());

				System.out.println("总计记录数" + page.getTotalCount());
				
				List<Supplier> rs = dao.selectAllBySupplier(params);
				/*if(rs.isEmpty())
					return "redirect:/main/suppliers?mes=5";*/
				mm.addAttribute("suppliers", rs);
				mm.addAttribute("page", page);
		return "/supplier";
	}

	// 初始化，新增/修改操作前置的JSP视图
	@RequestMapping({ "/main/suppliers/add", "/main/suppliers/edit" })
	public String initAddEditJsp(Integer supplierId, ModelMap mm) {
		if (null != supplierId) {
			Supplier supplier = dao.selectByPrimaryKey(supplierId);
			mm.addAttribute("supplier", supplier);
		}

		// 请求转发到JSP
		return "/supplierCU";

	}

	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/suppliers/add/handler")
	public String add(Supplier dto) {
		System.out.println("做了新增动作");
		dao.insert(dto);
		return "redirect:../../suppliers?mes=1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/suppliers/edit/handler")
	public String edit(Supplier dto) {
		System.out.println("做了编辑动作");
		dao.updateByPrimaryKey(dto);
		return "redirect:../../suppliers?mes=2";
	}

	@RequestMapping("/main/suppliers/del")
	public String del(Integer supplierId) {
		System.out.println("做了删除动作");
		dao.deleteByPrimaryKey(supplierId);
		return "redirect:../suppliers?mes=3";
	}

	public boolean check(HttpSession ss, Integer limit) {
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		LPRoleExample e = new LPRoleExample();
		// System.out.println(staff.getStaffName());
		Integer staffRoleId = staff.getRoleId();
		e.createCriteria().andRoleIdEqualTo(staffRoleId);
		List<LPRoleKey> lpRoleKeys = Lpdao.selectByExample(e);

		for (LPRoleKey i : lpRoleKeys) {
			// 表示拥有权限10的员工可以进入
			if (i.getLpId() == limit) {
				return false;
			}
		}
		return true;

	}
}