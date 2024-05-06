package com.pierogarnia.viulinu.controller;

import com.pierogarnia.viulinu.model.order.Order;
import com.pierogarnia.viulinu.model.user.Person;
import com.pierogarnia.viulinu.repository.PersonRepository;
import com.pierogarnia.viulinu.repository.order.OrderRepository;
import com.pierogarnia.viulinu.service.CartService;
import com.pierogarnia.viulinu.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {

    private final PersonRepository personRepository;
    private final OrderRepository orderRepository;

    private final OrderService orderService;
    private final CartService cartService;
    public List<Order> showOrders() {
        return orderRepository.findAll();
    }
    public List<Person> showPersons() {return personRepository.findAll();}

    public PersonController(PersonRepository personRepository, OrderRepository orderRepository, OrderService orderService, CartService cartService) {
        this.personRepository = personRepository;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @GetMapping("/user/orderuser")
    public String orderuser(Model model, Model model2, Model model3, Model model4, Model model5) {
        model.addAttribute("orders", showOrders());
        model2.addAttribute("items", cartService.getAllItems());
        model3.addAttribute("orderitems", orderService.getAllItems());
        model5.addAttribute("users", showPersons());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model4.addAttribute("nameuser",currentPrincipalName);
        return "user/orderuser";
    }
    @GetMapping("/user/profile")
    public String profil(Model model4, Model model5) {
        model5.addAttribute("users", showPersons());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model4.addAttribute("nameuser",currentPrincipalName);
        return "user/profile";
    }

}
