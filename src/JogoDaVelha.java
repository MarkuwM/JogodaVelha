import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Jogo da Velha");
        System.out.print("Nome do Jogador 1: ");
        String jogador1 = input.nextLine();
        System.out.print("Nome do Jogador 2: ");
        String jogador2 = input.nextLine();
        System.out.println("Nova Partida: " + jogador1 + " vs " + jogador2);

        char[][] tabuleiro = new char[3][3];
        inicializarTabuleiro(tabuleiro);

        char jogadorAtual = 'X';
        boolean jogoEmAndamento = true;

        while (jogoEmAndamento) {
            imprimirTabuleiro(tabuleiro);
            System.out.println("Vez de " + (jogadorAtual == 'X' ? jogador1 : jogador2));

            System.out.print("Digite a linha (0-2) e a coluna (0-2) separados por espaço: ");
            int linha = input.nextInt();
            int coluna = input.nextInt();

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;

                if (verificarVitoria(tabuleiro, jogadorAtual)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Jogador " + (jogadorAtual == 'X' ? jogador1 : jogador2) + " venceu!");
                    jogoEmAndamento = false;
                } else if (tabuleiroCheio(tabuleiro)) {
                    imprimirTabuleiro(tabuleiro);
                    System.out.println("Empate!");
                    jogoEmAndamento = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Jogada inválida, tente novamente.");
            }
        }
        input.close();
    }

    public static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                    (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
                return true;
            }
        }

        if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) ||
                (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) {
            return true;
        }
        return false;
    }

    public static boolean tabuleiroCheio(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
