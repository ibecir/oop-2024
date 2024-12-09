package ba.edu.ibu.week10.labs.task1.classes;

public abstract class User {
    protected String username;

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
