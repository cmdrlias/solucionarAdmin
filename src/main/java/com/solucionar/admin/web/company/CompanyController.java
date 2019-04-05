package com.solucionar.admin.web.company;

import com.solucionar.admin.model.Address;
import com.solucionar.admin.model.Company;
import com.solucionar.admin.model.Phone;
import com.solucionar.admin.model.Representative;
import com.solucionar.admin.service.CompanyService;
import com.solucionar.admin.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @RequestMapping(value = { "/add" })
    public String add(Model model) {
        configure(model);
        return "company/company-add";
    }

    @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model) {

        String cmpName =          request.getParameter("name");
        String cmpSocialName =    request.getParameter("socialName");
        String cmpInscEstadual =  request.getParameter("inscEstadual");
        String cmpInscMunicipal = request.getParameter("inscMunicipal");

        String phoAreaCode1 =     request.getParameter("area1");
        String phoNumber1 =       request.getParameter("phone1");
        String phoAreaCode2 =     request.getParameter("area2");
        String phoNumber2 =       request.getParameter("phone2");

        String addZipCode =       request.getParameter("zipCode");
        String addStreet =        request.getParameter("street");
        String addNeighborhood =  request.getParameter("neighborhood");
        String addNumber =        request.getParameter("number");
        String addComplement =    request.getParameter("complement");
        String addCity =          request.getParameter("city");
        String addState =         request.getParameter("state");

        String repName =          request.getParameter("repName");
        String repEmail =         request.getParameter("repEmail");

        Company company = new Company();

        company.setCmpName(cmpName);
        company.setCmpSocialName(cmpName);
        company.setCmpInscricaoEstadual(cmpInscEstadual);
        company.setCmpInscricaoMunicipal(cmpInscMunicipal);

        Address address = new Address();

        address.setAddCountry("Brasil");
        address.setAddStreet(addStreet);
        address.setAddNeighborhood(addNeighborhood);
        address.setAddNumber(addNumber);
        address.setAddComplement(addComplement);
        address.setAddCity(addCity);
        address.setAddState(addState);
        address.setAddZipCode(addZipCode);

        company.setAddress(address);

        List<Phone> phones = new ArrayList<>();

        if (StringUtils.isNotBlank(phoNumber1)) {
            Phone phone1 = new Phone();
            phone1.setPhoNumber(Integer.valueOf(phoNumber1));
            phone1.setPhoAreaCode(Short.valueOf(phoAreaCode1));
            phones.add(phone1);
        } else if (StringUtils.isNotBlank(phoNumber2)) {
            Phone phone2 = new Phone();
            phone2.setPhoNumber(Integer.valueOf(phoNumber2));
            phone2.setPhoAreaCode(Short.valueOf(phoAreaCode2));
            phones.add(phone2);
        }

        company.setPhones(phones);

        Representative representative = new Representative();

        representative.setRepName(repName);
        representative.setRepEmail(repEmail);

        company.setRepresentative(representative);

        companyService.add(company);

        setModalSuccess(getMessage("message.companies.success.add"), model);

        configure(model);
        return list(model);
    }

    private void configure(Model model) {
        model.addAttribute("companySection", Boolean.TRUE);
        model.addAttribute("pageTitle", getMessage("message.title.companies"));
    }
}
