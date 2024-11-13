package ba.edu.ibu.week7.preparation.delete;

public class Main {
    public static void main(String[] args) {
        Honey med = new Honey("123", "Medara", 12.3, HoneyType.BAGREMOV);
        System.out.println(med.getDescription());

        Milk meggle = new Milk("232", "mljekara", 2.60, 32.3);
        System.out.println(meggle.getDescription());
    }
}
