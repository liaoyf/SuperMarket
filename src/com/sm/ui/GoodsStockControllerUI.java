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

import com.google.gson.Gson;
import com.sm.Paging;
import com.sm.mybatis.mb.*;

@Controller
public class GoodsStockControllerUI {
	@Autowired
	private GoodsStockMapper dao;
	@Autowired
	private LPRoleMapper Lpdao;

	@RequestMapping("/main/gstock")
	public String search(HttpSession ss, Integer pageNum, String goodsName,
			String stockName, ModelMap mm) throws UnsupportedEncodingException {
		if (check(ss, 26))
			return "/err";
		Map<String, Object> params = new HashMap<String, Object>();
		Paging page = new Paging();
		page.setPageSize(2);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		params.put("goodsName", goodsName);
		params.put("stockName", stockName);

		long count = dao.selectCountByGoodsStock(params);

		page.setTotalCount(count);
		params.put("page", page);

		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());

		List<GoodsStock> rs = dao.selectGoodsStockByMap(params);
		Gson g = new Gson();
		System.out.println("+++++++++++++++++" + rs.size());
		System.out.println(g.toJson(rs));
		mm.addAttribute("goodsName", goodsName);
		mm.addAttribute("goodsName", goodsName);
		mm.addAttribute("goodsStock", rs);
		mm.addAttribute("page", page);
		return "/gstock";
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
