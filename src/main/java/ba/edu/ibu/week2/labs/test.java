package ba.edu.ibu.week2.labs;

public class test {
    public static int divisibleByNine(int num1, int num2) {

        int sum = 0;
        for(int i = num1; i < num2; i++){
            if(i%9==0){
                sum+=i;
            }

        }

        return sum;


    }

    public static void main(String[] args) {
        System.out.println(divisibleByNine(1,10));
    }

}