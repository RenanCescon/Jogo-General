import java.util.Scanner;

public class usaGeneral {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        General g = new General();

        g.rolarDados();
        g.imprimirDados();
        System.out.println();
        g.imprimirJogadas();
        System.out.println();

        System.out.println("Qual jogada vai escolher? ");
        int n = sc.nextInt();

        g.pontuarJogada(n);
        g.imprimirJogadas();
        System.out.println();
        System.out.println(g.getPTotal());

    }
}
