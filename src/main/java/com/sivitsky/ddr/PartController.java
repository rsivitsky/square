package com.sivitsky.ddr;

import com.sivitsky.ddr.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"part"})
public class PartController {
    private DescriptionService descriptionService;

    @Autowired(required=true)
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }


}
