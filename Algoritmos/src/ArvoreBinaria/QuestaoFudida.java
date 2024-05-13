package ArvoreBinaria;

public class QuestaoFudida {

    public static void main(String[] args) {
        
        ArvoreBinaria2 arvore = new ArvoreBinaria2(10);
        No no1 = new No(23);
        No no2 = new No(15);
        No no3 = new No(2);
        No no4 = new No(7);
        No no5 = new No(34);
        No no6 = new No(1);

        arvore.inserir(no1, arvore);
        arvore.inserir(no2, arvore);
        arvore.inserir(no3, arvore);
        arvore.inserir(no4, arvore);
        arvore.inserir(no5, arvore);
        arvore.inserir(no6, arvore);

        arvore.encontrarPredecessor(no6, arvore);
    }
}

class NoFudido {
    int chave;
    No pai;
    No esquerda;
    No direita;

    public NoFudido(int chave) {
        this.chave = chave;
    }
}

class ArvoreBinaria2 {
    No raiz;

    public ArvoreBinaria2(int valor) {
        this.raiz = new No(valor);
    }

    public No buscarArvoreBinRecursiva(No no, int chave) {
        if (no != null && chave == no.chave) {
            return no;
        } else if (chave < no.chave) {
            return buscarArvoreBinRecursiva(no.esquerda, chave);
        } else {
            return buscarArvoreBinRecursiva(no.direita, chave);
        }
    }

    public void inserir(No no, ArvoreBinaria2 arvore) {
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

    public No remover(No no, ArvoreBinaria2 arvore) {
        No pt = buscarArvoreBinRecursiva(no, no.chave);
        if (pt == null) {
            System.out.println("Nó não existe na árvore");
        } else {
            if (pt.esquerda == null && pt.direita == null) {
                removerSemFilhos(pt, arvore);
            } else if (pt.esquerda != null && pt.direita != null) {
            } else {
            }
        }
        return pt;
    }

    public void removerSemFilhos(No no, ArvoreBinaria2 arvore) {
        No pai = no.pai;
        if (pai != null) {
            if (pai.chave >= no.chave) {
                pai.esquerda = null;
            } else {
                pai.direita = null;
            }
        } else {
            arvore.raiz = null;
        }
        no.pai = null;
    }

    public void removerDoisFilhos(No no, ArvoreBinaria arvore) {
        // Implemente a lógica para remoção de nós com dois filhos aqui
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

    public No encontrarPredecessor(No no, ArvoreBinaria2 arvoreBinaria) {
        No noAlvo = arvoreBinaria.buscarArvoreBinRecursiva(no, no.chave);

        if (noAlvo != null) {
            noAlvo = noAlvo.pai; // predecessor
            System.out.println(noAlvo.chave);
            return noAlvo;
        } else {
            System.out.println("Nó não existe na árvore");
            return null;
        }
    }
}
