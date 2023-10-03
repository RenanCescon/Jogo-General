import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


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
        else{
            System.out.println("Não é possível inserir um novo jogador.");
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
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 13; i++){
            for (int j = 0; j < contJ; j++){
                jogadores[j].jogarDados();
                jogadores[j].mostrarJogadas();
                System.out.println();
                jogadores[j].mostrarSeq();
                System.out.println();
                System.out.println("Para qual jogada deseja marcar? [1, 13] " + jogadores[j].getNome());
                int jog = sc.nextInt();
                while(jogadores[j].mostrarJog(jog - 1) != -1){
                    System.out.println("Jogada inválida.");
                    System.out.println("Escolha a nova jogada: ");
                    jog = sc.nextInt();
                }
                jogadores[j].escolherJogada(jog);
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
        System.out.println("");
        File arquivo = new File("Campeonato.dat");
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(jogadores);

            oos.flush();
            oos.close();
            fout.close();
            System.out.println("Arquivo campeonato Gravado com sucesso !!!");
        }catch(Exception ex) {
            System.err.println("erro: " + ex.toString());

        }
    }

    public void lerEmArquivo(){
        System.out.println("");
        File arquivo = new File("Campeonato.dat");

        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            jogadores = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();

            int i=0;
            for(Jogador p : jogadores) {
                if(p != null){
                    i++;
                }
            }
            contJ = i;
            System.out.println("Leitura dos dados feita com sucesso !!!");
        }catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }
    }
}
