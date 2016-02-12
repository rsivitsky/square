package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.model.OrderStatus;
import com.sivitsky.ddr.model.User;
import com.sivitsky.ddr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"order"})
public class OrderController {
    private OrderService orderService;
    private PartService partService;
    private UserService userService;
    private OfferService offerService;

    @Autowired(required = true)
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired(required = true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @Autowired(required = true)
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping("/order/list")
    public String orderList(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("orderList", orderService.listOrder());
        model.addAttribute("listOffers", this.offerService.listOffer());
        model.addAttribute("listUser", this.userService.listUsers());
        model.addAttribute("listPart", this.partService.listPart());
        model.addAttribute("Status", OrderStatus.values());
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
