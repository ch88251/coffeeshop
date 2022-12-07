package com.coffeeshop.service;

import com.coffeeshop.web.dto.CartDto;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ApplicationScoped
@Transactional
public class CartService {

    public List<CartDto> findAll() {
        return new ArrayList<>();
    }
}
