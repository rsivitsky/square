package com.sivitsky.ddr;

import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.service.RoleService;
import com.sivitsky.ddr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"user"})
public class UserController {

	private UserService userService;
	private RoleService roleService;


	@Autowired(required=true)
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@Autowired(required=true)
	public void setRoleService(RoleService roleService)
	{
		this.roleService = roleService;
	}
/*
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}*/

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", userService.listUsers());
		model.addAttribute("listRoles", roleService.listRole());
		return "user";
	}

	//For add and update person both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result){
		user = this.userService.saveUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/remove/{user_id}")
    public String removeUser(@PathVariable("user_id") Long id){
		
        this.userService.removeUser(id);
        return "redirect:/";
    }
 
    @RequestMapping("/edit/{user_id}")
    public String editUser(@PathVariable("user_id") Long id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
		model.addAttribute("listRoles", this.roleService.listRole());
        return "user";
    }
}
