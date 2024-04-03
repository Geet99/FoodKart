package repository;

import model.Order;
import model.OrderDetails;
import model.OrderStatus;
import model.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FoodKartRepository {
    Map<String, Restaurant> restaurants = new HashMap<>();
    Map<String, Order> orders = new HashMap<>();

    private static int orderId = 1;

    public void addRestaurant(String name, Map<String, Double> menu, int totalCapacity) {
        restaurants.put(name, new Restaurant(name, new HashMap<>(menu), totalCapacity));
        System.out.println(STR."Restaurant \{name} added successfully.");
    }

    public void updateMenu(String name, Map<String, Double> itemsToUpdate) {
        restaurants.get(name).getMenu().putAll(itemsToUpdate);
        System.out.println(STR."Restaurant \{name} menu updated successfully.");
    }

    public boolean bookOrder(String userId, List<OrderDetails> orderDetails) {
        String orderId = "order" + String.valueOf(this.orderId++);
        orders.put(orderId, new Order(orderId, userId, orderDetails));
        orderDetails.forEach(o -> System.out.println(STR."\{orderId}, \{o.getRestaurant()}"));
        return true;
    }

    public void markAsDelivered(String orderId) {
        orders.get(orderId).setStatus(OrderStatus.DELIVERED);
        orders.get(orderId).getOrderDetails().forEach(o -> this.freeRestaurantCapacity(o.getRestaurant(),
                o.getItems().values().stream().mapToInt(Integer::valueOf).sum()));
    }

    public List<Restaurant> getRestaurants() {
        return restaurants.values().stream().toList();
    }

    private void freeRestaurantCapacity(String name, int capacity) {
        Restaurant restaurant = restaurants.get(name);
        restaurant.setCapacityInUse(restaurant.getCapacityInUse() - capacity);
    }

    public void decreaseRestaurantCapacity(String name, int capacity) {
        Restaurant restaurant = restaurants.get(name);
        restaurant.setCapacityInUse(restaurant.getCapacityInUse() + capacity);
    }

    public void printAllOrders() {
        System.out.println(orders.values());
    }

    public void printAllRestaurants() {
        System.out.println(restaurants.values());
    }
}