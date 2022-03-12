package ru.gb.ordermanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.ordermanager.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
