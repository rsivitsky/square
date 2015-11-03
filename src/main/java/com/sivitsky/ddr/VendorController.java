package com.sivitsky.ddr;

import com.sivitsky.ddr.dto.VendorAccountInfoDTO;
import com.sivitsky.ddr.dto.VendorFullInfoDTO;
import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.model.Vendor;
import com.sivitsky.ddr.service.VendorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@Controller
@SessionAttributes({"vendor"})
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @RequestMapping(value = "/vendor", method = RequestMethod.GET)
    @Transactional
    public String startPage(Model model) {
        model.addAttribute("vendor", new Vendor());
        model.addAttribute("listVendors",
                vendorService.listVendor().stream().map(vendor -> {
                    VendorFullInfoDTO dto = new VendorFullInfoDTO();
                    dto.setId(vendor.getId());
                    dto.setName(vendor.getName());
                    dto.getAccounts().addAll(vendor.getAccounts().stream().map(vendorAccount -> {
                        User user = vendorAccount.getUser();
                        return new VendorAccountInfoDTO(user.getId(),
                                StringUtils.join(asList(user.getFirstname(), user.getLastname()), " "),
                                vendorAccount.getRole());
                    }).collect(Collectors.toList()));
                    return dto;
                }).collect(Collectors.toList()));
        return "vendor";
    }

    @RequestMapping(value = "/vendor/add", method = RequestMethod.POST)
    @Transactional
    public String addVendor(@ModelAttribute("vendor") Vendor vendor, BindingResult result) {
        if (vendor.getId() == null) {
            this.vendorService.addVendor(vendor);
        } else {
            this.vendorService.updateVendor(vendor);
        }
        return "redirect:/vendor";
    }

    @RequestMapping(value = "/vendor/add/user", method = RequestMethod.POST)
    public String addUserToVendor() {
        return "redirect:/vendor";
    }

    @RequestMapping("/vendor/remove/{vendor_id}")
    public String removeVendor(@PathVariable("vendor_id") long id) {
        this.vendorService.removeVendor(id);
        return "redirect:/vendor";
    }

    @RequestMapping("/vendor/edit/{vendor_id}")
    public String editVendor(@PathVariable("vendor_id") long id, Model model) {
        model.addAttribute("vendor", this.vendorService.getVendorById(id));
        model.addAttribute("listVendors", this.vendorService.listVendor());
        return "vendor";
    }

}
