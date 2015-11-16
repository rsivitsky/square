package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Description;
import com.sivitsky.ddr.service.DescriptionService;
import com.sivitsky.ddr.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"description"})
public class DescriptionController {

    private DescriptionService descriptionService;

    private PartService partService;

    @Autowired(required=true)
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @Autowired(required=true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping("/part/description")
    public Model startDescription(Model model){
        model.addAttribute("description", new Description());
        return model;
    }

    @RequestMapping(value = "/part/descript/add/{part_id}", method = RequestMethod.GET)
    public String addDescriptionGet(@PathVariable("part_id") Long part_id, Model model){
        Description description = new Description();
        description.setPart(partService.getPartById(part_id));
        model.addAttribute("description", description);
        return "description";
    }

    @RequestMapping(value="/part/descript/add", method = RequestMethod.POST)
    public String addDescriptionPost(@ModelAttribute("description") Description description, BindingResult result){
        descriptionService.saveDescription(description);
        return "redirect:/part/list";
    }
}
