package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Description;
import com.sivitsky.ddr.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"description"})
public class DescriptionController {

    private DescriptionService descriptionService;

    @Autowired(required=true)
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @RequestMapping("/part/description")
    public Model startDescription(Model model){
        model.addAttribute("description", new Description());
        return model;
    }

    @RequestMapping(value="/part/description/add", method = RequestMethod.POST)
    public String addDescription(@ModelAttribute("description") Description description, BindingResult result){
        descriptionService.saveDescription(description);
        return "redirect:/part";
    }
}
