package service;

import model.Item;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    void addRestaurant(String name, Map<String, Double> menu, int totalCapacity);
    void updateMenu(String name, Map<String, Double> itemsToUpdate);
    void printAll();
}