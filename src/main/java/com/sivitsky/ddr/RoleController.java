package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Role;
import com.sivitsky.ddr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"role"})
public class RoleController {

	private RoleService roleService;

	@Autowired(required=true)
	public void setRoleService(RoleService roleService)
	{
		this.roleService = roleService;
	}

	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public String startPage(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("listRole", roleService.listRole());
		return "role";
	}

	@RequestMapping(value= "/role/add", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role, BindingResult result){
		role = this.roleService.saveRole(role);
		return "redirect:/role";
	}
	
	@RequestMapping("/role/remove/{role_id}")
    public String removeRole(@PathVariable("role_id") Long id){
        this.roleService.removeRole(id);
        return "redirect:/role";
    }
 
    @RequestMapping("/role/edit/{role_id}")
    public String editRole(@PathVariable("role_id") Long id, Model model){
        model.addAttribute("role", this.roleService.getRoleByID(id));
        model.addAttribute("listRole", this.roleService.listRole());
        return "role";
    }

}
