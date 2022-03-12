package ru.gb.ordermanager.controller;

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
import ru.gb.ordermanager.dto.OrderProductDto;
import ru.gb.ordermanager.dto.mapper.OrderMapper;
import ru.gb.ordermanager.entity.Order;
import ru.gb.ordermanager.service.OrderService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @GetMapping("/{orderId}")
    public OrderProductDto get(@PathVariable Long orderId) {
        Optional<Order> order = orderService.findById(orderId);
        return order.map(orderMapper::toOrderProductDto).orElse(null);
    }

    @PostMapping
    public Long save() {
        return orderService.save();
    }

    @PutMapping("/{orderId}/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProduct(@PathVariable Long orderId,
                           @PathVariable Long productId) {
        orderService.addProduct(orderId, productId);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("orderId") Long id) {
        orderService.deleteById(id);
    }


    @DeleteMapping("/{orderId}/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long orderId,
                              @PathVariable Long productId) {
        orderService.deleteProduct(orderId, productId);
    }

}
