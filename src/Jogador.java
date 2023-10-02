import java.util.Scanner;

public class Jogador {
    private String nome;
    private General gen = new General();
    private Scanner sc = new Scanner(System.in);

    public Jogador(){nome = "a";}
    public Jogador(String n){nome = n;}

    public void adicionarNome(String n){nome = n;}

    public String getNome(){return nome;}

    public void jogarDados(){gen.rolarDados();}

    public void escolherJogada(){
        gen.rolarDados();
        gen.imprimirDados();
        System.out.println("Para qual jogada deseja marcar? [1, 13] " + nome);
        int jog = sc.nextInt();
        gen.pontuarJogada(jog);
    }

    public void mostrarJogadas(){gen.imprimirJogadas();}
    public int mostrarJog(int i){return gen.jogadaE(i);}
    public int mostrarTotal(){return gen.getPTotal();}
}
