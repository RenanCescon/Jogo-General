import java.util.Scanner;

public class usaCampeonato {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Campeonato camp = new Campeonato();

        System.out.println("Opções do menu:");
        System.out.println("a - Incluir jogador.");
        System.out.println("b - Remover jogador.");
        System.out.println("c - Iniciar campeonato.");
        System.out.println("d - Mostrar a cartela do campeonato");
        System.out.println("e - Gravar campeonato em arquivo.");
        System.out.println("f - Ler campeonato em arquivo.");
        System.out.println("g - Sair da aplicação.");

        char c = 'z';

        while (c != 'g'){
            c = sc.nextLine().charAt(0);
            switch (c){
                case 'a':
                    camp.incluirJogador();
                    break;
                case 'b':
                    camp.excluirJogador();
                    break;
            }
        }
    }
}
