package ba.edu.ibu.week5.lectures.firstgroup;

public interface Attendable {
    public String beSilent();
    public String followTheLecture();

    public default String doSomething() {
        return "Becireeee";
    }
}
