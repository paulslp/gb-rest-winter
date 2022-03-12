package ru.gb.ordermanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.ordermanager.dao.OrderDao;
import ru.gb.ordermanager.dao.ProductDao;
import ru.gb.ordermanager.entity.Order;
import ru.gb.ordermanager.entity.Product;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderDao orderDao;

    private final ProductDao productDao;

    @Transactional
    public Optional<Order> findById(Long orderId) {
        return orderDao.findById(orderId);
    }

    @Transactional
    public Long save() {
        return orderDao.save(new Order()).getId();
    }

    @Transactional
    public Order addProduct(Long orderId, Long productId) {
        Optional<Order> order = orderDao.findById(orderId);
        order.ifPresent(it -> {
                    Optional<Product> product = productDao.findById(productId);
                    product.ifPresent(prod -> it.getProducts().add(prod));
                }
        );
        return order.map(orderDao::save).orElse(null);
    }

    public void deleteById(Long orderId) {
        try {
            orderDao.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
            log.error("There isn't order with id {}", orderId);
        }
    }

    public void deleteProduct(Long orderId, Long productId) {
        Optional<Order> order = orderDao.findById(orderId);
        order.ifPresent(it -> {
                    it.getProducts()
                            .removeIf(product -> Objects.equals(product.getId(), productId));
                    orderDao.save(it);
                }
        );
    }
}
