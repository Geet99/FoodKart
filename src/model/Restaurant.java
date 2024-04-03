package model;

import java.util.List;
import java.util.Map;

public class Restaurant {
    String name;
    Map<String, Double> menu;
    int totalCapacity;
    int capacityInUse;

    public Restaurant(String name, Map<String, Double> menu, int totalCapacity) {
        this.name = name;
        this.menu = menu;
        this.totalCapacity = totalCapacity;
        this.capacityInUse = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Double> menu) {
        this.menu = menu;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getCapacityInUse() {
        return capacityInUse;
    }

    public void setCapacityInUse(int capacityInUse) {
        this.capacityInUse = capacityInUse;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", totalCapacity=" + totalCapacity +
                ", capacityInUse=" + capacityInUse +
                '}';
    }
}