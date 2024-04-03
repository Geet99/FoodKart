package service;

import model.OrderDetails;

import java.util.List;
import java.util.Map;

public interface RestaurantSelectionStrategy {
    List<OrderDetails> selectRestaurant(Map<String, Integer> items);
}