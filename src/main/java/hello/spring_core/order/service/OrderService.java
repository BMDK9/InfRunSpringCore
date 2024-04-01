package hello.spring_core.order.service;

import hello.spring_core.order.entity.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
