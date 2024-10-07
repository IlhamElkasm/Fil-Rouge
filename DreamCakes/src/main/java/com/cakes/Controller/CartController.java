package com.cakes.Controller;


import com.cakes.DTO.CommandeDto;
import com.cakes.DTO.GateauDto;
import com.cakes.Model.Cart;
import com.cakes.Model.User;
import com.cakes.Repository.UserRepository;
import com.cakes.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody GateauDto gateauDto, @AuthenticationPrincipal User user) {
        User utilisateurVerifie = userRepository
                .findById(user.getId())
                .orElseThrow(()-> new RuntimeException("utilisateur not found"));


        return cartService.addToCart(gateauDto, user);
    }
}
