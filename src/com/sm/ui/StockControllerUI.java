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

;

@Controller
public class StockControllerUI {

	@Autowired
	private StockMapper stockdao;
	@Autowired
	private LPRoleMapper LPdao;

	// 初始化仓库页面
	@RequestMapping("/main/stocks")
	public String search(Integer mes,HttpSession ss,Integer stockId, ModelMap mm,Integer pageNum)
			throws UnsupportedEncodingException {
		// 只有拥有此权限的员工才可进入
		if (check(ss, 3))
			return "/err";
		if (null != mes && 1 == mes)
			mm.addAttribute("msg", "新增成功！");
		else if (null != mes && 2 == mes)
			mm.addAttribute("msg", "修改成功！");
		else if (null != mes && 3 == mes)
			mm.addAttribute("msg", "刪除成功！");
			StockExample se = new StockExample();
			se.createCriteria().andStockNameLike("%");
			//查询到的仓库数量
			long count=stockdao.countByExample(se);
			Paging page = new Paging();
			page.setPageSize(2);
			if (null == pageNum) {
				page.setPageNum(1);
			} else {
				page.setPageNum(pageNum);
			}
			page.setTotalCount(count);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("page", page);
			List<Stock> rs = stockdao.selectAllByStock(params);
			System.out.println("页的大小" + page.getPageSize());

			System.out.println("总页数" + page.getTotalPage());

			System.out.println("总计记录数" + page.getTotalCount());

			mm.addAttribute("stock", rs);
			mm.addAttribute("page", page);

			return "/stock";
		}

	// 初始化，新增/修改操作前置的JSP视图
	@RequestMapping({ "/main/stocks/add", "/main/stocks/edit" })
	public String initAddEditJsp(Integer stockId, ModelMap mm) {
		if (null != stockId) {
			Stock stock = stockdao.selectByPrimaryKey(stockId);
			mm.addAttribute("stock", stock);
		}

		// 请求转发到JSP
		return "/stockCU";

	}

	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/stocks/add/handler")
	public String add(Stock dto) {
		System.out.println("做了新增动作");
		stockdao.insert(dto);
		return "redirect:../../stocks?mes=1";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/stocks/edit/handler")
	public String edit(Stock dto) {
		System.out.println("做了编辑动作");
		stockdao.updateByPrimaryKey(dto);
		return "redirect:../../stocks?mes=2";
	}

	@RequestMapping("/main/stocks/del")
	public String del(Integer stockId) {
		System.out.println("做了删除动作");
		stockdao.deleteByPrimaryKey(stockId);
		return "redirect:../stocks?mes=3";
	}

	public boolean check(HttpSession ss, Integer limit) {
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		LPRoleExample e = new LPRoleExample();
		// System.out.println(staff.getStaffName());
		Integer staffRoleId = staff.getRoleId();
		e.createCriteria().andRoleIdEqualTo(staffRoleId);
		List<LPRoleKey> lpRoleKeys = LPdao.selectByExample(e);

		for (LPRoleKey i : lpRoleKeys) {
			if (i.getLpId() == limit) {
				return false;
			}
		}
		return true;

	}
}
