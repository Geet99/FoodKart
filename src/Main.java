import model.OrderDetails;
import repository.FoodKartRepository;
import service.*;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FoodKartRepository repository = new FoodKartRepository();
        RestaurantSelectionStrategy selectionStrategy = new RestaurantSelectionStrategyImpl(repository);
        RestaurantService restaurantService = new RestaurantServiceImpl(repository);
        CustomerService customerService = new CustomerServiceImpl(repository, selectionStrategy);

        restaurantService.addRestaurant("resta1", Map.of("king_burger", 10d, "samosa_pizza", 20d, "alu_pasta", 19d), 15);
        restaurantService.addRestaurant("resta2", Map.of("bendi_macaroni", 12d, "samosa_pizza", 25d, "alu_pasta", 17d), 20);
        restaurantService.updateMenu("resta1", Map.of("bendi_macaroni", 8d, "king_burger", 15d));
        restaurantService.printAll();
        customerService.bookOrder("cust1", Map.of("bendi_macaroni", 3, "samosa_pizza", 2));
        customerService.bookOrder("cust2", Map.of("alu_pasta", 5, "samosa_pizza", 5));
        customerService.bookOrder("cust2", Map.of("alu_pasta", 5, "samosa_pizza", 7));
        restaurantService.printAll();
        customerService.printAll();
        customerService.markAsDelivered("order1");
        restaurantService.printAll();
    }
}