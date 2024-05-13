package OrdenacaoBasica;


public class QuickSort {
    private static int particoes; 
    public static void main(String[] args) {
        Integer[] lista = new Integer[8];
        
        adicionar(lista, 36);
        adicionar(lista, 48);
        adicionar(lista, 10);
        adicionar(lista, 78);
        adicionar(lista, 33);
        adicionar(lista, 7);
        adicionar(lista, 35);
        adicionar(lista, 98);

        quicksort(lista, 0, lista.length - 1);

        imprimirLista(lista);
        System.out.println("Números de partições :"+particoes);

    }
    public static void quicksort(Integer[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            int q = particionar(array, esquerda, direita);
            quicksort(array, esquerda, q - 1);
            quicksort(array, q + 1, direita);
        }
    }

    public static void imprimirLista(Integer[] array){
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
    public static void adicionar(Integer[] array, int valor){
        for(int i =0; i < array.length; i++){
            if (array[i] == null) {
                array[i] = valor;
                return;
            }
        }
        System.out.println("Lista cheia");
    }
   public static int particionar(Integer vetor[], int inicio, int fim) {
        int pivor = vetor[fim]; //elemento mais a direita
        int i = inicio - 1;

        for (int j = inicio; j <= fim - 1; j++) { 
            if (vetor[j] < pivor) {
                i = i + 1;
                // Fazer a troca
                int temp = vetor[j];
                vetor[j] = vetor[i];
                vetor[i] = temp;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = pivor;
        vetor[fim] = temp;
        particoes++;

        return i + 1;
    }
}
