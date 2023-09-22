import java.util.Scanner;

public class UsaDado {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Dado d = new Dado();

        System.out.println("Quantas vezes quer jogar o dado? ");
        int r = sc.nextInt();

        for (int i = 0; i < r; i++){
            d.roll();
            System.out.println(d.getSideUp());
        }
    }
}
