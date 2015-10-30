package com.sivitsky.ddr;

import com.sivitsky.ddr.model.User;
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

	@Autowired(required=true)
	public void setUserService(UserService userService)
	{
		this.userService = userService;
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
		return "user";
	}

	//For add and update person both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result){

		if(user.getUser_id() == 0){
		//if(this.userService.getUserById(user.getUser_id()) == null){
			//new user, add it
			//this.userService.addUser(user);
			this.userService.addUser(user);
		}else{
			//existing person, call update
			this.userService.updateUser(user);
		}
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{user_id}")
    public String removeUser(@PathVariable("user_id") Long id){
		
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{user_id}")
    public String editUser(@PathVariable("user_id") Long id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }

}
