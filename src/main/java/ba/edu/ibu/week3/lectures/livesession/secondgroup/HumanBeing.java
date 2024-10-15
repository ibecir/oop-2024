package ba.edu.ibu.week3.lectures.livesession.secondgroup;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HumanBeing {
    public String name;
    public String surname;
    public int age;
    public Gender gender;

    public HumanBeing(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public static void main(String[] args) {
        ArrayList<HumanBeing> humanBeings = new ArrayList<>();
        humanBeings.add(new HumanBeing("Becir", "Isakovoc", 30, Gender.MALE));
        humanBeings.add(new HumanBeing("Eldar", "Satara", 20, Gender.MALE));
        humanBeings.add(new HumanBeing("Azra", "Arnautovic", 20, Gender.FEMALE));

        for (HumanBeing humanBeing : humanBeings) {
            System.out.println(humanBeing.name + " " + humanBeing.surname + " " + humanBeing.age + " " + humanBeing.gender);
        }

        System.out.println("--------------------------------");

        ArrayList<HumanBeing> filteredList = filterHumanBeings(humanBeings, Gender.FEMALE);
        for (HumanBeing humanBeing : filteredList) {
            System.out.println(humanBeing.name + " " + humanBeing.surname + " " + humanBeing.age + " " + humanBeing.gender);
        }

        Optional<HumanBeing> optionalHumanBeing = filterHumanBeing(humanBeings, "Becira");
        if(optionalHumanBeing.isPresent())
            System.out.println("I'm there");
        else
            System.out.println("I'm not there");
    }

    public static ArrayList<HumanBeing> filterHumanBeings(ArrayList<HumanBeing> humanBeings, Gender gender) {
        ArrayList<HumanBeing> filteredHumanBeings = new ArrayList<>();
        for(HumanBeing humanBeing : humanBeings) {
            if(humanBeing.gender == gender) {
                filteredHumanBeings.add(humanBeing);
            }
        }
        return filteredHumanBeings;
    }
    public static List<HumanBeing> filterHumanBeingsWithStreams(ArrayList<HumanBeing> humanBeings, Gender gender) {
        return humanBeings
                .stream()
                .filter(humanBeing -> humanBeing.gender == gender)
                .toList();
    }
    public static Optional<HumanBeing> filterHumanBeing(ArrayList<HumanBeing> humanBeings, String name) {
        return humanBeings
                .stream()
                .filter(humanBeing -> humanBeing.name == name)
                .findFirst();
    }
}
