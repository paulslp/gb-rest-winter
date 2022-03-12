package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.rest.dto.OrderProductDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController implements OrderApi {

    private final OrderApi orderApi;

    @Override
    @GetMapping("/{orderId}")
    public OrderProductDto get(@PathVariable Long orderId) {
        return orderApi.get(orderId);
    }

    @Override
    @PostMapping
    public Long save() {
        return orderApi.save();
    }

    @Override
    @PutMapping(value = "/{orderId}/{productId}", produces = "application/json;charset=UTF-8")
    public OrderProductDto addProduct(@PathVariable Long orderId,
                                      @PathVariable Long productId) {
        return orderApi.addProduct(orderId, productId);
    }

    @Override
    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("orderId") Long id) {
        orderApi.deleteById(id);
    }


    @Override
    @DeleteMapping(value = "/{orderId}/{productId}", produces = "application/json;charset=UTF-8")
    public OrderProductDto deleteProduct(@PathVariable Long orderId,
                                         @PathVariable Long productId) {
        return orderApi.deleteProduct(orderId, productId);
    }
}
