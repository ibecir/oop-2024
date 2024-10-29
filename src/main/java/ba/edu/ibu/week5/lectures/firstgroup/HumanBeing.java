package ba.edu.ibu.week5.lectures.firstgroup;

class HumanBeing {
    private String name;
    private int age; // Should be deleted
    private double weight;
    private MyCustomDate dateOfBirth;

    public HumanBeing(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public HumanBeing(String name, int age, double weight, MyCustomDate dateOfBirth) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean olderThen(HumanBeing humanBeing){
        return this.age > humanBeing.getAge();
    }

    @Override
    public String toString(){
        return this.name + " - " + " whose date of birth is " + this.dateOfBirth;
    }

    public static void main(String[] args) {
        HumanBeing becir = new HumanBeing("Becir", 30, 75, new MyCustomDate(25,7,1994));
        HumanBeing mirza = new HumanBeing("Mirza", 22, 75, new MyCustomDate(1,1,2002));

        System.out.println(mirza);
    }
}

class MyCustomDate{
    private int day;
    private int month;
    private int year;

    public MyCustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return this.day + "-" + this.month + "-" + this.year;
    }
}

class Counter {
    private int value;

    public Counter() {
        this(0);
    }
    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public int getValue() {
        return value;
    }

    public void grow() {
        this.value++;
    }
    public String toString() {
        return "value: " + this.value;
    }

    public Counter clone() {
        // lets create a new counter object, that gets as its initial value
        // the value of the counter that is being cloned
        Counter clone = new Counter(this.value);

        // return the clone to the caller
        return clone;
    }

    @Override
    public boolean equals(Object comperedCounter){
        if(comperedCounter == null)
            return false;

        if(comperedCounter instanceof Counter) {
            Counter counter = (Counter) comperedCounter;
            if(this.value == counter.getValue())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Counter myCounter = new Counter();
        myCounter.grow();
        myCounter.grow();

        System.out.println(myCounter);

        Counter myNewCounter = myCounter.clone();
        myNewCounter.grow();
        System.out.println(myNewCounter);
        System.out.println(myCounter.equals(myNewCounter));
    }
}

