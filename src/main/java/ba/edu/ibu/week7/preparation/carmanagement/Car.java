package ba.edu.ibu.week7.preparation.carmanagement;

public class Car extends Vehicle{
    private CarType carType;
    private String engineType;

    public Car(String vehicleId, String name, double rentalRate, CarType carType, String engineType){
        super(vehicleId, name, rentalRate);
        this.carType = carType;
        this.engineType = engineType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Car Type: " + this.carType + ", Engine Type: " + engineType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
