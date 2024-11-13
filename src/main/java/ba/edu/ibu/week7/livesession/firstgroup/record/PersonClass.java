package ba.edu.ibu.week7.livesession.firstgroup.record;

import java.util.Date;
import java.util.Objects;

class PersonClass {
    private String name;
    private int age;
    private Date dateOfBirth;

    public PersonClass(String name, int age, Date dateOfBirth) {
        this.name = name;
        this.age = age;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age=" + age + ", Date Of Birth: " + dateOfBirth;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof PersonClass){
            PersonClass obj = (PersonClass) object;
            if(obj.getAge() == this.age)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dateOfBirth);
    }
}

record Person(String name, int age, Date dateOfBirth){
    public Person(String name){
        this(name, 30, null);
    }

    public void printSomething() {
        System.out.println("something");
    }
}

class Main {
    public static void main(String[] args) {
        PersonClass personClass = new PersonClass("Becir", 30, new Date());
        Person person = new Person("Becir", 30, new Date());
        Person person2 = new Person("Becir", 301, new Date());

        System.out.println(personClass);
        System.out.println(person.age());
    }
}
