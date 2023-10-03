import java.io.Serializable;

public class General implements Serializable{
    private int[] dados = new int[5];
    private int[] jogadas = new int[13];
    private int pTotal = 0;

    private Dado d = new Dado();

    public General(){
        for (int i = 0; i < 13; i++){jogadas[i] = -1;}
    }

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
        System.out.printf("%s", "1\t2\t3\t4\t5\t6\t7(T)\t8(Q)\t9(f)\t10(S+)\t11(S-)\t12(G)\t13(X)");
        System.out.println();
        for (int i = 0; i < 13; i++){
            if (jogadas[i] == -1){
                System.out.printf("%s", "-\t");
            }
            else
                System.out.printf("%s", jogadas[i] + "\t");
        }
    }

    public int validarJogada(int n){
        int soma = 0, cont = 0;
        int[] valores = new int[6];

        for (int i = 0; i < 5; i++){
            valores[dados[i] - 1] += 1;
            soma += dados[i];
        }

        switch (n) {
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
            case 7:
                for (int i = 0; i < 6; i++)
                    if (valores[i] == 3)
                        return soma;
                break;
            case 8:
                for (int i = 0; i < 6; i++)
                    if (valores[i] == 4)
                        return soma;
                break;
            case 9:
                cont = 0;
                for (int i = 0; i < 6; i++){
                    if((valores[i] == 1) || (valores[i] == 5))
                        return 0;
                }
                if (cont == 0)
                    return 25;
                break;
            case 10:
                for (int i = 1; i < 6; i++){
                    if (valores[i] != 1)
                        return 0;
                }
                return 30;
            case 11:
                for (int i = 0; i < 5; i++){
                    if (valores[i] != 1)
                        return 0;
                }
                return 40;
            case 12:
                for (int i = 0; i < 6; i++){
                    if (valores[i] == 5)
                        return 50;
                }
                break;
            case 13:
                return soma;
        }

        return cont;
    }

    public void pontuarJogada(int n){
        jogadas[n - 1] = validarJogada(n);
        pTotal += jogadas[n - 1];
    }

    public int getPTotal(){return pTotal;}

    public int jogadaE(int n){return jogadas[n];}
}
