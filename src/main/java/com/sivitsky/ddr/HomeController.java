package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Manufactur;
import com.sivitsky.ddr.service.ManufacturFilterService;
import com.sivitsky.ddr.service.ManufacturService;
import com.sivitsky.ddr.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"manufacturFilterList"})
public class HomeController {
    private PartService partService;
    private ManufacturService manufacturService;
    private List<ManufacturFilterService> manufacturFilterList;

    @Autowired(required=true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @Autowired(required=true)
    public void setManufacturService(ManufacturService manufacturService) {
        this.manufacturService = manufacturService;
        manufacturFilterList=new ArrayList<ManufacturFilterService>();
        if (manufacturService.listManufactur().size()>0){
            for(Manufactur manufactur:manufacturService.listManufactur()){
                ManufacturFilterService manufacturFilterService = new ManufacturFilterService();
                manufacturFilterService.setManufactur(manufactur);
                manufacturFilterService.setUsage(false);
                manufacturFilterList.add(manufacturFilterService);
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage(Model model) {
        model.addAttribute("listPart", partService.listPartWithDetail());
        model.addAttribute("manufacturFilterList", manufacturFilterList);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String startPageIdx() {
        return "redirect:/";
    }
}
