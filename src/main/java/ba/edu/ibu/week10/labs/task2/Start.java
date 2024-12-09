package ba.edu.ibu.week10.labs.task2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Start {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(new Integer[]{9,6,6,8,9});
        Student student = new Student("Osman", 43353, new Integer[]{9,6,6,8,9});


        System.out.println("Reflection on " + gradeAnalyzer.getClass().getName() + " class");
        for(Field f : gradeAnalyzer.getClass().getDeclaredFields()){
            f.setAccessible(true);
            System.out.println("Field: " + f.getName() + " holds value: " + f.get(gradeAnalyzer));
        }

        for(Method m : gradeAnalyzer.getClass().getDeclaredMethods()){
            if(m.getName().startsWith("calculate") || m.getName().startsWith("print")){
                if(!m.getReturnType().equals(void.class)) {
                    System.out.println("Method: *" + m.getName() + "* invoked: " + m.invoke(gradeAnalyzer));
                } else{
                    System.out.println("Method with void return type *" + m.getName() + "* invoked: ");
                    m.invoke(gradeAnalyzer);
                }
            }
        }

        System.out.println("\n \nReflection on " + student.getClass().getName() + " class:");

        for(Field f : student.getClass().getDeclaredFields()){
            f.setAccessible(true);
            System.out.println("Field: " + f.getName() + " holds value: " + f.get(student));
        }

        for(Method m : student.getClass().getDeclaredMethods()){
            if(m.getName().startsWith("calculate") || m.getName().startsWith("print")){
                if(!m.getReturnType().equals(void.class)){
                    System.out.println("Method: " + m.getName() + " invoked: " + m.invoke(gradeAnalyzer));
                } else{
                    System.out.println("Method with void return type *" + m.getName() + "* invoked: ");
                    m.invoke(student);
                }
            }
        }
    }
}
