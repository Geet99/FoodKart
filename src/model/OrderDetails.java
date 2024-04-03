package model;

import java.util.Map;
import java.util.Objects;

public class OrderDetails {
    String restaurant;
    Map<String, Integer> items;
    double cost;

    public OrderDetails(String restaurant, Map<String, Integer> items, double cost) {
        this.restaurant = restaurant;
        this.items = items;
        this.cost = cost;
    }

    public OrderDetails(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant, items, cost);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "restaurant='" + restaurant + '\'' +
                ", items=" + items +
                ", cost=" + cost +
                '}';
    }
}