package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.OrderStatus;
import com.sivitsky.ddr.service.OfferService;
import com.sivitsky.ddr.service.OrderService;
import com.sivitsky.ddr.service.PartService;
import com.sivitsky.ddr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"order"})
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PartService partService;
    @Autowired
    private UserService userService;
    @Autowired
    private OfferService offerService;

    @RequestMapping("/order/list")
    public String orderList(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("orderList", orderService.listOrder());
        model.addAttribute("listOffers", this.offerService.listOffer());
        model.addAttribute("listUser", this.userService.listUsers());
        model.addAttribute("listPart", this.partService.listPart());
        model.addAttribute("status", OrderStatus.values());
        return "order";
    }

    @RequestMapping("/order/remove/{order_id}")
    public String removeOrder(@PathVariable("order_id") Long order_id) {
        this.orderService.removeOrder(order_id);
        return "redirect:/order/list";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrderPost(@ModelAttribute("order") Order order, BindingResult result) {
        this.orderService.saveOrder(order);
        return "redirect:/order/list";
    }

    @RequestMapping("/order/edit/{order_id}")
    public String editOrder(@PathVariable("order_id") Long order_id, Model model) {
        model.addAttribute("order", this.orderService.getOrderById(order_id));
        model.addAttribute("listOffers", this.offerService.listOffer());
        model.addAttribute("listUser", this.userService.listUsers());
        model.addAttribute("listPart", this.partService.listPart());
        model.addAttribute("Status", OrderStatus.values());
        return "order";
    }
}
