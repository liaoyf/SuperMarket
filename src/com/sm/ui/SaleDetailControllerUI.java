package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.sm.mybatis.mb.*;

@Controller
public class SaleDetailControllerUI {

	@Autowired
	private SaleDetailMapper dao;
	@Autowired
	private GoodsMapper tgoodsdao;
	@Autowired
	private SaleMapper tsaledao;
	@Autowired
	private GoodsStockMapper tgoodsstockdao;
	@Autowired
	private StockMapper tstockdao;
	@Autowired
	private StaffMapper tstaffdao;
	@Autowired
	private VipMapper tvipdao;
	@Autowired
	private LPRoleMapper Lpdao;

	// 查询返回到JSP显示
	@RequestMapping("/main/saledetail")
	public String search(Integer pageNum, Integer saleDetailId,
			Integer goodsId, Integer saleId, ModelMap mm, HttpSession ss)
			throws UnsupportedEncodingException {
		if(check(ss,8)){
			return "/err";
		}
		// 商品名下拉框实现
		List<Goods> goods = new ArrayList<Goods>();
		goods = tgoodsdao.selectAll();
		mm.addAttribute("goods", goods);

		// 销售号下拉框实现
		List<Sale> sale = new ArrayList<Sale>();
	sale = tsaledao.selectAll();
		mm.addAttribute("sale", sale);

		// 查询实现
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("saleDetailId", saleDetailId);
		params.put("goodsId", goodsId);
		System.out.println(goodsId);

		params.put("saleId", saleId);

		//根据params查TSaleDetail表。
		//List<TSaleDetail> rs = dao.selectOnceByMap(params);
		System.out.println("saleId是 "+saleId);
		 List<SaleDetail> rs = dao.selectSaleIdNull(params);
		mm.addAttribute("saledetail", rs); // 把查询的saledetail对象们传到jsp

		// 把查询的tgoods对象们传到jsp
		List<Goods> rs1 = tgoodsdao.selectOnceByMap(params);
		mm.addAttribute("goods", rs1);

		// 把查询到的 tstaff对象传到jsp
		Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
		mm.addAttribute("staff", staff);

		// 把查询到的 tvip对象门传到jsp
		List<Vip> rs4 = tvipdao.selectOnceByMap(params);
		mm.addAttribute("vip", rs4);

		// 把查询到的 tstock对象门传到jsp
		List<Stock> rs5 = tstockdao.selectOnceByMap(params);
		mm.addAttribute("stock", rs5);
		// 把查询的tgoodsstock对象传到jsp
		List<GoodsStock> rs2 = tgoodsstockdao.selectOnceByMap(params);
		mm.addAttribute("tgoodsstock", rs2);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mm.addAttribute("date", df.format(new Date()));
		
		return "/SaleDetail";// 等同于/WEB-INF/jsp/user.jsp
	}

	// 初始化，新增/修改操作前置的JSP视图
	@RequestMapping({ "/main/saledetail/add", "/main/saledetail/edit" })
	public String initAddEditJsp(Integer saleDetailId, ModelMap mm) {
		if (null != saleDetailId) {
			SaleDetail saledetail = dao.selectByPrimaryKey(saleDetailId);
			mm.addAttribute("saledetail", saledetail);
		}
		GoodsExample tg = new GoodsExample();
		String name = "%";
		tg.createCriteria().andGoodsNameLike(name);
		List<Goods> goods = new ArrayList<Goods>();
		goods = tgoodsdao.selectByExample(tg);
		mm.addAttribute("goods", goods);
		List<Sale> sale = new ArrayList<Sale>();
		sale = tsaledao.selectAll();
		mm.addAttribute("sale", sale);
		// 请求转发到JSP
		return "/SaleDetailCU";
	}

	// 新增，操作完成后跳转到查询URL
	@RequestMapping(method = RequestMethod.POST, value = "/main/saledetail/add/handler")
	public String add(SaleDetail dto) {
		System.out.println("做了新增动作");
		System.out.println("货物id" + dto.getGoodsId() + "货物折扣"
				+ dto.getGoodsDiscount() + "购买数量" + dto.getNumber() + "货物价格"
				+ dto.getPrice());
		
		Goods g = tgoodsdao.selectByPrimaryKey(dto.getGoodsId());
		dto.setPrice(g.getGoodsPrice());

		//dao.updateByPrimaryKey(dto);
		dao.insert(dto);
		return "redirect:../../saledetail";// 请求重定向
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main/saledetail/edit/handler")
	public String edit(SaleDetail dto) {
		System.out.println("做了编辑动作");
		
		Goods g = tgoodsdao.selectByPrimaryKey(dto.getGoodsId());
		dto.setPrice(g.getGoodsPrice());	
		dao.updateByPrimaryKey(dto);
		return "redirect:../../saledetail";// 请求重定向
	}

	@RequestMapping("/main/saledetail/del")
	public String del(Integer saleDetailId) {
		System.out.println("做了删除动作");
		dao.deleteByPrimaryKey(saleDetailId);
		return "redirect:../saledetail";// 请求重定向
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
