import java.util.Scanner;

public class Menu {
    private Campeonato camp = new Campeonato();

    // mostra as opções do menu
    public void iniciarMenu() {
        System.out.println("Opções do menu:");
        System.out.println("a - Incluir jogador.");
        System.out.println("b - Remover jogador.");
        System.out.println("c - Iniciar campeonato.");
        System.out.println("d - Mostrar a cartela do campeonato");
        System.out.println("e - Gravar campeonato em arquivo.");
        System.out.println("f - Ler campeonato em arquivo.");
        System.out.println("g - Sair da aplicação.");
    }

    // chama a função específica para cada caso
    public void opcoes(char c) {
        switch(c) {
            case 'a':
                camp.incluirJogador();
                break;
            case 'b':
                camp.excluirJogador();
                break;
            case 'c':
                camp.iniciarCampeonato();
                break;
            case 'd':
                camp.mostrarCartela();
                break;
            case 'e':
                camp.gravarEmArquivo();
                break;
            case 'f':
                camp.lerEmArquivo();
                break;
        }
    }
}
