package ru.gb.ordermanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.ordermanager.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}
