package com.solucionar.admin.web.dashboard;

import com.solucionar.admin.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpSession session, Model model) {

        model.addAttribute("dashboardSection", Boolean.TRUE);
        model.addAttribute("pageTitle", "Dashboard");
        return "dashboard";
    }
}
