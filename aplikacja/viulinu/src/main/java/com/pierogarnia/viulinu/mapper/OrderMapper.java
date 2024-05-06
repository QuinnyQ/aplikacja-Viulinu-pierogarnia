package com.pierogarnia.viulinu.mapper;


import com.pierogarnia.viulinu.Cart;
import com.pierogarnia.viulinu.CartItem;
import com.pierogarnia.viulinu.dto.OrderDto;
import com.pierogarnia.viulinu.model.order.Order;
import com.pierogarnia.viulinu.model.order.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .sum(orderDto.getSum())
                .nameuser(orderDto.getNameuser())
                .created(LocalDateTime.now())
                .build();
    }

    public static List<OrderItem> mapToOrderItemList(Cart cart, Order order) {
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem ci: cart.getCartItems()) {
            orderItems.add(new OrderItem(order.getOrderId(), ci.getItem().getId(), ci.getCounter()));
        }
        return orderItems;
    }
}
