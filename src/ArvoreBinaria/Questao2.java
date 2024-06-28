package ArvoreBinaria;

public class Questao2 {
    
    public static void main(String[] args) {
        ArvoreBin2 arvore = new ArvoreBin2(10);
        arvore.imprimir(arvore.raiz);
    }
    
}

class Valor {
    int valor;
    Valor proximo;
    Valor anterior;


    public Valor(int valor) {
        this.valor = valor;
    }
}

class ListaEncDupla {
    Valor cabeca;
    ListaEncDupla esquerda;
    ListaEncDupla direita;
    ListaEncDupla pai;

    public ListaEncDupla(int valor) {
        this.cabeca = new Valor(valor);
    }
    
}

class ArvoreBin2 {
    ListaEncDupla raiz; // Cada lista já está ordenada obrigatoriamente
    

    public ArvoreBin2(int chave) {
        this.raiz = new ListaEncDupla(chave);
    }

    public void inserirOrdem(Valor valor, ListaEncDupla lista) {
        Valor cabeca = lista.cabeca;
        if (cabeca == null) {
            lista.cabeca = valor;
        } else if (cabeca.valor >= valor.valor) {
            valor.proximo = cabeca;
            cabeca.anterior = valor;
            lista.cabeca = valor; // Atualiza a cabeça da lista
            System.out.println("Elemento adicionado com sucesso");
        } else {
            while (cabeca != null) {
                cabeca = cabeca.proximo;
    
                if (cabeca != null && cabeca.valor >= valor.valor) {
                    valor.proximo = cabeca;
                    valor.anterior = cabeca.anterior;
                    cabeca.anterior = valor;
                    System.out.println("Elemento adicionado com sucesso");
                    break;
                }
    
                if (cabeca == null || cabeca.proximo == null) {
                    valor.anterior = cabeca;
                    valor.proximo = null;
                    cabeca.proximo = valor;
                    System.out.println("Elemento adicionado com sucesso");
                    break;
                }
            }
        }
    }
    

    public void imprimir(ListaEncDupla lista) {
        while (lista.cabeca != null) {
            System.out.println(lista.cabeca.valor);
            lista.cabeca = lista.cabeca.proximo;
        }
    }
    public int contarElementosEsquerda(ListaEncDupla no) {
        if (no == null || no.esquerda == null) {
            return 0;
        }

        return contarRecursivo(no.esquerda);
    }

    private int contarRecursivo(ListaEncDupla no) {
        if (no == null) {
            return 0;
        }

        int elementosNaEsquerda = contarRecursivo(no.esquerda);
        int elementosNaDireita = contarRecursivo(no.direita);

        return 1 + elementosNaEsquerda + elementosNaDireita;
    }


    
}
