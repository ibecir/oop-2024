package ba.edu.ibu.week11;

public class Student {
    private int ID;
    private String name;
    private String university;
    private String department;
    private double GPA;

    public Student(int ID, String name, String university, String department, double GPA) {
        this.ID = ID;
        this.name = name;
        this.university = university;
        this.department = department;
        this.GPA = GPA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString(){
        return "Student name: " + this.name;
    }
}
