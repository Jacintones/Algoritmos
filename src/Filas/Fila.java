package Filas;

public class Fila {
    
    public static void inserir(No no, FilaSeq filaSeq){
      if ((filaSeq.inicio == 1 && filaSeq.fim == filaSeq.max) || filaSeq.inicio == filaSeq.fim + 1) {
          System.out.println("OverFlow");

      }else{
        filaSeq.dados[filaSeq.fim] = no;
        
        if (filaSeq.fim == filaSeq.max) {
            filaSeq.fim = 1;

        }else{
          filaSeq.fim += 1;
        }
      }
    }
    

    public static void main(String[] args) {
     
      FilaSeq filaSeq = new FilaSeq(3);
      
      No no1 = new No(10);
      No no2 = new No(15);
      No no3 = new No(3);

      inserir(no1, filaSeq);
      inserir(no2, filaSeq);
      inserir(no3, filaSeq);

      filaSeq.remover(filaSeq);
      filaSeq.imprimir();

    }
}


class No {
  int chave;

  public No(int chave) {
    this.chave = chave;
  }
}

class FilaSeq{
  int max;
  int fim;
  int inicio;
  No[] dados;

  public FilaSeq(int max) {
    this.max = max;
    dados = new No[max];
  } 
  public void imprimir() {
    System.out.print("Conteúdo da fila: ");
    int i = inicio;
    while (i != fim) {
        System.out.print(dados[i].chave + " ");
        i = (i + 1) % max;
    }
    System.out.println();
}
public void remover(FilaSeq fila) {
  // Tenho que remover o primeiro e arrastar os elementos pro lado dele
  if (fila.inicio == fila.fim) {
      System.out.println("UnderFlow - A fila está vazia");
  } else {
      fila.dados[fila.inicio] = null; // Definindo o primeiro elemento como null
      fila.inicio = (fila.inicio + 1) % fila.max; // Atualizando o índice de início corretamente
  }
}

}