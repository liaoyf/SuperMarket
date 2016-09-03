package com.sm.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.mybatis.mb.*;


@Controller
public class VIPController {

	// VIP的DAO
	@Autowired
	private VipMapper vipDao;
	// CreditsDiscount的DAO
	@Autowired
	private CreditsDiscountMapper cdDao;
	// Sale的DAO
	@Autowired
	private SaleMapper saleDao;
	// SaleDetail的DAO
	@Autowired
	private SaleDetailMapper sdDao;


	// 初始化页面
	@RequestMapping("/")
	public String index(Integer err, ModelMap mm) {
		if (null != err && 1 == err)
			mm.addAttribute("msg", "用户名或密码为空");
		else if (null != err && 2 == err)
			mm.addAttribute("msg", "用户名或密码不正确");
		return "/vipLogin";
	}

	// VIP登录处理
	@RequestMapping(value = "/VIPlogin")
	public String VIPLogin(String name, String pwd, HttpSession session) {
		VipExample vipEM = new VipExample();
		vipEM.createCriteria().andVipNameEqualTo(name)
				.andVipPasswordEqualTo(pwd);
		if (null == name || null == pwd || "".equals(name.trim())
				|| "".equals(pwd.trim())) {
			System.out.println("用户名或密码为空");
			return "redirect:/?err=1";
		} else {

			List<Vip> queryVip = vipDao.selectByExample(vipEM);
			if (null == queryVip || queryVip.size() != 1) {
				System.out.println("用户名或密码不正确");
				return "redirect:/?err=2";
			} else {
				// 验证正确状态
				Vip vip = queryVip.get(0);
				session.setAttribute(Flags.SESSION_USER_LOGIN_FLAG, vip);
				// 记录在线的用户数量
				Integer count = (Integer) session.getServletContext()
						.getAttribute(Flags.APPLICATION_VIP_COUNT_FLAG);
				if (count == null) {
					count = 0;
					session.getServletContext().setAttribute(
							Flags.APPLICATION_VIP_COUNT_FLAG, count);
				} else {
					count++;
					session.getServletContext().setAttribute(
							Flags.APPLICATION_VIP_COUNT_FLAG, count);
				}
			}

		}
		return "redirect:VIPStatement";
	}

	// 显示VIP状态
	@RequestMapping(value = "/VIPStatement")
	public String VIPStatement(HttpSession session, ModelMap mm) {
		// 输出VIP实体
		Vip vip = (Vip) session.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		mm.addAttribute("vipInfo", vip);
		// 输出VIP等级实体
		CreditsDiscount cd = cdDao.selectByPrimaryKey(vip.getVipLevel());
		mm.addAttribute("vipLevelInfo", cd);
		// 输出VIP消费记录实体
		SaleExample saleEM = new SaleExample();
		saleEM.createCriteria().andVipIdEqualTo(vip.getVipId());
		List<Sale> querySale = saleDao.selectByExample(saleEM);
		mm.addAttribute("sale", querySale);
		// TSaleDetailExample sdEM = new TSaleDetailExample();
		// sdEM.createCriteria().andSaleIdEqualTo(1);
		// List<TSaleDetail> querySaleDetail = sdDao.selectByExample(sdEM);
		// mm.addAttribute("saleDetail", querySaleDetail);

		return "/VIPStatement";
	}

	// 通过AJAX查看VIP消费明细
	@RequestMapping(value = "/VIPSaleDetail", method = RequestMethod.POST)
	public String VIPSaleDetail(HttpServletRequest req, ModelMap mm)
			throws IOException {
		String saleId = (String) req.getParameter("saleId");
		SaleDetailExample sdEM = new SaleDetailExample();
		sdEM.createCriteria().andSaleIdEqualTo(Integer.parseInt(saleId));
		List<SaleDetail> querySaleDetail = sdDao.selectByExample(sdEM);
		mm.addAttribute("saleDetail", querySaleDetail);
		return "/tableDetail";// 返回tableDetail.jsp为data结果集
	}

	// 修改密码
	@RequestMapping(value = "/VIPChangePWD")
	public String VIPChangePWD(HttpSession session, String pwd1, String pwd2) {
		Vip vip = (Vip) session.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		System.out.println("pwd1:" + pwd1 + "  pwd2:" + pwd2);
		if (null == pwd1 || "".equals(pwd1.trim())) {
			System.out.println("密码为空");
		} else {
			if (!pwd1.equals(pwd2)) {
				System.out.println("密码错误");
			} else {
				vip.setVipPassword(pwd2);
				vipDao.updateByPrimaryKey(vip);
				System.out.println("ok");
			}
		}
		return "/VIPStatement";
	}

	// 登出
	@RequestMapping("vip/logout")
	public String logout(HttpSession s) {
		System.out.println("登出系统");
		s.invalidate();
		return "redirect:/";
	}

}
