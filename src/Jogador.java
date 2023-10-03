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
        gen.pontuarJogada(n);
    }

    public void mostrarJogadas(){gen.imprimirJogadas();}
    public int mostrarJog(int i){return gen.jogadaE(i);}
    public int mostrarTotal(){return gen.getPTotal();}
    public void mostrarSeq(){gen.imprimirDados();}

    public int melhorJogada(){
        if ((gen.validarJogada(12) == 50) && (gen.jogadaE(11) == -1))
            return 12;
        else if((gen.validarJogada(11) == 40) && (gen.jogadaE(10) == -1))
            return 11;
        else if((gen.validarJogada(10) == 30) && (gen.jogadaE(9) == -1))
            return 10;
        else if((gen.validarJogada(9) == 25) && (gen.jogadaE(8) == -1))
            return 9;
        else if((gen.validarJogada(8) != 0) && (gen.jogadaE(7) == -1))
            return 8;
        else if((gen.validarJogada(7) != 0) && (gen.jogadaE(6) == -1))
            return 7;
        int m = gen.maiorValor();
        if ((m != 0) && (gen.jogadaE(m - 1) == -1)){
            return m;
        }
        else{
            for (int i = 12; i >= 0; i--){
                if (gen.jogadaE(i) == -1)
                    return i + 1;
            }
            return 0;
        }
    }
}
