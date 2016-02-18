package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Part;
import com.sivitsky.ddr.service.DescriptionService;
import com.sivitsky.ddr.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@Controller
@SessionAttributes({"part"})
public class PartController {
    private PartService partService;
    private DescriptionService descriptionService;

    @Autowired(required = true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @Autowired(required = true)
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @RequestMapping("/part/list")
    public String startPart(Model model) {
        model.addAttribute("listPart", partService.listPartWithDetail());
        return "part";
    }

    @RequestMapping(value = "/part/add")
    public String addPartGet(Model model) {
        model.addAttribute("part", new Part());
        return "add_part";
    }

    @RequestMapping(value = "/part/add", method = RequestMethod.POST)
    public String addPartPost(@ModelAttribute("part") Part part, @RequestParam(value = "img_file", required = false) javax.servlet.http.Part img_file, BindingResult result) {
        if (img_file != null) {
            byte[] fileContent = null;
            try {
                InputStream inputStream = img_file.getInputStream();
                fileContent = IOUtils.toByteArray(inputStream);
            } catch (IOException ex) {
                System.out.println();
            }
            if (fileContent != null) {
                part.setPhoto(fileContent);
            }
        }
        this.partService.savePart(part);
        return "redirect:/part/list";
    }

    @RequestMapping("/part/remove/{part_id}")
    public String removePart(@PathVariable("part_id") Long part_id) {
        this.partService.removePart(part_id);
        return "redirect:/part/list";
    }

    @RequestMapping("/part/edit/{part_id}")
    public String editPart(@PathVariable("part_id") Long part_id, Model model) {
        model.addAttribute("part", this.partService.getPartById(part_id));
        return "add_part";
    }

    @RequestMapping(value="/part/description/{part_id}", method = RequestMethod.GET)
    public String partDescription(Model model, @PathVariable("part_id") Long part_id) {
        model.addAttribute("part", this.partService.getPartById(part_id));
        model.addAttribute("descriptions", this.descriptionService.listDescriptionByPartId(part_id));
        return "partDescription";
    }
}
