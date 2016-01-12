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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"manufacturFilterList"})
public class HomeController {
    private PartService partService;
    private ManufacturService manufacturService;
    private List<ManufacturFilterService> manufacturFilterList = new ArrayList<ManufacturFilterService>();

    void setUsageAsFalse() {
        for (ManufacturFilterService manufacturFilter : manufacturFilterList) {
            manufacturFilter.setUsage(false);
        }
    }

    void setUsageAsTrue(Long[] array_manufacturs) {
        for (Long select_id : array_manufacturs) {
            for (ManufacturFilterService manufacturFilter : manufacturFilterList) {
                if (manufacturFilter.getManufactur().getManufactur_id().equals(select_id)) {
                    manufacturFilter.setUsage(true);
                }
            }
        }
    }

    @Autowired(required = true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @Autowired(required = true)
    public void setManufacturService(ManufacturService manufacturService) {
        this.manufacturService = manufacturService;
        //manufacturFilterList=new ArrayList<ManufacturFilterService>();
        if (manufacturService.listManufactur().size() > 0) {
            for (Manufactur manufactur : manufacturService.listManufactur()) {
                ManufacturFilterService manufacturFilterService = new ManufacturFilterService();
                manufacturFilterService.setManufactur(manufactur);
                manufacturFilterService.setUsage(false);
                manufacturFilterList.add(manufacturFilterService);
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String startPage(@RequestParam(value = "manufacturs", required = false) String[] array_manufacturs, Model model) {
        setUsageAsFalse();
        if (array_manufacturs != null && array_manufacturs.length > 0) {
            Long[] l_array_manufacturs = new Long[array_manufacturs.length];
            for(int i = 0;i < array_manufacturs.length;i++)
            {
                l_array_manufacturs[i] = Long.parseLong(array_manufacturs[i]);
            }
            setUsageAsTrue(l_array_manufacturs);
            model.addAttribute("listPart", partService.listPartWithManufactursFilter(l_array_manufacturs));
        }
        else {
            model.addAttribute("listPart", partService.listPartWithDetail());
        }
        model.addAttribute("manufacturFilterList", manufacturFilterList);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String startPagePost(Model model) {
        model.addAttribute("listPart", partService.listPartWithDetail());
        model.addAttribute("manufacturFilterList", manufacturFilterList);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String startPageIdx() {
        return "redirect:/";
    }
}
