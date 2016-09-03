package com.sm.ui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sm.mybatis.mb.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


@Controller
public class StockController {

	@Autowired
	private OrderMapper orderDao;
	@Autowired
	private GoodsOrderMapper orderGoodDao;
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private StockMapper stockDao;
	@Autowired
	private InStockMapper inStockDao;
	@Autowired
	private GoodsStockMapper goodsStockDao;
	@Autowired
	private LPRoleMapper Lpdao;

	// 入库审核
	@RequestMapping("/main/checkInStock")
	public String test(HttpSession ss,ModelMap mm) throws java.text.ParseException {
		if(check(ss,5)){
			Staff staff = (Staff) ss.getAttribute(Flags.SESSION_USER_LOGIN_FLAG);
			System.out.println(staff.getStaffName());
			return "/err";
		}
		List<Order> queryOrder = orderDao.selectTwoByMap();
		for (int i = 0; i < queryOrder.size(); i++) {
			if (queryOrder.get(i).getState().getStateId() != 3) {
				System.out.println(queryOrder.get(i).getState().getStateId());
				continue;
			}
			
			// 取得good
			queryOrder.get(i).setGoods(GetGood(queryOrder.get(i)));
			// System.out.println("id:" + queryOrder.get(i).getOrderId()
			// + "    goodName:"
			// + queryOrder.get(i).getGoods().getGoodsName());
		}
		mm.addAttribute("order", queryOrder);
		return "/checkInStock";
	}

	//入库
	@RequestMapping(value = "/main/InStock", method = RequestMethod.POST)
	public void InSTock(HttpSession session,HttpServletRequest req, HttpServletResponse resp)
			throws IOException, java.text.ParseException {
		
		Order order;
		Stock stock;
		InStock inStock;
		GoodsStock goodsStock;
		GoodsStockExample goodsStockEM;

		// 初始化定位仓库为第一个
		int stock_index = 0;
		Map<String, Object> params = new HashMap<String, Object>();
		List<Stock> queryStock = stockDao.selectOnceByMap(params);
		stock = queryStock.get(stock_index);
		System.out.println("正在进行审核");
		String getId = req.getParameter("orderId");
		// System.out.println(getId);
		String[] resultId = getId.split(",");
		// 设定时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		System.out.println(date);
		Date vaild = null;
		try {
			vaild = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// try-catch用来防止访问stock越界
		try {
			for (int i = 0; i < resultId.length; i++) {
				// 取得货物名称
				order = orderDao.selectByPrimaryKey(Integer
						.parseInt(resultId[i]));
				// System.out.println(GetGood(order).getGoodsName());
				if (order.getGoodsNum() < stock.getStockVolume()) {

					// 插入t_in_stock表
					inStock = new InStock();

					// 设置入库时间
					inStock.setInStockTime(vaild);

					// 设置所入的库
					inStock.setStockId(stock.getStockId());

					// 设置经手人
					Staff staff = (Staff)(session.getAttribute(Flags.SESSION_USER_LOGIN_FLAG));	
					inStock.setInStockPrincipal(staff.getStaffId());

					// 设置货物ID
					inStock.setGoodsId(GetGood(order).getGoodsId());
					// 设置货物数量
					inStock.setGoodsInNum(order.getGoodsNum());
					// 插入这条新语句
					inStockDao.insert(inStock);
					// 更新stock仓储容量
					stock.setStockVolume(stock.getStockVolume()
							- order.getGoodsNum());
					stockDao.updateByPrimaryKey(stock);
					// 重新定位stock
					stock_index = 0;

					// 插入t_goods_stock表
					goodsStock = new GoodsStock();
					// 设置货物ID
					goodsStock.setGoodsId(GetGood(order).getGoodsId());
					// 设置货物数量
					goodsStock.setGoodsNum(order.getGoodsNum());
					// 设置所入的库
					goodsStock.setStockId(stock.getStockId());
					goodsStock.setChangeTime(vaild);

					goodsStockEM = new GoodsStockExample();
					goodsStockEM.createCriteria()
							.andGoodsIdEqualTo(GetGood(order).getGoodsId())
							.andStockIdEqualTo(stock.getStockId());
					
					List<GoodsStock> queryGoodsStock = goodsStockDao.selectByExample(goodsStockEM);
					if (null == queryGoodsStock || queryGoodsStock.size() != 1) {
						goodsStockDao.insert(goodsStock);
					}else{
						goodsStock.setGoodsStockId(queryGoodsStock.get(0).getGoodsStockId());
						goodsStock.setGoodsNum(queryGoodsStock.get(0).getGoodsNum()+goodsStock.getGoodsNum());
						goodsStockDao.updateByPrimaryKey(goodsStock);
					}

					// 设置时间
					goodsStock.setChangeTime(vaild);

					// 设置订单状态
					order.setStateId(4);
					orderDao.updateByPrimaryKey(order);
				} else {
					// 如果货物数量大于当前仓库容量，则选择下一个仓库存储
					stock_index += 1;
					stock = queryStock.get(stock_index);
					System.out.println("stockVol:" + stock.getStockVolume());
					i--;
					continue;
				}

			}
		} catch (Exception ex) {
			System.out.println("失败");
			ex.printStackTrace();
		}
		// PrintWriter out = resp.getWriter();
		// out.print("zero");
		// System.out.println("out:"+out);
		// out.flush();
		// out.close();
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
