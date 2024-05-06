package com.pierogarnia.viulinu.controller;

import com.pierogarnia.viulinu.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final CartService cartService;

    public ProductController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/yerba")
    public String yerba(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "/product/yerba";
    }

    @GetMapping("/naczynka")
    public String naczynka(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "/product/naczynka";
    }

    @GetMapping("/produkty")
    public String produkty(Model model) {
        model.addAttribute("items", cartService.getAllItems());
        return "/product/produkty";
    }
    @GetMapping("/category/{category}")
    public String greenyerba(Model model,Model model2,@PathVariable("category") String category) {
        model.addAttribute("items", cartService.getAllItems());
        model2.addAttribute("category",category);
        return "/product/category";
    }
}
