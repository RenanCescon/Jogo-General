import java.util.Scanner;

public class Jogo {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Menu m = new Menu();

        char c = 'z';

        // se escolher a opção 'g' o programa para
        while (c != 'g'){
            // mostra o menu de opções
            m.iniciarMenu();
            System.out.println("Escolha sua opção: ");
            c = sc.nextLine().charAt(0);
            if (c < 'g')
                m.opcoes(c);
            else if (c != 'g')
                System.out.println("Opção inválida !");
        }
    }
}
