package com.sivitsky.ddr;

import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.service.MailService;
import com.sivitsky.ddr.service.RoleService;
import com.sivitsky.ddr.service.UserService;
import com.sivitsky.ddr.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"listRolesWithoutAdmin", "listVendors"})
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private VendorService vendorService;
    @Autowired
    private MailService mailService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/j_spring_security_check", method = RequestMethod.POST)
    public String loginPagePost(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/registration")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listRolesWithoutAdmin", roleService.listRoleWithoutAdmin());
        model.addAttribute("listVendors", vendorService.listVendor());
        return "registration";
    }

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "registration";
        }
        if (user.getVendor().getVendor_id() == 0) {
            user.setVendor(null);
        }
        this.userService.saveUser(user);
        this.mailService.sendMail("rsivitsky@gmail.com", user.getEmail(), "registration on http://pansivitsky.net",
                "Hi, " + user.getFirstname() + ",\n your login is: " + user.getLogin() + " \n and your password is: " + user.getPassword());
        autoLogin(user.getLogin(), user.getPassword(), request);
        return "redirect:/index";
    }

    public void autoLogin(String username, String password, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    }
}
