package service;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    boolean bookOrder(String userId, Map<String, Integer> items);
    void markAsDelivered(String orderId);
    void printAll();
}