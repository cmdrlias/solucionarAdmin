package com.solucionar.admin.web.users;

import com.solucionar.admin.model.*;
import com.solucionar.admin.service.UserService;
import com.solucionar.admin.values.UserTypeEnum;
import com.solucionar.admin.web.BaseController;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = { "/list" })
    public String list(Model model) {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        configure(model);
        return "user/user-list";
    }

    @RequestMapping(value = { "/add" })
    public String add(Model model) {
        configure(model);
        return "user/user-add";
    }

    @RequestMapping(value = { "/save" }, method = RequestMethod.POST)
    public String save(HttpServletRequest request, Model model) {
        String usrName =         request.getParameter("username");
        String usrEmail =        request.getParameter("email");
        String perName =         request.getParameter("name");
        String perCpf =          request.getParameter("cpf");
        String ustDescription =  request.getParameter("type");

        String phoAreaCode1 =    request.getParameter("area1");
        String phoNumber1 =      request.getParameter("phone1");
        String phoAreaCode2 =    request.getParameter("area2");
        String phoNumber2 =      request.getParameter("phone2");

        String addZipCode =      request.getParameter("zipCode");
        String addStreet =       request.getParameter("street");
        String addNeighborhood = request.getParameter("neighborhood");
        String addNumber =       request.getParameter("number");
        String addComplement =   request.getParameter("complement");
        String addCity =         request.getParameter("city");
        String addState =        request.getParameter("state");

        User user = new User();

        user.setUsrName(usrName);
        user.setUsrEmail(usrEmail);

        if(ustDescription.equals(UserTypeEnum.SYSTEM_ADMIN.getRoleName())) {
            user.setUsrType(userService.findUserTypeById(1));
        } else {
            user.setUsrType(userService.findUserTypeById(2));
        }

        Person person = new Person();

        person.setPerName(perName);
        person.setPerCpf(perCpf);

        Address address = new Address();

        address.setAddCountry("Brasil");
        address.setAddStreet(addStreet);
        address.setAddNeighborhood(addNeighborhood);
        address.setAddNumber(addNumber);
        address.setAddComplement(addComplement);
        address.setAddCity(addCity);
        address.setAddState(addState);
        address.setAddZipCode(addZipCode);

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

        person.setAddress(address);

        person.setPhones(phones);

        user.setPerson(person);

        String usrPassword = RandomStringUtils.randomAlphanumeric(10);

        user.setUsrPassword(passwordEncoder.encode(usrPassword));

        userService.add(user);

        setModalSuccess(getMessage("message.users.success.add") + usrPassword, model);

        configure(model);
        return list(model);
    }

    private void configure(Model model) {
        model.addAttribute("userSection", Boolean.TRUE);
        model.addAttribute("pageTitle", getMessage("message.title.users"));
    }
}
