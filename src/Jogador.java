import java.io.Serializable;

public class Jogador implements Serializable{
    private String nome;
    // tipo humano(h) ou máquina(m)
    private String tipo;
    private General gen = new General();

    public Jogador(){nome = "a";tipo = "h";}
    // construtor em sobrecarga
    public Jogador(String n, String t){nome = n; tipo = t;}

    // atualiza o nome do jogador
    public void adicionarNome(String n){nome = n;}

    // retorna o nome
    public String getNome(){return nome;}
    // retorna o tipo
    public String getTipo(){return tipo;}

    //rola os dados
    public void jogarDados(){gen.rolarDados();}

    // pontua a jogada
    public void escolherJogada(int n){
        gen.pontuarJogada(n);
    }

    //mostra as jogadas já feitas
    public void mostrarJogadas(){gen.imprimirJogadas();}
    // mostra um jogada i já feita
    public int mostrarJog(int i){return gen.jogadaE(i);}
    // msotra a pontuação total do jogador
    public int mostrarTotal(){return gen.getPTotal();}
    // mostra a sequência de dados rolados
    public void mostrarSeq(){gen.imprimirDados();}

    //escolhe a melhor jogada para a máquina
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
        // encontra a maior pontuação entre as jogadas 1 e 6
        int m = gen.maiorValor();
        if ((m != 0) && (gen.jogadaE(m - 1) == -1)){
            return m;
        }
        else{
            //escolhe qual jogada descartar
            for (int i = 12; i >= 0; i--){
                if (gen.jogadaE(i) == -1)
                    return i + 1;
            }
            return 0;
        }
    }

    // zera as jogadas do jogador
    public void zerarJogadasJ(){gen.zerarJogadas();}
    // zera a pontuação do jogador
    public void zerarTotalJ(){gen.zerarTotal();}
}
