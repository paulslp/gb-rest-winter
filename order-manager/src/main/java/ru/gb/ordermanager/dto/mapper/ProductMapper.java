package ru.gb.ordermanager.dto.mapper;

import org.mapstruct.Mapper;
import ru.gb.ordermanager.dto.ProductDto;
import ru.gb.ordermanager.entity.Product;

import java.util.Set;

@Mapper
public interface ProductMapper {

    ProductDto toProductDto(Product product);

    Set<ProductDto> toSetProductDto(Set<Product> product);
}
