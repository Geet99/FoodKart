package service;

import model.OrderDetails;
import model.Restaurant;
import repository.FoodKartRepository;

import java.util.*;

public class RestaurantSelectionStrategyImpl implements RestaurantSelectionStrategy {

    private FoodKartRepository repository;

    public RestaurantSelectionStrategyImpl(FoodKartRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderDetails> selectRestaurant(Map<String, Integer> items) {
        Map<String, OrderDetails> orderDetails = new HashMap<>();

        List<Restaurant> restaurants = repository.getRestaurants();

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Restaurant selectedRestaurant = restaurants.stream().filter(r -> (r.getTotalCapacity() - r.getCapacityInUse()) >= entry.getValue()).sorted(Comparator.comparing(r -> r.getMenu().get(entry.getKey()))).findFirst().orElse(null);
            if (selectedRestaurant == null)
                return null;

            this.buildOrder(selectedRestaurant, orderDetails, entry);
            repository.decreaseRestaurantCapacity(selectedRestaurant.getName(), entry.getValue());
        }
        return orderDetails.values().stream().toList();
    }

    private void buildOrder(Restaurant restaurant, Map<String, OrderDetails> orderDetails, Map.Entry<String, Integer> itemEntry) {
        if (orderDetails.containsKey(restaurant.getName())) {
            OrderDetails orderDetails1 = orderDetails.get(restaurant.getName());
            orderDetails1.getItems().put(itemEntry.getKey(), itemEntry.getValue());
            orderDetails1.setCost(orderDetails1.getCost() + itemEntry.getValue() * restaurant.getMenu().get(itemEntry.getKey()));
        } else
            orderDetails.put(restaurant.getName(), new OrderDetails(restaurant.getName(), new HashMap<>(Map.of(itemEntry.getKey(), itemEntry.getValue())), itemEntry.getValue() * restaurant.getMenu().get(itemEntry.getKey())));
    }
}