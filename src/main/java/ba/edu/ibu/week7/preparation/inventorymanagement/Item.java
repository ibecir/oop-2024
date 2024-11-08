package ba.edu.ibu.week7.preparation.inventorymanagement;

abstract class Item implements Sellable {
    private String barcode;
    private String name;
    private double price;

    public Item(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double calculateDiscount(double discountRate) {
        return price * (1 - discountRate);
    }

    @Override
    public String getDescription() {
        return String.format("Item: %s, Price: %.2f", name, price);
    }
}

class Milk extends Item {
    private double fat;

    public Milk(String barcode, String name, double price, double fat) {
        super(barcode, name, price);
        this.fat = fat;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format(", Fat: %.1f%%", fat);
    }
}

class Honey extends Item {
    private HoneyType honeyType;

    public Honey(String barcode, String name, double price, HoneyType honeyType) {
        super(barcode, name, price);
        this.honeyType = honeyType;
    }

    public HoneyType getHoneyType() {
        return honeyType;
    }

    public void setHoneyType(HoneyType honeyType) {
        this.honeyType = honeyType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Type: " + honeyType;
    }
}
