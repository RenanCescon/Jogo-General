import java.io.Serializable;

public class Jogador implements Serializable{
    private String nome;
    private String tipo;
    private General gen = new General();

    public Jogador(){nome = "a";tipo = "h";}
    public Jogador(String n, String t){nome = n; tipo = t;}

    public void adicionarNome(String n){nome = n;}

    public String getNome(){return nome;}
    public String getTipo(){return tipo;}

    public void jogarDados(){gen.rolarDados();}

    public void escolherJogada(int n){
        //gen.rolarDados();
        gen.pontuarJogada(n);
    }

    public void mostrarJogadas(){gen.imprimirJogadas();}
    public int mostrarJog(int i){return gen.jogadaE(i);}
    public int mostrarTotal(){return gen.getPTotal();}
    public void mostrarSeq(){gen.imprimirDados();}
}
