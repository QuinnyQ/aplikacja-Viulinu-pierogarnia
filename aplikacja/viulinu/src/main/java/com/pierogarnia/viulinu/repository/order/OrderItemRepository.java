package com.pierogarnia.viulinu.repository.order;


import com.pierogarnia.viulinu.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
