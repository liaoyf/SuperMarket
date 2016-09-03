package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@Controller
public class SaleControllerUI {

	@Autowired
	private SaleDetailMapper tsaledetaildao;
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
	private OutStockMapper toutstockdao;
	@Autowired
	private LPRoleMapper Lpdao;

	// 查询返回到JSP显示
	@RequestMapping("/main/sale")
	public String search(Integer pageNum, Integer staffId, String saleTime,
			ModelMap mm, HttpSession ss) throws UnsupportedEncodingException {
		if(check(ss,8)){
			return "/err";
		}
		// 查询实现
		Map<String, Object> params = new HashMap<String, Object>();
		// 销售员下拉框查询
		List<Staff> staff = new ArrayList<Staff>();
		staff = tstaffdao.selectOnceByMap(params);
		mm.addAttribute("staff", staff);

		// 转换date
		SimpleDateFormat stf = new SimpleDateFormat();
		Date date2 = null;
		if (saleTime != null && saleTime.equals("")) {

			try {
				date2 = stf.parse(saleTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			params.put("saleTime", date2);
		}

		params.put("staffId", staffId);

		// 把查询到的 tsale对象门传到jsp

		Paging page = new Paging();
		page.setPageSize(2);
		if (null == pageNum) {
			page.setPageNum(1);
		} else {
			page.setPageNum(pageNum);
		}

		long count = tsaledao.selectCountBySale(params);

		page.setTotalCount(count);
		params.put("page", page);

		// 把查询到的 tvip对象门传到jsp
		List<Sale> rs = tsaledao.selectOnceByMap(params);
		mm.addAttribute("sale", rs);
		List<Vip> rs4 = tvipdao.selectOnceByMap(params);
		mm.addAttribute("vip", rs4);
		mm.addAttribute("staffId", staffId);
		mm.addAttribute("saleTime", date2);
		mm.addAttribute("page", page);
		return "/Sale";// 等同于/WEB-INF/jsp/user.jsp
	}

	// 显示销售的一组详情。
	@RequestMapping("/main/sale/edit")
	public String initAddEditJsp(Integer saleId, ModelMap mm) {
		// 将saleId的值传到saleCU.jsp
		if (null != saleId) {
			Sale sale = tsaledao.selectByPrimaryKey(saleId);
			mm.addAttribute("sale", sale);
		}

		// 传tsaledetail 进行id比较展示
		List<SaleDetail> saledetail = new ArrayList<SaleDetail>();
		saledetail = tsaledetaildao.selectAll();
		mm.addAttribute("saledetail", saledetail);

		// 传tgoods显示货物名字
		GoodsExample tg = new GoodsExample();
		String name = "%";
		tg.createCriteria().andGoodsNameLike(name);
		List<Goods> goods = new ArrayList<Goods>();
		goods = tgoodsdao.selectByExample(tg);
		mm.addAttribute("goods", goods);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("saleId", saleId);

		// 把查询的tsaledetail对象传到jsp
		List<SaleDetail> rs2 = tsaledetaildao.selectOnceByMap(params);
		mm.addAttribute("saledetail", rs2);

		// 把查询的tgoodsstock对象传到jsp
		List<GoodsStock> rs3 = tgoodsstockdao.selectOnceByMap(params);
		mm.addAttribute("goodsstock", rs3);

		List<Stock> rs4 = tstockdao.selectOnceByMap(params);
		mm.addAttribute("stock", rs4);
		// // 查询sale
		// List<TSale> tsale = new ArrayList<TSale>();
		// tsale = tsaledao.selectAll();
		// mm.addAttribute("tsale", tsale);
		// 请求转发到JSP
		return "/SaleCU";
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// 新增，操作完成后跳转到查询URL
	@RequestMapping("/main/sale/add")
	public String add(String saleTime, Integer staffId, Integer vipId,
			String saleNum) {

		Sale dto = new Sale();
		// 时间格式的转化
		Date vaild = null;
		try {
			vaild = sdf.parse(saleTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		dto.setSaleTime(vaild);

		dto.setStaffId(staffId);
		dto.setVipId(vipId);
		dto.setSaleNum(Float.parseFloat(saleNum));
		tsaledao.insert(dto);

		// 查询最大的saleId（即为新增的销售记录）然后传给jsp
		Map<String, Object> params = new HashMap<String, Object>();

		List<Sale> rs6 = tsaledao.selectOnceByMap(params);
		Integer max = rs6.get(0).getSaleId();
		for (int i = 0; i < rs6.size(); i++) {
			if (max < rs6.get(i).getSaleId()) {
				max = rs6.get(i).getSaleId();
			}
		}
		// 1
		Sale sale = tsaledao.selectByPrimaryKey(max);
		// 查出全部的saledetail
		List<SaleDetail> saledetaills = tsaledetaildao.selectAll();
		// 查出全部的tgoodsstock
		List<GoodsStock> rs10tgoodsstock = tgoodsstockdao.selectAll();
		// 将saleId为空的saledetail找出，
		List<SaleDetail> saledetailrs = new ArrayList<SaleDetail>();
		for (int i = 0; i < saledetaills.size(); i++) {
			if (saledetaills.get(i).getSaleId() == null) {
				saledetailrs.add(saledetaills.get(i));
			}
		}
		for (int i = 0; i < saledetailrs.size(); i++) {
			params.put("goodsId", saledetailrs.get(i).getGoodsId());
			List<GoodsStock> rs8 = tgoodsstockdao.selectOnceByMap(params);
			if (rs8.isEmpty()) {
				//在仓库中此种货物已经卖完
				 return "redirect:../saledetail";
			}
			// 让每一个新建的TSaleDetail的saleId等于max,以便于后期查看详情
			saledetailrs.get(i).setSaleId(max);
			tsaledetaildao.updateByPrimaryKey(saledetailrs.get(i));
			// 4F
			// 新建一个出库记录
			OutStock tos = new OutStock();
			tos.setGoodsId(saledetailrs.get(i).getGoodsId()); // 插入货物名字
			tos.setGoodsOutNum(saledetailrs.get(i).getNumber());// 插入出库数量
			tos.setOutStockPrincipal(staffId); // 出库负责人
			tos.setOutStockTime(sale.getSaleTime());// 出库时间
			// 仓库id
			for (int j = 0; j < rs10tgoodsstock.size(); j++) {
				if (rs10tgoodsstock.get(j).getGoodsId() == saledetailrs.get(i)
						.getGoodsId())
					tos.setStockId(rs10tgoodsstock.get(j).getStockId());
			}
			toutstockdao.insert(tos);
			// 根据goodsId查找到t_goods_stock

			// 修改查到的t_goods_stock中的数据 num和 time
			// 4
			rs8.get(0).setGoodsNum(
					rs8.get(0).getGoodsNum() - saledetailrs.get(i).getNumber());
			// rs8.get(0).getGoodsNum()-rs7.get(i).getNumber()
			// 5

			rs8.get(0).setChangeTime(sale.getSaleTime());
			// 6 时间更新有误

			// 在sql中修改t_goods_stock中的数据 num和 time
			tgoodsstockdao.updateByPrimaryKey(rs8.get(0));

			// 根据vip_ID查到对应的t_vip表。根据t_sale表中的sale_num修改查到的t_vip中的vip积分。
			params.put("goodsId", saledetailrs.get(i));
			// dao.updateByPrimaryKey(dto);
		}

		// 根据vip_ID查到对应的t_vip表。根据t_sale表中的sale_num修改查到的t_vip中的vip积分。
		System.out.println("这是参数"+params);
		List<Vip> vipls = tvipdao.selectOnceByMap(params);
		for (int j = 0; j < vipls.size(); j++) {
			if (vipls.get(j).getVipId().equals(dto.getVipId())) {
				float num=vipls.get(j).getVipConTotal();
				num=dto.getSaleNum()+num;
				vipls.get(j).setVipConTotal(num);
				if(num<=299){
					vipls.get(j).setVipLevel("青铜会员");
				}else if(num>=300&&num<=799){
					vipls.get(j).setVipLevel("白银会员");
				}else if(num>=800&&num<=1199){
					vipls.get(j).setVipLevel("黄金会员");
				}else{
					vipls.get(j).setVipLevel("钻石会员");
				}
				tvipdao.updateByPrimaryKey(vipls.get(j));
			}
		
		}

		return "redirect:../sale"; // 请求重定向
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
