package com.coffeeshop.web;

import com.coffeeshop.service.CartService;
import com.coffeeshop.web.dto.CartDto;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/carts")
public class CartResource {

    @Inject
    CartService cartService;

    @GET
    public List<CartDto> findAll() {
        return this.cartService.findAll();
    }

}
