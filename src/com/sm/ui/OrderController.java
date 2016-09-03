package com.sm.ui;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.sm.mybatis.mb.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class OrderController {

	@Autowired
	private OrderMapper orderDao;
	@Autowired
	private GoodsOrderMapper orderGoodDao;
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private SupplierMapper supplierDao;

	@Autowired
	private LPRoleMapper Lpdao;

	@RequestMapping("/main/makeOrder")
	public String makeOrder(HttpSession ss,Integer err, ModelMap mm) {
		if(check(ss,5)){
			return "/err";
		}
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		System.out.println(staff.getStaffName());
		// 取得货物所有实体并添加到ModelMap中
		GoodsExample goodsEM = new GoodsExample();
		goodsEM.createCriteria().andGoodsIdIsNotNull();
		List<Goods> goods = goodsDao.selectByExample(goodsEM);
		mm.addAttribute("goods", goods);

		// 取得供货商所有实体并添加到ModelMap中
		SupplierExample supplierEM = new SupplierExample();
		supplierEM.createCriteria().andSupplierIdIsNotNull();
		List<Supplier> suppliers = supplierDao.selectByExample(supplierEM);
		mm.addAttribute("suppliers", suppliers);

		if (null != err && 1 == err)
			mm.addAttribute("msg", "输入为空");
		else if (null != err && 2 == err)
			mm.addAttribute("msg", "格式有误");
		return "/makeOrder";
	}

	@RequestMapping(value = "/main/makeOrder/add", method = RequestMethod.POST)
	public String checkOrder(HttpSession session,ModelMap mm, Goods good, Supplier supplier,
			String num, String price) {
		if(check(session, 5)){
			return "/err";
		}
		// 判断输入是否为空
		if (null == num || null == price || "".equals(num.trim())
				|| "".equals(price.trim())) {
			System.out.println("错误");
			return "redirect:../makeOrder?err=1";
		}
		// 判断输入是否为正整数
		else if (!IsInteger(num)||!IsFloat(price)) {
			System.out.println("格式错误");
			return "redirect:../makeOrder?err=2";
		}

		// 取得货物所有实体并添加到ModelMap中
		System.out.println(good.getGoodsId());
		System.out.println(supplier.getSupplierId());
		Order order = new Order();

		order.setGoodsNum(Integer.parseInt(num.trim()));
		order.setGoodsOrderPrice(Float.parseFloat(price.trim()));
		order.setSupplierId(supplier.getSupplierId());

		// 设置经手人
		Staff staff = (Staff)session.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		System.out.println(staff.getStaffName());
		order.setPrincipal(staff.getStaffId());

		// 设置状态
		order.setStateId(2);
		// 插入order,插入后order获得new orderID
		orderDao.insert(order);

		// 插入中间表
		GoodsOrderKey orderGood = new GoodsOrderKey();
		orderGood.setGoodsId(good.getGoodsId());
		orderGood.setOrderId(order.getOrderId());

		orderGoodDao.insert(orderGood);

		return "redirect:../makeOrder";
	}

	// 获得级联Order的Goods
	public Goods GetGood(Order order) {
		GoodsOrderExample orderGoodEM;
		List<GoodsOrderKey> orderGood;
		Goods good;

		orderGoodEM = new GoodsOrderExample();
		orderGoodEM.createCriteria().andOrderIdEqualTo(order.getOrderId());
		orderGood = orderGoodDao.selectByExample(orderGoodEM);
		good = goodsDao.selectByPrimaryKey(orderGood.get(0).getGoodsId());
		return good;
	}

	public static boolean IsFloat(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.')
				return false;
		}
		return true;
	}
	
	public static boolean IsInteger(String str) {
		for (int i = 0; i < str.length(); i++) {

			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
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
