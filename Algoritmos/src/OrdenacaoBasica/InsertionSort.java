package OrdenacaoBasica;

public class InsertionSort {
	
	public static void insertionSort(int[] array, int tamanho) {
	    int trocas = 0; // Inicializa o contador de trocas
	    
	    for (int j = 1; j < tamanho; j++) {
	        
	    	int chave = array[j];
	        int i = j - 1;
	        
	        while (i >= 0 && array[i] > chave) {
	            array[i + 1] = array[i];
	            i--;
	            trocas++; // Incrementa o contador de trocas
	            
	        }
	        array[i + 1] = chave;
	        
	        System.out.println("Para j= " + j);
	        
	        imprimirLista(array);
	        
	    }
	    System.out.println("Número total de trocas: " + trocas);
	}

	public static void imprimirLista(int[] lista) {
	    for (int i = 0; i < lista.length; i++) {
	        System.out.print(lista[i] + " "); // Imprime o elemento seguido de um espaço
	    }
	    System.out.println(); // Imprime uma nova linha no final da lista
	}

	public static void main(String[] args) {
	    int[] lista = {12, 35, 7, 2, 45, 13, 3, 19};
	    insertionSort(lista, lista.length);

	}
}
