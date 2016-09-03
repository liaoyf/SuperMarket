package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.mybatis.mb.*;

@Controller
public class CheckControllerUI {
	
	@Autowired
	private OutStockMapper dao;
	@Autowired
	private InStockMapper dao1;
	
	@RequestMapping("/main/checks")
	public String search(Integer outStockId, Integer inStockId, ModelMap mm
			) throws UnsupportedEncodingException {

		Map<String, Object>se=new HashMap<String, Object>();
		se.put("outStockId",outStockId);
		List<OutStock> rs = dao.selectOnceByMap(se);
		mm.addAttribute("outStock", rs);
		
		
		
		Map<String, Object>re=new HashMap<String, Object>();
		re.put("inStockId",inStockId);
	    List<InStock> rr = dao1.selectOnceByMap(re);
	    mm.addAttribute("inStock", rr);
		
		
		return "/check";
		
	}
}
