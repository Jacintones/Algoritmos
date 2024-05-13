package Matriz;

public class VerificaTransposta {
    public static void main(String[] args) {
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrizB = {{1, 4}, {2, 5}, {3, 6}};
                
        if (verificaTransposta(matrizA, matrizB)) {
            System.out.println("B é a transposta de A.");
        } else {
            System.out.println("B não é a transposta de A.");
        }
    }

    public static boolean verificaTransposta(int[][] matrizA, int[][] matrizB) {
        // Verifica se as matrizes têm dimensões adequadas para serem transpostas uma da outra
        if (matrizA.length != matrizB[0].length || matrizA[0].length != matrizB.length) {
            return false;
        }

        // Verifica se B é a transposta de A
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[0].length; j++) {
                if (matrizA[i][j] != matrizB[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

