package com.solucionar.admin.web.company;

import com.solucionar.admin.model.Company;
import com.solucionar.admin.service.CompanyService;
import com.solucionar.admin.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController extends BaseController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = { "/list" })
    public String list(Model model) {
        List<Company> companies = companyService.findAll();

        model.addAttribute("companies", companies);

        configure(model);

        return "company/company-list";
    }

    private void configure(Model model) {
        model.addAttribute("companySection", Boolean.TRUE);
        model.addAttribute("pageTitle", getMessage("message.title.companies"));
    }
}
