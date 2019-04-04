package com.solucionar.admin.web.dashboard;

import com.solucionar.admin.model.News;
import com.solucionar.admin.service.NewsService;
import com.solucionar.admin.service.UserService;
import com.solucionar.admin.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends BaseController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String index(HttpSession session, Model model) {
        List<News> news = newsService.findAll();

        model.addAttribute("news", news);
        model.addAttribute("dashboardSection", Boolean.TRUE);
        model.addAttribute("pageTitle", "Dashboard");
        return "dashboard";
    }

    @RequestMapping(value = { "/save-comment" }, method = RequestMethod.POST)
    public String saveComment(HttpServletRequest request, HttpSession session, Model model) {

        String nwsDescription = request.getParameter("description");
        int usrCode = getLoggedUser(session).getUsrCode();

        News news = new News();

        news.setNwsDescription(nwsDescription);
        news.setUser(userService.findByUsrCode(usrCode));

        newsService.add(news);
        setModalSuccess(getMessage("message.dashboard.news.success.add"), model);

        return index(session, model);
    }
}
