package cn.itcast.web.controller.company;

import cn.itcast.domain.company.Company;
import cn.itcast.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/list" , name = "企业列表")
	public String list(HttpServletRequest request) {

		List<Company> list = companyService.findAll();
		request.setAttribute("list",list);
		return "company/company-list";
	}

	//保存
	@RequestMapping(value = "/save" , name = "添加企业")
	public String save(Date date) {
		System.out.println(date);
		return "success";
	}
}
