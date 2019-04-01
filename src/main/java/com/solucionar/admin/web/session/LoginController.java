package com.solucionar.admin.web.session;

import com.solucionar.admin.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
@Controller
public class LoginController extends BaseController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = { "/" })
    public String index(HttpServletRequest request, Model model) {
        return login(request, model);
    }

    @RequestMapping(value = { "/login" })
    public String login(HttpServletRequest request, Model model) {
        if (isCurrentAuthenticationAnonymous()) {
            if (request.getParameterMap().containsKey("error")) {
                setModalError(getMessage("message.login.incorrect.credentials"), model);
            }
            return "session/login";
        } else {
            return "redirect:/dashboard";
        }
    }

    @RequestMapping(value = { "/my-logout" })
    public String logout(RedirectAttributes redirectAttributes) {
        setModalWarning(getMessage("message.logout.success"), redirectAttributes);
        return "redirect:/session/login";
    }

    @RequestMapping(value = { "/expired" })
    public String expired(RedirectAttributes redirectAttributes) {
        setModalWarning(getMessage("message.session.expired.multiple.access"), redirectAttributes);
        return "redirect:/session/login";
    }
}