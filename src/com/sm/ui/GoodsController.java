package com.sm.ui;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sm.mybatis.mb.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class GoodsController {

	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private LPRoleMapper Lpdao;

	@RequestMapping("/main/makeGood")
	public String makeGood(HttpSession ss,Integer mes,ModelMap mm) {
		if(check(ss,25)){
			return "/err";
		}
		return "/makeGood";
	}

	@RequestMapping(value = "/main/makeGood/add", method = RequestMethod.POST)
	public String checkGood(Integer mes,ModelMap mm, String name, String price) {
		//插入Goods表
		Goods good = new Goods();
		good.setGoodsName(name);
		good.setGoodsPrice(Float.parseFloat(price));
		goodsDao.insert(good);

		return "redirect:../makeGood";
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
