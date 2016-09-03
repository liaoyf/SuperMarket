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

import com.sm.mybatis.mb.*;

@Controller
public class ShenHeOrderControllerUI {

	@Autowired
	private OrderMapper torderdao;
	@Autowired
	private StateMapper tstatedao;
	@Autowired
	private StaffMapper tstaffdao;
	@Autowired
	private SupplierMapper tsupplierdao;
	@Autowired
	private GoodsOrderMapper tgoodsorderdao;
	@Autowired
	private GoodsMapper tgoodsdao;
	@Autowired
	private LPRoleMapper Lpdao;

	// 查询返回到JSP显示
	@RequestMapping("/main/shenhe")
	public String search(Integer pageNum, Integer orderId, ModelMap mm,
			HttpSession ss) throws UnsupportedEncodingException {
		if (check(ss, 6))
			return "/err";

		// 查询实现
		// List<TOrder> rs = torderdetaildao.selectOnceByMap();
		// mm.addAttribute("torder", rs);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("stateId", 2);

		// 查询实现
		List<Order> wsh = torderdao.selectWeiShenHe(params);
		mm.addAttribute("order", wsh);

		// 把查询到的 tstaff对象门传到jsp
		List<Staff> rs3 = tstaffdao.selectOnceByMap(params);
		mm.addAttribute("staff", rs3);

		// 把查询到的 tsupplier对象门传到jsp
		List<Supplier> rs4 = tsupplierdao.selectOnceByMap(params);
		mm.addAttribute("supplier", rs4);

		// 把查询到的 tstate对象门传到jsp
		List<State> rs5 = tstatedao.selectOnceByMap(params);
		mm.addAttribute("state", rs5);

		// 根据order表中的order_ID用tgoodsorderkey查到goodsId 得到goodsname
		List<GoodsOrderKey> key = tgoodsorderdao.selectOnceByMap(params);
		mm.addAttribute("tgoodsorderkey", key);
		List<Goods> goods = tgoodsdao.selectOnceByMap(params);
		System.out.println("goodsName:" + goods.get(0).getGoodsName());
		mm.addAttribute("goods", goods);

		return "/ShenHeOrder";// 等同于/WEB-INF/jsp/user.jsp
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/shenhe/pass")
	public String edit(int[] orderId) {
		// 得到选择的orderId。
		for (int i = 0; i < orderId.length; i++) {
			System.out.println("orderId是" + orderId[i]);
			Order to = torderdao.selectByPrimaryKey(orderId[i]);
			to.setStateId(3);
			torderdao.updateByPrimaryKey(to);
			System.out.println("审核完成");
		}
		return "redirect:../shenhe";// 请求重定向
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
