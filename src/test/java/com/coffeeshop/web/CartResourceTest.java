package com.coffeeshop.web;

import com.coffeeshop.service.CartService;
import com.coffeeshop.web.dto.CartDto;
import com.coffeeshop.web.dto.CustomerDto;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class CartResourceTest {

    @InjectMock
    CartService cartService;

    @Test
    public void testFindAllCartsWhenEmpty() {
        List<CartDto> carts = new ArrayList<>();
        Mockito.when(cartService.findAll()).thenReturn(carts);
        given()
                .when().get("/carts")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    public void testFindAllCartsWithOneCartActive() {
        List<CartDto> carts = new ArrayList<>();
        CustomerDto customerDto = new CustomerDto(1L, "John", "Doe", "jdoe@coffeeshop.com", "555-33-4444");
        CartDto cartDto = new CartDto(1L, customerDto, "PENDING");
        carts.add(cartDto);
        Mockito.when(cartService.findAll()).thenReturn(carts);
        given()
                .when().get("/carts")
                .then()
                .statusCode(200)
                .body(is("[{\"customer\":{\"email\":\"jdoe@coffeeshop.com\",\"firstName\":\"John\",\"id\":1,\"lastName\":\"Doe\",\"telephone\":\"555-33-4444\"},\"id\":1,\"status\":\"PENDING\"}]"));
    }

}
