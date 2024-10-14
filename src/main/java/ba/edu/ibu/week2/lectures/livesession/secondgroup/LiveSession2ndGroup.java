package ba.edu.ibu.week2.lectures.livesession.secondgroup;

public class LiveSession2ndGroup {
    public static void main(String[] args) {
        doNotUseAi(80);
        System.out.println("Becireee");
    }

    public static void doNotUseAi(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        useAi(4);
    }

    public static void useAi(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        doNotUseAi(4);
    }
}
