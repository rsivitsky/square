package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Vendor;
import com.sivitsky.ddr.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"vendor"})
public class VendorController {

	private VendorService vendorService;

	@Autowired(required=true)
	public void setVendorService(VendorService vendorService)
	{
		this.vendorService = vendorService;
	}

	@RequestMapping(value = "/vendor", method = RequestMethod.GET)
	public String startPage(Model model) {
		model.addAttribute("vendor", new Vendor());
		model.addAttribute("listVendors", vendorService.listVendor());
		return "vendor";
	}

	@RequestMapping(value= "/vendor/add", method = RequestMethod.POST)
	public String addVendor(@ModelAttribute("vendor") Vendor vendor, BindingResult result){
		vendor = this.vendorService.saveVendor(vendor);
		return "redirect:/vendor";
	}
	
	@RequestMapping("/vendor/remove/{vendor_id}")
    public String removeVendor(@PathVariable("vendor_id") int id){
        this.vendorService.removeVendor(id);
        return "redirect:/vendor";
    }
 
    @RequestMapping("/vendor/edit/{vendor_id}")
    public String editVendor(@PathVariable("vendor_id") int id, Model model){
        model.addAttribute("vendor", this.vendorService.getVendorById(id));
        model.addAttribute("listVendors", this.vendorService.listVendor());
        return "vendor";
    }


}
