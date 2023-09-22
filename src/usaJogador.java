import java.util.Scanner;

public class usaJogador {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Jogador j = new Jogador();

        System.out.println("Digite o nome do novo jogador: ");
        String s = sc.nextLine();
        j.adicionarNome(s);

        j.escolherJogada();
        System.out.println(j.mostrarTotal());
    }

}
