package com.pierogarnia.viulinu.service;

import com.pierogarnia.viulinu.Cart;
import com.pierogarnia.viulinu.dto.OrderDto;
import com.pierogarnia.viulinu.mapper.OrderMapper;
import com.pierogarnia.viulinu.model.order.Order;
import com.pierogarnia.viulinu.model.order.OrderItem;
import com.pierogarnia.viulinu.repository.order.OrderItemRepository;
import com.pierogarnia.viulinu.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
        cart.cleanCart();
    }

    public List<OrderItem> getAllItems() {
        return orderItemRepository.findAll();
    }
}
