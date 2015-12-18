package com.sivitsky.ddr;

import com.sivitsky.ddr.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"part"})
public class AdminController {
    private PartService partService;
   // private DescriptionService descriptionService;

    @Autowired(required=true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }
/*
    @Autowired(required=true)
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage(Model model) {
        model.addAttribute("listPart", partService.listPartWithDetail());
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String startPageo(Model model) {
        return "index";
    }
}
