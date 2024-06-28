package ListaEncadeada;
public class ListaDuplamenteEncadeada {
    
    static class No {
        
        int chave;
        protected No proximo;
        protected No anterior;

        No(int chave) {
            this.chave = chave;
        }
    }

    static class ListaDuplaEnc {
        protected No cabeca;

        ListaDuplaEnc(int chave) {
            this.cabeca = new No(chave);
        }
    }

    public static void inserirOrdenado(No no, ListaDuplaEnc listaDuplaEnc) {
        No cabeca = listaDuplaEnc.cabeca;

        if (cabeca == null) {
            cabeca = no;
        } else if (cabeca.chave > no.chave) {
            no.proximo = cabeca;
            cabeca.anterior = no;
            listaDuplaEnc.cabeca = no;
        } else {
            while(cabeca != null && cabeca.proximo != null){
                cabeca = cabeca.proximo;
                if (cabeca.chave > no.chave) {
                    no.anterior = cabeca.anterior;
                    no.proximo = cabeca.proximo;
                    cabeca.anterior = no;
                    break;
                }
            }
            if (cabeca.proximo == null) {
                no.anterior = cabeca;
                no.proximo = null;
                cabeca.proximo = no;
            }
        }
        imprimirLista(listaDuplaEnc);
    }

    public static void imprimirLista(ListaDuplaEnc listaDuplaEnc) {
        No cabeca = listaDuplaEnc.cabeca;

        while (cabeca != null) {
            System.out.print(cabeca.chave + " ");
            cabeca = cabeca.proximo;
        }

        System.out.println(); 
    }

    public static void main(String[] args) {
        ListaDuplaEnc listaDuplaEnc = new ListaDuplaEnc(10); // VALOR INICIAL
        //Instanciando os Nós
        No no = new No(15);
        No no1 = new No(20);
        No no2 = new No(5);
        No no3 = new No(25);
        No no4 = new No(1);
        No no5 = new No(100);


        inserirOrdenado(no, listaDuplaEnc);
        inserirOrdenado(no1, listaDuplaEnc);
        inserirOrdenado(no2, listaDuplaEnc);
        inserirOrdenado(no3, listaDuplaEnc);
        inserirOrdenado(no4, listaDuplaEnc);
        inserirOrdenado(no5, listaDuplaEnc);


    }
}
