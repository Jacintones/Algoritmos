package OrdenacaoBasica;

public class Pilha {
    static class No {
        int valor;

        public No(int valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return Integer.toString(valor);
        }
    }

    static class PilhaSeq {
        int maximo;
        int topo;
        No[] dados;

        public PilhaSeq(int maximo) {
            this.maximo = maximo;
            this.topo = -1; // Iniciar com -1 indicando que está vazia
            this.dados = new No[maximo];
        }
    } 

    public static void push(PilhaSeq pilhaSeq, No x) {
        if (pilhaSeq.topo < pilhaSeq.maximo - 1) {
            pilhaSeq.topo++;
            pilhaSeq.dados[pilhaSeq.topo] = x;
        } else {
            System.out.println("OverFlow!");
        }
    }

  public static void imprimirLista(No[] dados, int topo) {
      for (int i = topo; i >= 0; i--) {
          System.out.println("| " + dados[i].valor + " |");
          System.out.println("------");
      }
  }


    public static void main(String[] args) {

        PilhaSeq pilha = new PilhaSeq(10); // Iniciar com tamanho 10
        
        No no1 = new No(5);
        No no2 = new No(15);
        No no3 = new No(2);

        push(pilha, no1);
        push(pilha, no2);
        push(pilha, no3);

        imprimirLista(pilha.dados, pilha.topo);

    }
}
