package com.sivitsky.ddr;

import com.sivitsky.ddr.service.ManufacturService;
import com.sivitsky.ddr.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@SessionAttributes({"part"})
public class HomeController {
    private PartService partService;
    private ManufacturService manufacturService;

    @Autowired(required=true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @Autowired(required=true)
    public void setManufacturService(ManufacturService manufacturService) {
        this.manufacturService = manufacturService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage(Model model) {
        model.addAttribute("listPart", partService.listPartWithDetail());
        model.addAttribute("listManufactur", manufacturService.listManufactur());
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String startPageIdx() {
        return "redirect:/";
    }
}
