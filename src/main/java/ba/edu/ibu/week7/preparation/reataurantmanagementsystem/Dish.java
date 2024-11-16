package ba.edu.ibu.week7.preparation.reataurantmanagementsystem;

import java.awt.*;

class Dish extends MenuItem {
    private CuisineType cuisineType;
    private String mainIngredient;

    public Dish(String code, String name, double price, CuisineType cuisineType, String mainIngredient) {
        super(code, name, price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cuisine: " + cuisineType + ", Main Ingredient: " + mainIngredient;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }
}
