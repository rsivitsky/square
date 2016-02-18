package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Currency;
import com.sivitsky.ddr.model.Measure;
import com.sivitsky.ddr.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"currency"})
public class CurrencyController {
    private CurrencyService currencyService;

    @Autowired(required=true)
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "/currency", method = RequestMethod.GET)
    public String getCurrency(Model model) {
        model.addAttribute("currency", new Currency());
        model.addAttribute("listCurrency", currencyService.listCurrency());
        return "currency";
    }

    @RequestMapping(value= "/currency/add", method = RequestMethod.POST)
    public String addMeasure(@ModelAttribute("currency") Currency currency, BindingResult result){
        this.currencyService.saveCurrency(currency);
        return "redirect:/currency";
    }

    @RequestMapping("/currency/remove/{currency_id}")
    public String removeCurrency(@PathVariable("currency_id") Long id){
        this.currencyService.removeCurrency(id);
        return "redirect:/currency";
    }

    @RequestMapping("/currency/edit/{currency_id}")
    public String editCurrency(@PathVariable("currency_id") Long id, Model model){
        model.addAttribute("currency", this.currencyService.getCurrencyById(id));
        model.addAttribute("listCurrency", this.currencyService.listCurrency());
        return "currency";
    }

}
