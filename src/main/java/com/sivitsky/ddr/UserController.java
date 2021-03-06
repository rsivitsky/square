package com.sivitsky.ddr;

import com.sivitsky.ddr.model.ListRole;
import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.repository.UserRepository;
import com.sivitsky.ddr.service.RoleService;
import com.sivitsky.ddr.service.UserService;
import com.sivitsky.ddr.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"user"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String startPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());
        model.addAttribute("listRoles", roleService.getRoles());
        model.addAttribute("listVendors", vendorService.listVendor());
        return "user";
    }

    //For add and update person both
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            userRepository.save(user);
        }
        return "redirect:/user";
    }

    @RequestMapping("/remove/{user_id}")
    public String removeUser(@PathVariable("user_id") Long id) {
        userRepository.delete(id);
        return "redirect:/user";
    }

    @RequestMapping("/edit/{user_id}")
    public String editUser(@PathVariable("user_id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listUsers", userService.listUsers());
        model.addAttribute("listRoles", roleService.getRoles());
        model.addAttribute("listVendors", vendorService.listVendor());
        return "user";
    }

    @RequestMapping("/account")
    public String editAccount(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        if (user.getRole().equals(ListRole.ROLE_ADMIN.toString())) {
            model.addAttribute("listRoles", roleService.getRoles());
        } else {
            model.addAttribute("listRoles", roleService.getRolesWithoutAdmin());
        }
        model.addAttribute("listVendors", vendorService.listVendor());
        return "account";
    }

    @RequestMapping(value = "/account/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (user.getVendor().getVendor_id() == null) {
                user.setVendor(null);
            }
            if (user.getRole().equals("NONE")) {
                user.setRole(ListRole.ROLE_USER.toString());
            }
            userRepository.save(user);
        }
        return "redirect:/";
    }
}
