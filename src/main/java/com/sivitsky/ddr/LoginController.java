package com.sivitsky.ddr;

import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.service.RoleService;
import com.sivitsky.ddr.service.UserService;
import com.sivitsky.ddr.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private VendorService vendorService;

    @RequestMapping(value = "/j_spring_security_check", method = RequestMethod.POST)
    public String loginPagePost(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/registration")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        model.addAttribute("listRoles", roleService.listRole());
        model.addAttribute("listVendors", vendorService.listVendor());
        return "registration";
    }

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/registration";
        }
        if (user.getVendor().getVendor_id() == null) {
            user.setVendor(null);
        }
        this.userService.saveUser(user);
        return "redirect:/index";
    }
}
