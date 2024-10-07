package com.cakes.Service;

import com.cakes.DTO.GateauDto;
import com.cakes.Model.Cart;
import com.cakes.Model.Gateau;
import com.cakes.Model.User;
import com.cakes.Repository.CartRepository;
import com.cakes.Repository.GateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private GateauRepository gateauRepo;

    public Cart addToCart(GateauDto gateauDto, User user) {
        // Fetch the Gateau entity using the id from the GateauDto
//        Gateau gateau = gateauRepo.findById(gateauDto.g())
//                .orElseThrow(() -> new RuntimeException("Gateau not found"));

        Gateau gateau = gateauRepo.findById(gateauDto.getIdGateau()).get();

        // Create a new Cart object and set its properties
        Cart cart = new Cart();
        cart.setGateau(gateau);
        cart.setUser(user);

        // Save the Cart entity
        cartRepository.save(cart);
        return cart;
    }
}
