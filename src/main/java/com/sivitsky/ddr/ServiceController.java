package com.sivitsky.ddr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public String servicePage() {
        return "service";
    }
}
