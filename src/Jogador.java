import java.io.Serializable;

public class Jogador implements Serializable{
    private String nome;
    private General gen = new General();

    public Jogador(){nome = "a";}
    public Jogador(String n){nome = n;}

    public void adicionarNome(String n){nome = n;}

    public String getNome(){return nome;}

    public void jogarDados(){gen.rolarDados();}

    public void escolherJogada(int n){
        gen.rolarDados();
        gen.pontuarJogada(n);
    }

    public void mostrarJogadas(){gen.imprimirJogadas();}
    public int mostrarJog(int i){return gen.jogadaE(i);}
    public int mostrarTotal(){return gen.getPTotal();}
    public void mostrarSeq(){gen.imprimirDados();}
}
