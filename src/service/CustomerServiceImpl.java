package service;

import model.OrderDetails;
import repository.FoodKartRepository;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private FoodKartRepository repository;

    private RestaurantSelectionStrategy selectionStrategy;

    public CustomerServiceImpl(FoodKartRepository repository, RestaurantSelectionStrategy selectionStrategy) {
        this.repository = repository;
        this.selectionStrategy = selectionStrategy;
    }

    @Override
    public boolean bookOrder(String userId, Map<String, Integer> items) {
        List<OrderDetails> orderDetails = selectionStrategy.selectRestaurant(items);
        if (orderDetails == null) {
            System.out.println("SORRY Order can't be completed");
            return false;
        }
        return repository.bookOrder(userId, orderDetails);
    }

    @Override
    public void markAsDelivered(String orderId) {
        repository.markAsDelivered(orderId);
    }

    @Override
    public void printAll() {
        repository.printAllOrders();
    }
}