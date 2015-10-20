package com.sivitsky.ddr;

import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	/*@RequestMapping(value = "/users", method = RequestMethod.GET)
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
	public String addUser(@ModelAttribute("user") User user){
		
		if(user.getUser_id() == 0){
			//new user, add it
			this.userService.addUser(user);
		}else{
			//existing person, call update
			this.userService.updateUser(user);
		}
		
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{user_id}")
    public String removeUser(@PathVariable("user_id") int id){
		
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{user_id}")
    public String editUser(@PathVariable("user_id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }
	
}
