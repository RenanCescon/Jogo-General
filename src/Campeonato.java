import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Campeonato {
    private Jogador[] jogadores;
    private int contJ;
    private Scanner sc =new Scanner(System.in);

    public Campeonato(){
        // vetor com os jogadores do campeonato (até 10 jogadores)
        jogadores = new Jogador[10];
        // quantidade de jogadores no campeonato
        contJ = 0;
    }

    public void incluirJogador(){
        // verifica se não ultrapassa o número máximo de jogadores
        if (contJ < 10){
            String n, t;
            System.out.println("Digite o nome do novo jogador: ");
            n = sc.nextLine();
            System.out.println("Digite o tipo do novo jogador: (h,m)");
            t = sc.nextLine();
            // verifica se o tipo de jogador digitado é válido
            while ((!t.equals("h")) && (!t.equals("m"))){
                System.out.println("Tipo inválido! Escolha entre m (máquina) e h (humano)");
                System.out.println("Digite o tipo do novo jogador: (h,m)");
                t = sc.nextLine();
            }
            // adiciona o novo jogador ao vetor
            jogadores[contJ] = new Jogador(n, t);
            // atualiza o número de jogadores
            contJ++;
        }
        else{
            System.out.println("Não é possível inserir um novo jogador.");
        }
    }

    public void excluirJogador(){
        String n;
        // mostra quais jogadores estão no campeonato
        System.out.println("Lista de jogadores: ");
        for(int i = 0; i < contJ; i++){
            System.out.printf("%s", jogadores[i].getNome() + "\t");
        }
        System.out.println();
        System.out.println("Digite o nome do jogador a ser retirado: ");
        n = sc.nextLine();
        int cont = 0;
        for (int i = 0; i < contJ; i++){
            // procura onde está o jogador digitado
            if ((jogadores[i].getNome()).equals(n)){
                for (int j = i; j < contJ - 1; j++)
                    jogadores[j] = jogadores[j + 1];
                contJ--;
                break;
            }
            cont++;
        }
        // informa se não foi encontrado o jogador digitado
        if ((cont == contJ + 1) && (cont != 0)){
            System.out.println("Não foi possível encontrar o jogador.");
        }
    }

    public void iniciarCampeonato(){
        // zera o resultado do campeonato anterior
        for (int i = 0; i < contJ; i++){
            jogadores[i].zerarJogadasJ();
            jogadores[i].zerarTotalJ();
        }

        for (int i = 0; i < 13; i++){
            for (int j = 0; j < contJ; j++){
                // quando o jogador for humano
                if (jogadores[j].getTipo().equals("h")){
                    jogadores[j].jogarDados();
                    jogadores[j].mostrarJogadas();
                    System.out.println();
                    jogadores[j].mostrarSeq();
                    System.out.println();
                    System.out.println("Para qual jogada deseja marcar? [1, 13] " + jogadores[j].getNome());
                    int jog = sc.nextInt();
                    // verifica se a jogada é válida
                    if (jog > 13){
                        System.out.println("Jogada inválida.");
                        System.out.println("Escolha a jogada no intervalo entre 1 e 13: ");
                        jog = sc.nextInt();
                    }
                    //verifica se a jogada já foi feita
                    while(jogadores[j].mostrarJog(jog - 1) != -1){
                        System.out.println("Jogada inválida.");
                        System.out.println("Escolha a nova jogada: ");
                        jog = sc.nextInt();
                    }
                    jogadores[j].escolherJogada(jog);
                    // mostra a pontuação da jogada
                    System.out.println("A pontuação foi " + jogadores[j].mostrarJog(jog - 1));
                    System.out.println();
                }
                // quando o jogador for máquina
                else{
                    jogadores[j].jogarDados();
                    // escolhe qual é a melhor jogada para a máquina
                    int m = jogadores[j].melhorJogada();
                    jogadores[j].mostrarJogadas();
                    System.out.println();
                    jogadores[j].mostrarSeq();
                    jogadores[j].escolherJogada(m);
                    // mostra a jogada que a máquina escolheu e a pontuação que teve
                    System.out.println("A maquina jogou " + m + " e a pontuação foi " + jogadores[j].mostrarJog(m - 1));
                    System.out.println();
                }
                System.out.println("------------------------------------");
            }
        }
    }

    public void mostrarCartela() {
        int vencedor = 0, maior = 0;
        System.out.println("-- Cartela de Resultados --");
        System.out.printf("%5s", "");
        // imprime o nome dos jogadores na primeira linha
        for (int i = 0; i < contJ; i++) {
            System.out.printf("%10s(%1s)", jogadores[i].getNome(), jogadores[i].getTipo());
        }
        System.out.println();
        for (int i = 0; i < 13; i++) {
            // imprime a jogada da linha
            System.out.printf("%5s", (i + 1));
            // imprime a pontuação de cada jogador para a jogada da linha
            for (int j = 0; j < contJ; j++) {
                System.out.printf("%13s", jogadores[j].mostrarJog(i));
            }
            System.out.println();
        }
        System.out.print("-----");
        for(int i = 0; i < contJ; i++)
            System.out.print("-------------");
        System.out.println();
        // imprime a pontuação total de cada jogador
        System.out.print("Total");
        for (int i = 0; i < contJ; i++) {
            System.out.printf("%13s", jogadores[i].mostrarTotal());
            if (jogadores[i].mostrarTotal() > maior){
                vencedor = i;
                maior = jogadores[i].mostrarTotal();
            }
        }
        System.out.println();
        // imprime quem venceu o campeonato e sua pontuação
        System.out.printf(vencer+"O vencedor foi %s com %s pontos !!!"+normal, jogadores[vencedor].getNome(), jogadores[vencedor].mostrarTotal());
        System.out.println();
    }

    public void gravarEmArquivo(){
        System.out.println("");
        // cria o arquivo para armazenar os dados
        File arquivo = new File("Campeonato.dat");
        try {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            // instancia o objeto jogadores
            oos.writeObject(jogadores);

            oos.flush();
            oos.close();
            fout.close();
            System.out.println("Arquivo gravado");
        }catch(Exception ex) {
            // msotra se obteve erro ao tentar gravar os dados
            System.err.println("erro: " + ex.toString());

        }
    }

    public void lerEmArquivo(){
        System.out.println("");
        // cria o arquivo para armazenar os dados
        File arquivo = new File("Campeonato.dat");

        try {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);

            // le o objeto instanciado para o jogadores
            jogadores = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();

            int i=0;
            // atualiza o vetor jogadores com os dados obtidos do arquivo
            for(Jogador p : jogadores) {
                if(p != null){
                    i++;
                }
            }
            // atualiza a quantidade de jogadores
            contJ = i;
            System.out.println("Leitura dos dados concluída");
        }catch (Exception ex) {
            // msotra se obteve erro ao tentar ler os dados
            System.err.println("erro: " + ex.toString());
        }
    }

    // altera a cor das letras no terminal
    public static final String vencer = "\u001B[32m";
    public static final String normal = "\u001B[0m";
}
