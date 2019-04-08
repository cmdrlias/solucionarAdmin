package com.solucionar.admin.web.company;

import com.solucionar.admin.model.*;
import com.solucionar.admin.service.CompanyService;
import com.solucionar.admin.service.LogService;
import com.solucionar.admin.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController extends BaseController {
    @Autowired
    CompanyService companyService;

    @Autowired
    private LogService logService;

    @RequestMapping(value = { "/list" })
    public String list(Model model) {
        List<Company> companies = companyService.findAll();

        model.addAttribute("companies", companies);

        configure(model);

        return "company/company-list";
    }

    @RequestMapping(value = { "/add" })
    public String add(Model model) {
        int countAddress = 0;
        int countPhone = 0;
        int countRep = 0;

        model.addAttribute("countAddress", countAddress);
        model.addAttribute("countPhone", countPhone);
        model.addAttribute("countRep", countRep);

        configure(model);
        return "company/company-add";
    }

    @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model) {

        String cmpName =          request.getParameter("name");
        String cmpSocialName =    request.getParameter("socialName");
        String cmpInscEstadual =  request.getParameter("inscEstadual");
        String cmpInscMunicipal = request.getParameter("inscMunicipal");

        Company company = new Company();

        company.setCmpName(cmpName);
        company.setCmpSocialName(cmpSocialName);
        company.setCmpInscricaoEstadual(cmpInscEstadual);
        company.setCmpInscricaoMunicipal(cmpInscMunicipal);

        String phoAreaCode1 =     request.getParameter("area1");
        String phoNumber1 =       request.getParameter("phone1");
        String phoAreaCode2 =     request.getParameter("area2");
        String phoNumber2 =       request.getParameter("phone2");

        List<Phone> phones = new ArrayList<>();

        if (StringUtils.isNotBlank(phoNumber1)) {
            Phone phone1 = new Phone();
            phone1.setPhoNumber(Integer.valueOf(phoNumber1));
            phone1.setPhoAreaCode(Short.valueOf(phoAreaCode1));
            phones.add(phone1);
        }

        if (StringUtils.isNotBlank(phoNumber2)) {
            Phone phone2 = new Phone();
            phone2.setPhoNumber(Integer.valueOf(phoNumber2));
            phone2.setPhoAreaCode(Short.valueOf(phoAreaCode2));
            phones.add(phone2);
        }

        String addZipCode1 =       request.getParameter("zipCode1");
        String addStreet1 =        request.getParameter("street1");
        String addNeighborhood1 =  request.getParameter("neighborhood1");
        String addNumber1 =        request.getParameter("number1");
        String addComplement1 =    request.getParameter("complement1");
        String addCity1 =          request.getParameter("city1");
        String addState1 =         request.getParameter("state1");

        String addZipCode2 =       request.getParameter("zipCode2");
        String addStreet2 =        request.getParameter("street2");
        String addNeighborhood2 =  request.getParameter("neighborhood2");
        String addNumber2 =        request.getParameter("number2");
        String addComplement2 =    request.getParameter("complement2");
        String addCity2 =          request.getParameter("city2");
        String addState2 =         request.getParameter("state2");

        List<Address> addresses = new ArrayList<>();

        if (StringUtils.isNotBlank(addZipCode1)) {
            Address address = new Address();

            address.setAddCountry("Brasil");
            address.setAddStreet(addStreet1);
            address.setAddNeighborhood(addNeighborhood1);
            address.setAddNumber(addNumber1);
            address.setAddComplement(addComplement1);
            address.setAddCity(addCity1);
            address.setAddState(addState1);
            address.setAddZipCode(addZipCode1);

            addresses.add(address);
        }

        if (StringUtils.isNotBlank(addZipCode2)) {
            Address address = new Address();

            address.setAddCountry("Brasil");
            address.setAddStreet(addStreet2);
            address.setAddNeighborhood(addNeighborhood2);
            address.setAddNumber(addNumber2);
            address.setAddComplement(addComplement2);
            address.setAddCity(addCity2);
            address.setAddState(addState2);
            address.setAddZipCode(addZipCode2);

            addresses.add(address);
        }

        List<Representative> representatives = new ArrayList<>();

        String repName1 =          request.getParameter("repName1");
        String repEmail1 =         request.getParameter("repEmail1");

        String repName2 =          request.getParameter("repName2");
        String repEmail2 =         request.getParameter("repEmail2");

        if(StringUtils.isNotBlank(repName1)) {
            Representative representative = new Representative();

            representative.setRepName(repName1);
            representative.setRepEmail(repEmail1);

            representatives.add(representative);
        }

        if(StringUtils.isNotBlank(repName2)) {
            Representative representative = new Representative();

            representative.setRepName(repName2);
            representative.setRepEmail(repEmail2);

            representatives.add(representative);
        }

        company.setPhones(phones);
        company.setAddresses(addresses);
        company.setRepresentatives(representatives);

        companyService.add(company);

        setModalSuccess(getMessage("message.companies.success.add"), model);

        Log log = new Log();
        log.setLogDescription("EMPRESA " + cmpName + " CADASTRADA NO SISTEMA");
        logService.add(log);

        configure(model);
        return list(model);
    }

    @RequestMapping(value = { "/delete" })
    public String delete(@RequestParam(value="id", required=true) Integer cmpCode, HttpServletRequest request, Model model) {
        Company company = companyService.findByCmpCode(cmpCode);
        companyService.delete(company);

        setModalSuccess(getMessage("message.companies.success.delete"), model);

        return list(model);
    }

    private void configure(Model model) {
        model.addAttribute("companySection", Boolean.TRUE);
        model.addAttribute("pageTitle", getMessage("message.title.companies"));
    }
}
