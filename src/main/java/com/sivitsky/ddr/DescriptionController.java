package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Description;
import com.sivitsky.ddr.model.Specification;
import com.sivitsky.ddr.service.DescriptionService;
import com.sivitsky.ddr.service.PartService;
import com.sivitsky.ddr.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"description"})
public class DescriptionController {

    private DescriptionService descriptionService;
    private PartService partService;
    private SpecificationService specificationService;
    private List<Description> descriptionList = new ArrayList<Description>();

    @Autowired(required=true)
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @Autowired(required=true)
    public void setSpecificationService(SpecificationService specificationService) {
        this.specificationService = specificationService;
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
        for (Specification specification: specificationService.listSpecification()){
            Description description = new Description();
            description.setPart(partService.getPartById(part_id));
            description.setSpecification(specification);
            description.setDescript_name(specification.getSpec_name());
            descriptionList.add(description);
            Long id = description.getDescript_id();
        }
        model.addAttribute("descriptionList", descriptionList);
        return "description";
    }

   /* @RequestMapping(value="/part/descript/add", method = RequestMethod.POST)
    public String addDescriptionPost(@ModelAttribute("description") Description description, BindingResult result){
        descriptionService.saveDescription(description);
        return "redirect:/part/list";
    }*/

    @RequestMapping(value="/part/descript/add", method = RequestMethod.POST)
    public String addDescriptionPost(@ModelAttribute("descriptionList") List<Description> descriptionList, BindingResult result){
        for(Description description: descriptionList) {
            descriptionService.saveDescription(description);
        }
        return "redirect:/part/list";
    }
}
