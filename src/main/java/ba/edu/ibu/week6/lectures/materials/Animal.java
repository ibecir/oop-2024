package ba.edu.ibu.week6.lectures.materials;

class Animal {
    private int numOfLegs;

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public void eat() {
        System.out.println("Animal Eating");
    }
}
