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




import com.sm.Paging;
import com.sm.mybatis.mb.*;

@Controller
public class OrderControllerUI {

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
	@RequestMapping("/main/order")
	public String search(Integer pageNum,Integer orderId,String goodsName,String supplierName,String staffName,
			ModelMap mm, HttpSession ss) throws UnsupportedEncodingException{
		if(check(ss,26)){
			return "/err";
		}

		Map<String, Object> params = new HashMap<String, Object>();
		
		//查询实现
				params.put("orderId", orderId);
				params.put("goodsName", goodsName);
				params.put("supplierName", supplierName);
				params.put("staffName", staffName);
		Paging page = new Paging();
		page.setPageSize(2);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}
		long count = torderdao.selectCountByOrder(params);

		page.setTotalCount(count);
		params.put("page", page);

		System.out.println("页的大小" + page.getPageSize());

		System.out.println("总页数" + page.getTotalPage());

		System.out.println("总计记录数" + page.getTotalCount());


		
		
//无法用orderId查询
		List<Order> rs2  = torderdao.selectAll();
		mm.addAttribute("order2",rs2);
		List<Order> rs  = torderdao.selectOnceByMap(params);
		mm.addAttribute("order", rs);
		
		// 把查询到的 tstaff对象门传到jsp
		List<Staff> rs3 = tstaffdao.selectAll();
		mm.addAttribute("staff", rs3);
		
		// 把查询到的 tsupplier对象门传到jsp
		List<Supplier> rs4 = tsupplierdao.selectOnceByMap(params);
		mm.addAttribute("supplier", rs4);
		
		// 把查询到的 tstate对象门传到jsp
		List<State> rs5 = tstatedao.selectOnceByMap(params);
		mm.addAttribute("state", rs5);
		
		//根据order表中的order_ID用tgoodsorderkey查到goodsId  得到goodsname
		List<GoodsOrderKey> key = tgoodsorderdao.selectOnceByMap(params);
		
		
		
		mm.addAttribute("goodsorderkey", key);
		
		mm.addAttribute("orderId", orderId);
		mm.addAttribute("goodsName", goodsName);
		mm.addAttribute("supplierName", supplierName);
		mm.addAttribute("staffName", staffName);
		
		List<Goods> goods = tgoodsdao.selectOnceByMap(params);
		mm.addAttribute("goods", goods);
		mm.addAttribute("page", page);
		
		return "/Order";// 等同于/WEB-INF/jsp/user.jsp
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
