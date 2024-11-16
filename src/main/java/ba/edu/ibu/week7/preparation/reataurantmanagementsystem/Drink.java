package ba.edu.ibu.week7.preparation.reataurantmanagementsystem;

class Drink extends MenuItem {
    private double volume;

    public Drink(String code, String name, double price, double volume) {
        super(code, name, price);
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Volume: " + volume + "ml";
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
