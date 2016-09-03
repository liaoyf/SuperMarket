package com.sm.ui;

import java.io.UnsupportedEncodingException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sm.mybatis.mb.*;;


@Controller
public class StaffLimitControllerUI {

	@Autowired
	private LimitPowerMapper lpdao;
	
	@Autowired
	private StaffMapper smdao;
	
	@Autowired
	private LPRoleMapper lprdao; 
	
	@Autowired
	private RoleMapper roledao;
	
	@RequestMapping("/main/stafflimit")
	public String search(Integer staffId,String lPName, ModelMap mm) throws UnsupportedEncodingException{
		String name="%";
		if(lPName!=null)
			name = "%"
					+ new String(lPName.getBytes("ISO-8859-1"), "UTF-8")
					+ "%";
		LimitPowerExample lpex=new LimitPowerExample();
		lpex.createCriteria().andLPNameLike(name);
		System.out.println(name);
		List<LimitPower> rs=lpdao.selectByExample(lpex);
		Staff staff=smdao.selectByPrimaryKey(staffId);
		mm.addAttribute("limit", rs);
		mm.addAttribute("staff",staff);
		
		//通过用户ID求角色ID
		Integer roleId=staff.getRoleId();
		//通过角色ID求角色权限表
		LPRoleExample lprex=new LPRoleExample();
		lprex.createCriteria().andRoleIdEqualTo(roleId);
		List<LPRoleKey>lprole=lprdao.selectByExample(lprex);
		System.out.println("查询到的权限列表大小"+lprole.size());
		mm.addAttribute("lPRole",lprole);
		
		return "/staffPower";
	}
	
	
	}
