package com.sivitsky.ddr;

import com.sivitsky.ddr.model.Order;
import com.sivitsky.ddr.service.OfferService;
import com.sivitsky.ddr.service.OrderService;
import com.sivitsky.ddr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class CartController {
    private OrderService orderService;
    private OfferService offerService;
    private UserService userService;

    @Autowired(required = true)
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @Autowired(required = true)
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/cart/add/{offer_id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable("offer_id") Long offer_id, @RequestParam(value="quantity", required = false) Integer quantity, Principal principal) throws ParseException {
        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar();

        String sdate = sdf.format(new Date());

        System.out.println(calendar); //15/10/2013
        Date date = sdf.parse("2016-02-08 02:46:05");
        order.setOffer(offerService.getOfferById(offer_id));
        order.setOrder_date(new Date());
        order.setPart(offerService.getOfferById(offer_id).getPart());
        order.setOrder_num(quantity);
        order.setUser(userService.getUserByName(principal.getName()));
        orderService.saveOrder(order);
        return "redirect:/offers/partinfo/"+offerService.getOfferById(offer_id).getPart().getPart_id();
    }
}
