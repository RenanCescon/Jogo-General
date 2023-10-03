import java.util.Scanner;

public class Campeonato {
    private Jogador[] jogadores = new Jogador[10];
    private int contJ = 0;

    public void incluirJogador(){
        //Jogador aux = new Jogador();
        if (contJ < 10){
            Scanner sc = new Scanner(System.in);
            String n;
            System.out.println("Digite o nome do novo jogador: ");
            n = sc.nextLine();
            jogadores[contJ] = new Jogador(n);
            contJ++;
        }
    }

    public void excluirJogador(){
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.println("Digite o nome do jogador a ser retirado: ");
        n = sc.nextLine();
        int cont = 0;

        for (int i = 0; i < contJ; i++){
            if ((jogadores[i].getNome()).equals(n)){
                for (int j = i; j < contJ; j++)
                    jogadores[j] = jogadores[j + 1];
                contJ--;
                break;
            }
            cont++;
        }
        if ((cont == contJ) && (cont != 0)){
            System.out.println("Não foi possível encontrar o jogador.");
        }
    }

    public void iniciarCampeonato(){
        for (int i = 0; i < 13; i++){
            for (int j = 0; j < contJ; j++){
                jogadores[j].jogarDados();
                jogadores[j].mostrarJogadas();
                System.out.println();
                jogadores[j].escolherJogada();
            }
        }
    }

    public void mostrarCartela() {
        System.out.println("-- Cartela de Resultados --");
        System.out.print("          ");
        for (int i = 0; i < contJ; i++) {
            System.out.print(jogadores[i].getNome() + "    ");
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            System.out.print((i + 1) + "       ");
            if (i < 9)
                System.out.print(" ");
            for (int j = 0; j < contJ; j++) {
                System.out.print("    " + jogadores[j].mostrarJog(i));
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        System.out.print("Total     ");
        for (int i = 0; i < contJ; i++) {
            System.out.print("    " + jogadores[i].mostrarTotal());
        }
        System.out.println();
    }

    public void gravarEmArquivo(){

    }

    public void lerEmArquivo(){

    }
}
