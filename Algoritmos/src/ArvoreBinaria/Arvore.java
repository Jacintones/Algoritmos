package ArvoreBinaria;

public class Arvore {

  public static void main(String[] args) {
    ArvoreBinaria arvore = new ArvoreBinaria(10); // raiz é 10
    
    No no1 = new No(20);
    No no2 = new No(5);
    No no3 = new No(50);
    No no4 = new No(30);
    No no5 = new No(40);

    arvore.inserir(no1, arvore);
    arvore.inserir(no2, arvore);
    arvore.inserir(no3, arvore);
    arvore.inserir(no4, arvore);
    arvore.inserir(no5, arvore);

    arvore.buscaPosOrdemIterativa(no4, arvore);
    


  }
}

class No {
  int chave;
  No pai;
  No esquerda;
  No direita;

  public No(int chave) {
      this.chave = chave;
  }
}

class ArvoreBinaria {
  No raiz;

  public ArvoreBinaria(int valor) {
      this.raiz = new No(valor);
  }

  public No buscarArvoreBinRecursiva(int valor, No no) {
      if (no != null && no.chave == valor) {
          return no;
      } else if (valor < no.chave) {
          return buscarArvoreBinRecursiva(valor, no.esquerda);
      } else {
          return buscarArvoreBinRecursiva(valor, no.direita);
      }
  }

  public void inserir(No no, ArvoreBinaria arvore) {
    
      No pai = null;
      No pt = arvore.raiz;

      while (pt != null) {
          pai = pt;

          if (no.chave <= pt.chave) {
              pt = pt.esquerda;
          } else {
              pt = pt.direita;
          }
      }

      no.pai = pai;

      if (pai == null) {
          arvore.raiz = no;
      } else if (no.chave <= pai.chave) {
          pai.esquerda = no;
      } else {
          pai.direita = no;
      }
  }

  public No remover(No no, ArvoreBinaria arvore){
    No pt = buscarArvoreBinRecursiva(30, no);
    if (pt == null) {
        System.out.println("Nó não existe na árvore");
    }else{
        if (pt.esquerda == null && pt.direita == null) { //nao tem filho
            removerSemFilhos(pt, arvore);
            
        }else if (pt.esquerda != null && pt.direita != null) {
            //removerDoisFilhos(pt, arvore);
        }else{
            //removerUnicoFilho(pt, arvore);
        }
    }
    return pt;
  }

  public void removerSemFilhos(No no, ArvoreBinaria arvore){
    No pai = no.pai;
    if (pai != null) {
        if (pai.chave >= no.chave) {
            pai.esquerda = null;
        }else{
            pai.direita = null;
        }
    }else{
        arvore.raiz = null;
    }
    no.pai = null;
  }

  

  public No encontrarMinimo(No no){
    while (no.esquerda != null) {
        no = no.esquerda;
    }
    return no;
  }
  public No encontrarMaximo(No no){
    while (no.direita != null) {
        no = no.direita;
    }
    return no;
  }

  public No encontrarSucesso(No no){
    if (no.direita != null) {
        return encontrarMinimo(no);

    }else{
        No pai = no.pai;
        while (pai != null && no.chave == pai.direita.chave) {
            no = pai;
            pai = pai.pai;

        }
        return pai;
    }

  }

  public void percursoPreOrdem(No no) {
      if (no != null) {
          System.out.println(no.chave);
          percursoPreOrdem(no.esquerda);
          percursoPreOrdem(no.direita);
      }
  }

  public void percursoEmOrdem(No no) {
      if (no != null) {
          percursoEmOrdem(no.esquerda);
          System.out.println(no.chave);
          percursoEmOrdem(no.direita);
      }
  }

  public void percursoPosOrdem(No no) {
      if (no != null) {
          percursoPosOrdem(no.esquerda);
          percursoPosOrdem(no.direita);
          System.out.println(no.chave);
      }
  }

  public No buscaPosOrdemIterativa(No noProcurado, ArvoreBinaria arvore) {
    Pilha pilha = new Pilha(100);
    No ultimoVisitado = null;
    No raiz = arvore.raiz;

    while (raiz != null || !pilha.isEmpty()) {
        while (raiz != null) {
            pilha.push(raiz);
            raiz = raiz.esquerda;
        }

        raiz = pilha.peek();

        if (raiz.direita != null && raiz.direita != ultimoVisitado) {
            raiz = raiz.direita;
        } else {
            pilha.pop();
            if (raiz == noProcurado) {
                System.out.println("Nó encontrado");
                return raiz;
            }
            ultimoVisitado = raiz;
            raiz = null;
        }
    }

    return null; // Nó não encontrado
}
}

class Pilha {
    private int maximo;
    private int topo;
    private No[] dados;

    public Pilha(int maximo) {
        this.maximo = maximo;
        this.topo = -1; // Inicializar topo como -1 para indicar pilha vazia
        this.dados = new No[maximo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public void push(No x) {
        if (topo < maximo - 1) {
            topo++;
            dados[topo] = x;
        } else {
            System.out.println("OverFlow!");
        }
    }

    public No pop() {
        No removido = null;
        if (!isEmpty()) {
            removido = dados[topo];
            topo--;
        } else {
            System.out.println("UnderFlow");
        }
        return removido;
    }
    public No peek() {
        if (!isEmpty()) {
            return dados[topo];
        } else {
            System.out.println("Pilha vazia");
            return null;
        }
    }
}

