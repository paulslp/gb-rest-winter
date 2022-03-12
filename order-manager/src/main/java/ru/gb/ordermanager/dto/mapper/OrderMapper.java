package ru.gb.ordermanager.dto.mapper;

import org.mapstruct.Mapper;
import ru.gb.ordermanager.dto.OrderProductDto;
import ru.gb.ordermanager.entity.Order;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {

    OrderProductDto toOrderProductDto(Order order);
}
