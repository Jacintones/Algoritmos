package TabelaHash;

public class TabelaHash {
  
    public static int hasFunction(TabelaHashOpen lista, ListaDuplaEnc x){
      return x.cabeca.chave % lista.tamanho;
    }
    
    public static boolean isTabelaCheia(TabelaHashOpen lista) {
      for (int t = 0; t < lista.tamanho; t++) {
          if (lista.tabela[t] == null) {
              return false;  // Encontrou pelo menos uma posição vazia, a tabela não está cheia
          }
      }
      return true;  // Todas as posições estão ocupadas, a tabela está cheia
    }  
    public static void inserirTabelaHash(TabelaHashOpen lista, ListaDuplaEnc x) {
      int k = hasFunction(lista, x);

      if (!isTabelaCheia(lista)) {
          inserirHash(lista, k, x);
      } else {
          // Inserir de forma encadeada
          inserirListaDupla(lista.tabela[k], x.cabeca);
      }
  }

  private static void inserirHash(TabelaHashOpen lista, int k, ListaDuplaEnc x) {
      if (lista.tabela[k] == null) {
          lista.tabela[k] = x; // Se a posição na tabela hash estiver vazia, ele já preenche
      } else {
          int i = (k % lista.tamanho) + 1; // Rehash, verificar as colisões
          
          while (lista.tabela[i - 1] != null) { // Pecorro para ver se o índice do rehash é diferente de null, botei i-1 pra garantir que nao ultrapasse o limite
              i = (i % lista.tamanho) + 1; // Se for diferente de null, está ocupado, assim vou somando as colisões
          }
          lista.tabela[i] = x; // Depois de percorrer o while, adiciona no tamanho null que encontrar
      }
  }
    public static void inserirListaDupla(ListaDuplaEnc listaDestino, No no) {
      No cabeca = listaDestino.cabeca; //pego a cabeca

      if (cabeca.chave > no.chave) {  //verifico se a cabeca atual é maior, se for, troco de lugar e o no novo torna-se a cabeca
          no.proximo = cabeca;
          cabeca.anterior = no;
          listaDestino.cabeca = no;
      }else{

        while (cabeca != null && cabeca.proximo != null) {
            cabeca = cabeca.proximo;
            if (cabeca.chave > no.chave) {
                no.anterior = cabeca.anterior;
                no.anterior.proximo = cabeca;
                cabeca.anterior = no;
                break;
            }
        }
        no.anterior = cabeca;
        no.proximo = null;
        cabeca.proximo = no;
      }
    }
    

    public static void imprimirLista(TabelaHashOpen tabela) {
      for (int i = 0; i < tabela.tamanho; i++) {
          ListaDuplaEnc currentLista = tabela.tabela[i];
  
          System.out.print("Posição " + i + ": ");
          imprimirListaDupla(currentLista);
      }
  }
  public static void imprimirListaDupla(ListaDuplaEnc listaDuplaEnc) {
    if (listaDuplaEnc != null) {
        No cabeca = listaDuplaEnc.cabeca;

        System.out.print("[");
        
        while (cabeca != null) {
            System.out.print(cabeca.chave);
            if (cabeca.proximo != null) {
                System.out.print(", ");
            }
            cabeca = cabeca.proximo;
        }

        System.out.println("]");
    } else {
        System.out.println("[]");
    }
  }

    public static void main(String[] args) {
      TabelaHashOpen lista = new TabelaHashOpen(10);
      
      ListaDuplaEnc l1 = new ListaDuplaEnc(10);
      ListaDuplaEnc l2 = new ListaDuplaEnc(52);
      ListaDuplaEnc l3 = new ListaDuplaEnc(53);
      ListaDuplaEnc l4 = new ListaDuplaEnc(11);
      ListaDuplaEnc l5 = new ListaDuplaEnc(99);
      ListaDuplaEnc l6 = new ListaDuplaEnc(20);
      ListaDuplaEnc l7 = new ListaDuplaEnc(31);
      ListaDuplaEnc l10 = new ListaDuplaEnc(44);
      ListaDuplaEnc l11 = new ListaDuplaEnc(50);

      inserirTabelaHash(lista, l3);
      inserirTabelaHash(lista, l2);
      inserirTabelaHash(lista, l1);
      inserirTabelaHash(lista, l4);
      inserirTabelaHash(lista, l5);
      inserirTabelaHash(lista, l6);
      inserirTabelaHash(lista, l7);
      inserirTabelaHash(lista, l10);
      inserirTabelaHash(lista, l11);


      imprimirLista(lista);
    }
  } 
class No{
  
  int chave;
  protected No proximo;
  protected No anterior;

  public No(int chave) {
    this.chave = chave;
  }
}

class ListaDuplaEnc {
  protected No cabeca;

  ListaDuplaEnc(int chave) {
      this.cabeca = new No(chave);
  }

}
class TabelaHashOpen{
    int tamanho;
    ListaDuplaEnc[] tabela;
    
    public TabelaHashOpen(int tamanho) {
      this.tamanho = tamanho;
      tabela = new ListaDuplaEnc[tamanho];
    }
}
