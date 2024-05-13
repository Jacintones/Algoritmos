package ListaEncadeada;
public class ListaDuplaEncCircular {
  
  static class No {
    int chave;
    protected No proximo;
    protected No anterior;

    No(int chave) {
        this.chave = chave;
        this.proximo = null; // Inicializar o próximo como null
        this.anterior = null; // Inicializar o anterior como null
    }
}

static class ListaDuplaEnc {
    protected No cabeca;

    ListaDuplaEnc(int chave) {
        this.cabeca = new No(chave);
        this.cabeca.proximo = this.cabeca; // Tornar a lista circular
        this.cabeca.anterior = this.cabeca; // Tornar a lista circular
    }
}


  public static void inserirOrdenado(No no, ListaDuplaEnc listaDuplaEnc) {
    No cabeca = listaDuplaEnc.cabeca;

      if (cabeca == null) {
        cabeca = no;
        no.proximo = listaDuplaEnc.cabeca;
        no.anterior = listaDuplaEnc.cabeca;
    } else if (listaDuplaEnc.cabeca.chave > no.chave) {
        no.proximo = listaDuplaEnc.cabeca;
        no.anterior = listaDuplaEnc.cabeca.anterior;
        listaDuplaEnc.cabeca.anterior.proximo = no;
        listaDuplaEnc.cabeca.anterior = no;
        listaDuplaEnc.cabeca = no;
    }else {
        while (cabeca.proximo != listaDuplaEnc.cabeca) {
            cabeca = cabeca.proximo;
            
            if(cabeca.chave > no.chave){
              no.anterior = cabeca.anterior;
              no.proximo = cabeca;
              cabeca.anterior = no;
            }
        }
        //Fazer apontar pra cabeça atual da lista 
        no.proximo = listaDuplaEnc.cabeca; 
        no.anterior = cabeca;
        cabeca.proximo = no;
        listaDuplaEnc.cabeca.anterior = no;
  
    }
    
  }


  public static void imprimirLista(ListaDuplaEnc listaDuplaEnc) {
    if (listaDuplaEnc.cabeca == null) {
        System.out.println("Lista vazia.");
        return;
    }

    No atual = listaDuplaEnc.cabeca;
    do {
        System.out.println(atual.chave);
        atual = atual.proximo;
    } while (atual != listaDuplaEnc.cabeca);

    System.out.println();
  }
  public static No buscaNo(No no, ListaDuplaEnc listaDuplaEnc){
    No procurado = null;
    No cabeca = listaDuplaEnc.cabeca;
    if (cabeca != null) {
        while (cabeca != null) {
          cabeca = cabeca.proximo;

          if (cabeca.chave == no.chave) {
              procurado = cabeca;
              System.out.println("Nó existe");
              return procurado;
          }
        }
        
    }else{
      System.out.println("Lista vazia");
    }
    return procurado;
  }


  public static void main(String[] args) {
    
    ListaDuplaEnc listaDuplaEnc = new ListaDuplaEnc(10); // VALOR INICIAL
    No no = new No(15);
    No no1 = new No(20);
    No no2 = new No(5);
    No no3 = new No(25);
    No no4 = new No(1);
    No no5 = new No(30);

    inserirOrdenado(no, listaDuplaEnc);
    inserirOrdenado(no1, listaDuplaEnc);
    inserirOrdenado(no2, listaDuplaEnc);
    inserirOrdenado(no3, listaDuplaEnc);
    inserirOrdenado(no4, listaDuplaEnc);
    inserirOrdenado(no5, listaDuplaEnc);

    imprimirLista(listaDuplaEnc);
    buscaNo(no5, listaDuplaEnc);
  }
}
