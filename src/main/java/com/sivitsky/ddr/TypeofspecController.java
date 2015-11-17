package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Typeofspec;
import com.sivitsky.ddr.service.TypeofspecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"Typeofspec"})
public class TypeofspecController {

	private TypeofspecService typeofspecService;

	@Autowired(required=true)
	public void setTypeofspecService(TypeofspecService typeofspecService)
	{
		this.typeofspecService = typeofspecService;
	}

	@RequestMapping(value = "/tspec", method = RequestMethod.GET)
	public String startPage(Model model) {
		model.addAttribute("tspec", new Typeofspec());
		model.addAttribute("listtspec", typeofspecService.listTypeofspec());
		return "tspec";
	}

	@RequestMapping(value= "/tspec/add", method = RequestMethod.POST)
	public String addTypeofspec(@ModelAttribute("tspec") Typeofspec Typeofspec, BindingResult result){
		Typeofspec = this.typeofspecService.saveTypeofspec(Typeofspec);
		return "redirect:/tspec";
	}
	
	@RequestMapping("/tspec/remove/{tspec_id}")
    public String removeTypeofspec(@PathVariable("tspec_id") Long id){
        this.typeofspecService.removeTypeofspec(id);
        return "redirect:/tspec";
    }
 
    @RequestMapping("/tspec/edit/{tspec_id}")
    public String editTypeofspec(@PathVariable("tspec_id") Long id, Model model){
        model.addAttribute("tspec", this.typeofspecService.getTypeofspecByID(id));
        model.addAttribute("listtspec", this.typeofspecService.listTypeofspec());
        return "tspec";
    }
}
