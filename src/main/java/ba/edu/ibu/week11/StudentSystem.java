package ba.edu.ibu.week11;

import ba.edu.ibu.week11.exceptions.EmptyStudentListException;
import ba.edu.ibu.week11.exceptions.InvalidStudentDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentSystem {
    private List<Student> students;

    public StudentSystem(String fileName) throws InvalidStudentDataException{
        this.students = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = null;
            ArrayList<Student> studentArrayList = new ArrayList<>();
            while((line = br.readLine()) != null){
                String[] studentInfo = line.split(",");
                studentArrayList.add(new Student(
                                        Integer.parseInt(studentInfo[0]),
                                        studentInfo[1],
                                        studentInfo[2],
                                        studentInfo[3],
                                        Double.parseDouble(studentInfo[4])
                                        )
                );
            }
            this.validateStudentData(studentArrayList);
            this.students = studentArrayList;
            br.close();
        } catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }

    public StudentSystem(List<Student> students) throws InvalidStudentDataException{
        this.validateStudentData(students);
        this.students = students;
    }

    public static List<Student> readStudents(String fileName){
        List<Student> readStudents = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = null;
            while((line = br.readLine()) != null){
                String[] studentInfo = line.split(",");
                readStudents.add(new Student(
                                Integer.parseInt(studentInfo[0]),
                                studentInfo[1],
                                studentInfo[2],
                                studentInfo[3],
                                Double.parseDouble(studentInfo[4])
                        )
                );
            }
            br.close();
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } finally {
            return readStudents;
        }
    }

    public int noOfStudents(){
        return this.students.size();
    }

    public Optional<Student> getStudentById(int ID){
        for(Student s : this.students){
            if(s.getID() == ID){
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public Student getHighestGPAStudent(){
        if(this.students == null || this.students.size() == 0){
            throw new EmptyStudentListException("List of students is empty.");
        }
        Student highest = students.get(0);
        for(Student s : students){
            if(s.getGPA() > highest.getGPA()) highest = s;
        }
        return highest;
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException{
        for(Student s : students){
            if(s.getGPA() < 6 || s.getGPA() > 10){
                throw new InvalidStudentDataException("Read data has invalid rows");
            }
        }
    }


}
