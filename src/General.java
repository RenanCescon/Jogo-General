import java.util.Scanner;

public class General {
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
        System.out.println(
                "   1     2     3     4     5     6   7(T)  8(Q)  9(f) 10(S+) 11(S-) 12(G) 13(X)"
        );
        for (int i = 0; i < 13; i++){
            System.out.print("  " + jogadas[i] + "  ");
        }
    }

    public int validarJogada(int n){
        int soma = 0, cont = 0;
        int[] valores = new int[6];

        for (int i = 0; i < 5; i++){
            valores[dados[i] - 1] += 1;
            soma += dados[i];
        }

        /*
        for (int i = 0; i < 6; i++){
            System.out.print(valores[i] + "   ");
        }
        System.out.println(soma);
        */

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
                for (int i = 0; i < 6; i++){
                    if((valores[i] == 3) || (valores[i] == 2))
                        cont++;
                }
                if (cont == 2)
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
        if (jogadas[n - 1] != -1){
            Scanner sc = new Scanner(System.in);
            int aux;
            System.out.println("Jogada inválida.");
            System.out.println("Escolha a nova jogada: ");
            aux = sc.nextInt();
            pontuarJogada(aux);
        }
        jogadas[n - 1] = validarJogada(n);
        pTotal += jogadas[n - 1];
    }

    public int getPTotal(){return pTotal;}

    public int jogadaE(int n){return jogadas[n];}
}
