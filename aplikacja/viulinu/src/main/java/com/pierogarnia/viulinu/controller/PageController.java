package com.pierogarnia.viulinu.controller;

import com.pierogarnia.viulinu.ItemOperation;
import com.pierogarnia.viulinu.model.Item;
import com.pierogarnia.viulinu.model.order.Order;
import com.pierogarnia.viulinu.model.user.Person;
import com.pierogarnia.viulinu.repository.ItemRepository;
import com.pierogarnia.viulinu.repository.PersonRepository;
import com.pierogarnia.viulinu.repository.order.OrderRepository;
import com.pierogarnia.viulinu.service.CartService;
import com.pierogarnia.viulinu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    private final CartService cartService;
    private final ItemRepository itemRepository;



    @Autowired
    public PageController(ItemRepository itemRepository, OrderRepository orderRepository, CartService cartService, PersonRepository personRepository, OrderService orderService) {
        this.itemRepository = itemRepository;
        this.cartService = cartService;
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    }

    @GetMapping("/**")
    public String error(){
        return "redirect:/";
    }

    @GetMapping("/description/{itemId}")
    public String desc(@PathVariable("itemId") Long itemId, Model model){
        Optional<Item> oItem = itemRepository.findById(itemId);
        if (oItem.isPresent()) {
            Item item = oItem.get();
            model.addAttribute("itemdesc", item);
        }
        return "description";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE);
        model.addAttribute("items", cartService.getAllItems());
        return "redirect:/description/"+itemId;
    }
}

