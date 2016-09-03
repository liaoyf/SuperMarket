package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sm.Paging;
import com.sm.mybatis.mb.Goods;
import com.sm.mybatis.mb.GoodsExample;
import com.sm.mybatis.mb.GoodsMapper;
import com.sm.mybatis.mb.LPRoleExample;
import com.sm.mybatis.mb.LPRoleKey;
import com.sm.mybatis.mb.LPRoleMapper;
import com.sm.mybatis.mb.SaleBreakage;
import com.sm.mybatis.mb.SaleBreakageMapper;
import com.sm.mybatis.mb.Staff;
import com.sm.mybatis.mb.Stock;
import com.sm.mybatis.mb.StockExample;
import com.sm.mybatis.mb.StockMapper;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class BreakageController {

	@Autowired
	private SaleBreakageMapper saleBreakDao;
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private StockMapper stockDao;
	@Autowired
	private LPRoleMapper Lpdao;

	// 报损
	@RequestMapping("/main/checkBreakage")
	public String checkBreakage(HttpSession ss,Integer err, ModelMap mm) {
		if(check(ss,9)){
			return "/err";
		}
		List<SaleBreakage> breakageQuery = saleBreakDao.selectOnceByMap();

		mm.addAttribute("saleBreakage", breakageQuery);
		return "/checkBreakage";
	}

	// 查看所有报损记录
	@RequestMapping("/main/breakages")
	public String search(Integer pageNum, String beginTime, String endTime,
			ModelMap mm, HttpSession ss) throws UnsupportedEncodingException,
			java.text.ParseException {
		if(check(ss,26)){
			return "/err";
		}
		Map<String, Object> params = new HashMap<String, Object>();

		// 缺少的方法 是业务层
		// 接受数据
		// 将数据放在ModelMap list集合 集合中放的每一个元素是 Breakage.java
		// 传给页面
		// 在页面进行显示 <c:.....> 知识：页面动态生成 生成的页面是静态的
		// 问题:分页

		SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		Date date2 = null;
		if (beginTime == null||beginTime.equals("")) {
			beginTime = "2000-01-01";
		}
		if (endTime == null||endTime.equals("")) {
			endTime = "2099-09-20";
		}
		if (beginTime != null) {
			try {
				System.out.println("qqqqqqqqqqqq"+date1);
				date1 = stf.parse(beginTime);
				System.out.println("hhhhhhhhhhhh"+date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			params.put("beginTime", date1);
		}
		if (endTime != null) {

			try {
				date2 = stf.parse(endTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			params.put("endTime", date2);
		}
		Paging page = new Paging();
		page.setPageSize(2);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		params.put("beginTime", date1);
		params.put("endTime", date2);

		long count = saleBreakDao.selectCountByBreak(params);
		page.setTotalCount(count);

		params.put("page", page);

		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());

		List<SaleBreakage> rs = saleBreakDao.selectTwoByMap(params);
		mm.addAttribute("beginTime", date1);
		mm.addAttribute("endTime", date2);
		mm.addAttribute("page", page);
		mm.addAttribute("breakages", rs);
		return "/breakage";
	}

	// 报损提交页面
	@RequestMapping("/main/makeBreakage")
	public String makeBreakage(HttpSession ss,Integer err, ModelMap mm) {
		if(check(ss,9)){
			return "/err";
		}

		// 取得货物所有实体并添加到ModelMap中
		GoodsExample goodsEM = new GoodsExample();
		goodsEM.createCriteria().andGoodsIdIsNotNull();
		List<Goods> goods = goodsDao.selectByExample(goodsEM);
		mm.addAttribute("goods", goods);

		// 取得仓库所有实体并添加到ModelMap中
		StockExample stockEM = new StockExample();
		stockEM.createCriteria().andStockIdIsNotNull();
		List<Stock> stocks = stockDao.selectByExample(stockEM);
		mm.addAttribute("stocks", stocks);

		if (null != err && 1 == err)
			mm.addAttribute("msg", "输入为空");
		else if (null != err && 2 == err)
			mm.addAttribute("msg", "格式有误");
		return "/makeBreakage";
	}

	// 报损提交
	@RequestMapping(value = "/main/makeBreakage/add", method = RequestMethod.POST)
	public String checkBreakage(HttpSession session, ModelMap mm, Goods good,
			String num, Stock stock, String reason)
			throws java.text.ParseException {
		// 判断输入是否为空
		if (null == num || "".equals(num.trim())) {
			System.out.println("错误");
			return "redirect:../makeBreakage?err=1";
		} else if (!IsInteger(num)) {
			System.out.println("格式错误");
			return "redirect:../makeBreakage?err=2";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		System.out.println(date);
		Date vaild = null;
		try {
			vaild = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(reason);
		SaleBreakage saleBreakage = new SaleBreakage();
		saleBreakage.setGoodsId(good.getGoodsId());
		saleBreakage.setGoodsNum(Integer.parseInt(num));
		saleBreakage.setStockId(stock.getStockId());
		saleBreakage.setBreakageRemark(reason);
		saleBreakage.setBreakageTime(vaild);

		// 设置经手人
		Staff staff = (Staff)session.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		saleBreakage.setStaffId(staff.getStaffId());
		// 设置状态为待审核
		saleBreakage.setStateId(2);

		saleBreakDao.insert(saleBreakage);

		return "redirect:../makeBreakage";
	}

	// 报损审核
	@RequestMapping(value = "/main/BreakageCheck", method = RequestMethod.POST)
	public String BreakageCheck(HttpSession ss,HttpServletRequest req, HttpServletResponse resp) {
		if(check(ss,6)){
			return "/err";
		}
		SaleBreakage saleBreakage;
		String breakageId = req.getParameter("breakageId");
		String[] resultId = breakageId.split(",");
		for (int i = 0; i < resultId.length; i++) {
			saleBreakage = saleBreakDao.selectByPrimaryKey(Integer
					.parseInt(resultId[i]));
			// 设置报损为完成检查
			saleBreakage.setStateId(3);
			saleBreakDao.updateByPrimaryKey(saleBreakage);
		}
		return null;

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
			//表示拥有权限limit的员工可以进入
			if (i.getLpId() == limit) {
				return false;
			}
		}
		return true;

	}
}
