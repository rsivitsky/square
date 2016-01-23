package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Measure;
import com.sivitsky.ddr.model.Offer;
import com.sivitsky.ddr.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"offer","listOffers"})
public class OfferController {

    private OfferService offerService;

    @Autowired(required=true)
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping("/offers")
    public String listOffers(Model model) {
        model.addAttribute("offer", new Offer());
        model.addAttribute("listOffers", this.offerService.listOffer());
        return "offers";
    }

    @RequestMapping("/offers/{vendor_id}")
    public String listOffersByVendorId(@PathVariable("vendor_id") Long id, Model model) {
        model.addAttribute("offer", new Offer());
        model.addAttribute("listOffers", this.offerService.getOffersByVendorId(id));
        return "offers";
    }

    @RequestMapping("/offers/remove/{offer_id}")
    public String removeOffer(@PathVariable("offer_id") Long offer_id) {
        this.offerService.removeOffer(offer_id);
        return "redirect:/offers";
    }

    @RequestMapping("/offers/edit/{offer_id}")
    public String editOffer(@PathVariable("offer_id") Long offer_id, Model model) {
        model.addAttribute("offer", this.offerService.getOfferById(offer_id));
        model.addAttribute("listOffers", this.offerService.listOffer());
        return "offers";
    }

    @RequestMapping(value = "/offers/add", method = RequestMethod.POST)
    public String addOffer(@ModelAttribute("offer") Offer offer, BindingResult result) {
        this.offerService.saveOffer(offer);
        return "redirect:/offers";
    }
}
