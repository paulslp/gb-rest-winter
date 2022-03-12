package ru.gb.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.gb.rest.controller.OrderApi;
import ru.gb.rest.dto.OrderProductDto;

@FeignClient(url = "localhost:8888/order", value = "orderGateway")
public interface OrderGateway extends OrderApi {

    @GetMapping("/{orderId}")
    OrderProductDto get(@PathVariable Long orderId);

    @PostMapping
    Long save();

    @PutMapping(value = "/{orderId}/{productId}", produces = "application/json;charset=UTF-8")
    OrderProductDto addProduct(@PathVariable Long orderId,
                               @PathVariable Long productId);

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("orderId") Long id);


    @DeleteMapping(value = "/{orderId}/{productId}", produces = "application/json;charset=UTF-8")
    OrderProductDto deleteProduct(@PathVariable Long orderId,
                                  @PathVariable Long productId);
}
