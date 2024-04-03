package model;

import java.util.List;

public class Order {
    String orderId;
    String user;
    List<OrderDetails> orderDetails;
    OrderStatus status;

    public Order(String orderId, String user, List<OrderDetails> orderDetails) {
        this.orderId = orderId;
        this.user = user;
        this.orderDetails = orderDetails;
        this.status = OrderStatus.ORDERED;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", user='" + user + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}