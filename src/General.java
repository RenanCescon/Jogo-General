import java.io.Serializable;

public class General implements Serializable{
    // vetor das faces superiores do dados
    private int[] dados = new int[5];
    // vetor de pontos das 13 jogadas
    private int[] jogadas = new int[13];
    // total de pontos da partida
    private int pTotal = 0;

    private Dado d = new Dado();

    // construtor, iniciando as jogadas como -1
    public General(){
        for (int i = 0; i < 13; i++){jogadas[i] = -1;}
    }

    // preenchendo o vetor dados com as faces do dado ao rolar 5 vezes
    public void rolarDados(){
        for (int i = 0; i < 5; i++){
            d.roll();
            dados[i] = d.getSideUp();
        }
    }

    public void imprimirDados(){
        System.out.println("A sequência de dados foi: ");
        for (int i = 0; i < 5; i++){
            System.out.print(dados[i] + "  ");
        }
        System.out.println();
    }

    public void imprimirJogadas(){
        for (int i = 1; i < 7; i++)
            System.out.printf("%10s", i);
        System.out.printf("%s", "        7(T)      8(Q)      9(f)    10(S+)    11(S-)     12(G)     13(X)");
        System.out.println();
        for (int i = 0; i < 13; i++){
            if (jogadas[i] == -1){
                // imprime - se a jogada ainda não foi escolhida
                System.out.printf("%10s", "-");
            }
            else
                System.out.printf("%10s", jogadas[i]);
        }
    }

    // retorna o valor da jogada escolhida e se não for válida retorna 0
    public int validarJogada(int n){
        int soma = 0, cont = 0;
        // vetor de inteiros contador que representa a quantidade de cada valor obtido na sequência de dados
        int[] valores = new int[6];

        // somando os valores da sequência e atualizando o vetor contador com os valores da rodada
        for (int i = 0; i < 5; i++){
            valores[dados[i] - 1] += 1;
            soma += dados[i];
        }

        switch (n) {
            // jogadas de 1 a 6 retornam seu valor no vetor valores[] vezes o seu próprio valor
            case 1:
                return valores[0];
            case 2:
                return valores[1] * 2;
            case 3:
                return valores[2] * 3;
            case 4:
                return valores[3] * 4;
            case 5:
                return valores[4] * 5;
            case 6:
                return valores[5] * 6;
            // verifica se é tripla conferindo se tem algum valor que repetiu pelo menos 3 vezes
            case 7:
                for (int i = 0; i < 6; i++)
                    if (valores[i] >= 3)
                        return soma;
                break;
            // verifica se é quadra conferindo se tem algum valor que repetiu pelo menos 4 vezes
            case 8:
                for (int i = 0; i < 6; i++)
                    if (valores[i] >= 4)
                        return soma;
                break;
            // verifica se é full-hand pelo método de exclusão
            // se algum valor marcar 1 no vetor então a jogada não é válida, se marcar 4 também terá 1
            case 9:
                cont = 0;
                for (int i = 0; i < 6; i++){
                    if(valores[i] == 1)
                        return 0;
                }
                if (cont == 0)
                    return 25;
                break;
            // verifica se os valores a partir da posição 2 são 1, caso contrário não será válida
            case 10:
                for (int i = 1; i < 6; i++){
                    if (valores[i] != 1)
                        return 0;
                }
                return 30;
            // verifica se os valores antes de 6 são 1, caso contrário não será válida
            case 11:
                for (int i = 0; i < 5; i++){
                    if (valores[i] != 1)
                        return 0;
                }
                return 40;
            // verifica se algum valor repetiu 5 vezes
            case 12:
                for (int i = 0; i < 6; i++){
                    if (valores[i] == 5)
                        return 50;
                }
                break;
            // retorna a soma dos dados
            case 13:
                return soma;
        }

        return cont;
    }

    public void pontuarJogada(int n){
        // define o valor da jogada n no vetor de jogadas
        jogadas[n - 1] = validarJogada(n);
        // atualiza a pontuação do jogador
        pTotal += jogadas[n - 1];
    }

    public int getPTotal(){return pTotal;}

    // retorna o valor de uma jogada de posição n
    public int jogadaE(int n){return jogadas[n];}

    // escolhe a melhor jogada entre 1 e 6 a partir dos seus valores
    public int maiorValor(){
        int[] valores = new int[6];
        int maior = 0, posM = -1;

        for (int i = 0; i < 5; i++){
            valores[dados[i] - 1] += 1;
        }

        for (int i = 0; i < 6; i++){
            if (valores[i] > maior){
                maior = valores[i];
                posM = i;
            }
        }

        return posM + 1;
    }

    // reinicia o vetor de jogadas e a pontuação do jogador para que possa repetir o campeonato
    public void zerarJogadas(){
        for (int i = 0; i < 13; i++)
            jogadas[i] = -1;
    }
    public void zerarTotal(){pTotal = 0;}
}
