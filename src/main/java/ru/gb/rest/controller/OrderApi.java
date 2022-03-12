package ru.gb.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.rest.dto.OrderProductDto;

public interface OrderApi {

    OrderProductDto get(@PathVariable Long orderId);

    Long save();

    OrderProductDto addProduct(Long orderId, Long productId);

    void deleteById(Long id);

    OrderProductDto deleteProduct(Long orderId, Long productId);
}
