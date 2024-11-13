package ba.edu.ibu.week7.livesession.secondgroup.recordsandoptionals;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

record Person(String name, Date dateOfBirth){

}

class PersonClass {
    private String name;
    private Date dateOfBirth;

    public PersonClass(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString(){
        return "Name: " + this.name + ", Date Of Birth: " + this.dateOfBirth;
    }

    @Override
    public boolean equals(Object comparedObject){
        if(comparedObject instanceof PersonClass){
            PersonClass object = (PersonClass) comparedObject;
            return this.name.equals(object.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.dateOfBirth);
    }
}

class Main {
    public static void main(String[] args) {
        Person becir = new Person("Becir", new Date());
        Person ray = new Person("ray", new Date());
        System.out.println(becir.equals(ray));
        System.out.println(ray.name());

        PersonClass satara = new PersonClass("Eldar", new Date());
        System.out.println(satara);

        Optional<Person> personOptional = Optional.of(becir);
        if(personOptional.isPresent())
            personOptional.get().name();

        Person b = null;
        if(b != null)
            b.name();

        final int number;
        number = 1 + 2;
    }
}