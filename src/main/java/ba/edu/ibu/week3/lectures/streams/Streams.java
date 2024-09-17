package ba.edu.ibu.week3.lectures.streams;

import ba.edu.ibu.week3.lectures.enums.Gender;
import ba.edu.ibu.week3.lectures.models.User;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
    private List<User> users;

    public Streams() {
        users = Arrays.asList(
                new User("Becir", Gender.MALE, 29),
                new User("Fatima", Gender.FEMALE, 105),
                new User("Adnan", Gender.MALE, 35));
    }

    public List<User> getAll() {
        return this.users;
    }

    public Optional<User> getByName(String name) {
        return users
                .stream()
                .filter(user -> {
                    return user.getName().equals(name);
                }).findFirst();
    }

    public List<User> findAgeGreaterThan(int age) {
        return users
                .stream()
                .filter(user -> age >= user.getAge())
                .toList();
    }

    public void getByGender(Gender gender) {
        users = users.stream()
                .filter(user -> user.getGender().equals(gender))
                .collect(Collectors.toList());
        for (User u : users) {
            System.out.println(u.getName());
        }
    }
}

