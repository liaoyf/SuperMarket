package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.sm.mybatis.mb.CreditsDiscount;
import com.sm.mybatis.mb.CreditsDiscountExample;
import com.sm.mybatis.mb.CreditsDiscountMapper;
import com.sm.mybatis.mb.LPRoleExample;
import com.sm.mybatis.mb.LPRoleKey;
import com.sm.mybatis.mb.LPRoleMapper;
import com.sm.mybatis.mb.Staff;
import com.sm.mybatis.mb.StaffExample;
import com.sm.mybatis.mb.Vip;
import com.sm.mybatis.mb.VipExample;
import com.sm.mybatis.mb.VipMapper;
@Controller
public class VipControllerUI {

	@Autowired
	private VipMapper dao;
	
	@Autowired
	private LPRoleMapper Lpdao;
	@Autowired
	private CreditsDiscountMapper dao2;
	@RequestMapping("/main/vips")
	public String search(Integer mes,Integer vipId,Integer pageNum, String vipName, ModelMap mm,
			HttpSession ss) throws UnsupportedEncodingException {
		//如果拥有这个权限则可以进入
		if (check(ss,10))
			return "/err";
		
		if (null != mes && 1 == mes)
			mm.addAttribute("msg", "新增成功！");
		else if (null != mes && 2 == mes)
			mm.addAttribute("msg", "修改成功！");
		else if (null != mes && 3 == mes)
			mm.addAttribute("msg", "刪除成功！");
		
		Map<String, Object> params = new HashMap<String, Object>();
		Paging page = new Paging();
		page.setPageSize(2);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		mm.addAttribute("vipName", vipName);
		mm.addAttribute("vipId", vipId);
		params.put("vipName", vipName);
		params.put("vipId", vipId);
		long count = dao.selectCountByVip(params);
		System.out.println("页的大小" + count);
		page.setTotalCount(count);
		params.put("page", page);

		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());
		
		List<Vip> rs = dao.selectAllByVip(params);
		mm.addAttribute("vips", rs);
		mm.addAttribute("page", page);
			return "/vip";
		}


	// 初始化，新增/修改操作前置的JSP视图
		@RequestMapping({ "/main/vips/add", "/main/vips/edit" })
		public String initAddEditJsp(Integer vipId, ModelMap mm) {
			System.out.println("进入了");
			      if (null != vipId) {
				     Vip vip = dao.selectByPrimaryKey(vipId);
				     mm.addAttribute("vip", vip);
			           }
			      
					CreditsDiscountExample cd = new CreditsDiscountExample();
					String level = "%";
					cd.createCriteria().andVipLevelLike(level);
					List<CreditsDiscount> cDiscount = dao2.selectByExample(cd);
					mm.addAttribute("cDiscount", cDiscount);
			         // 请求转发到JSP
			         return "/vipCU";
		}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/vips/add/handler")
	public String add(Vip dto, String vipCreateTime2, String vipVaildTime2) {
		System.out.println("做了新增动作");
		Date create = null;
		try {
			create = sdf.parse(vipCreateTime2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setVipCreateTime(create);

		Date vaild = null;
		try {
			vaild = sdf.parse(vipVaildTime2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setVipVaildTime(vaild);
		dao.insert(dto);
		return "redirect:../../vips?mes=1";// 请求重定向
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/vips/edit/handler")
	public String edit(Vip dto, String vipCreateTime2, String vipVaildTime2) {
		System.out.println("做了编辑动作");
		Date create = null;
		try {
			create = sdf.parse(vipCreateTime2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setVipCreateTime(create);

		Date vaild = null;
		try {
			vaild = sdf.parse(vipVaildTime2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setVipVaildTime(vaild);
		dao.updateByPrimaryKey(dto);
		return "redirect:../../vips?mes=2";// 请求重定向
	}

	@RequestMapping("/main/vips/del")
	public String del(Integer vipId) {
		System.out.println("做了删除动作");
		dao.deleteByPrimaryKey(vipId);
		return "redirect:../vips?mes=3";// 请求重定向
	}
	public boolean check(HttpSession ss, Integer limit) {
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		LPRoleExample e = new LPRoleExample();
		//System.out.println(staff.getStaffName());
		Integer staffRoleId = staff.getRoleId();
		e.createCriteria().andRoleIdEqualTo(staffRoleId);
		List<LPRoleKey> lpRoleKeys = Lpdao.selectByExample(e);
		
		for (LPRoleKey i : lpRoleKeys) {
			//表示拥有权限10的员工可以进入
			if (i.getLpId() == limit) {
				return false;
			}
		}
		return true;

	}
	
}
