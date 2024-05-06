package com.pierogarnia.viulinu.controller;

import com.pierogarnia.viulinu.model.Item;
import com.pierogarnia.viulinu.model.order.Order;
import com.pierogarnia.viulinu.model.user.Person;
import com.pierogarnia.viulinu.repository.ItemRepository;
import com.pierogarnia.viulinu.repository.PersonRepository;
import com.pierogarnia.viulinu.repository.order.OrderRepository;
import com.pierogarnia.viulinu.service.CartService;
import com.pierogarnia.viulinu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final OrderService orderService;
    private final PersonRepository personRepository;

    public List<Order> showOrders() {
        return orderRepository.findAll();
    }
    public List<Person> showPersons() {return personRepository.findAll();}



    @Autowired
    public AdminController(ItemRepository itemRepository, OrderRepository orderRepository, CartService cartService, OrderService orderService, PersonRepository personRepository) {
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.orderService = orderService;
        this.personRepository = personRepository;
    }

    @PostMapping
    private String addItem(Item item) {
        itemRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/showorders")
    public String orders(Model model, Model model2, Model model3){
        model.addAttribute("orders",showOrders());
        model2.addAttribute("items", cartService.getAllItems());
        model3.addAttribute("orderitems",orderService.getAllItems());
        return "adminview/showorders";
    }

    @GetMapping("/showusers")
    public String users(Model model){
        model.addAttribute("users",showPersons());
        return "adminview/showusers";
    }
    @GetMapping
    private String adminPage() {
        return "adminview/addItem";
    }
}