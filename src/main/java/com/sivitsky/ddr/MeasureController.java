package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Measure;
import com.sivitsky.ddr.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"measure"})
public class MeasureController {

    @Autowired
    private MeasureService measureService;

    @RequestMapping(value = "/measure", method = RequestMethod.GET)
    public String getMeasure(Model model) {
        model.addAttribute("measure", new Measure());
        model.addAttribute("listMeasure", measureService.listMeasure());
        return "measure";
    }

    @RequestMapping(value = "/measure/add", method = RequestMethod.POST)
    public String addMeasure(@ModelAttribute("measure") Measure measure, BindingResult result) {
        this.measureService.saveMeasure(measure);
        return "redirect:/measure";
    }

    @RequestMapping("/measure/remove/{measure_id}")
    public String removeMeasure(@PathVariable("measure_id") Long id) {
        this.measureService.removeMeasure(id);
        return "redirect:/measure";
    }

    @RequestMapping("/measure/edit/{measure_id}")
    public String editMeasure(@PathVariable("measure_id") Long id, Model model) {
        model.addAttribute("measure", this.measureService.getMeasureById(id));
        model.addAttribute("listMeasure", this.measureService.listMeasure());
        return "measure";
    }

}
