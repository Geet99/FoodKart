package service;

import model.Item;
import repository.FoodKartRepository;

import java.util.List;
import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {

    private FoodKartRepository repository;

    public RestaurantServiceImpl(FoodKartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addRestaurant(String name, Map<String, Double> menu, int totalCapacity) {
        repository.addRestaurant(name, menu, totalCapacity);
    }

    @Override
    public void updateMenu(String name, Map<String, Double> itemsToUpdate) {
        repository.updateMenu(name, itemsToUpdate);
    }

    @Override
    public void printAll() {
        repository.printAllRestaurants();
    }
}