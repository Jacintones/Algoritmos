package OrdenacaoBasica;

public class ListaDecrescente {

    public static Tabela ordemDecrescente(Tabela L1, Tabela L2) {
        Tabela listaFinal = new Tabela(L1.maximo + L2.maximo);
        listaFinal.maximo = L1.maximo + L2.maximo;

        //L1 E L2 SAO ESTAO ORDENADOS
        int k = L1.tabela.length -1;
        int l = L2.tabela.length -1;
        int j = 0;

        while (j < listaFinal.maximo) {
            if (k >= 0 && L1.tabela[k] > L2.tabela[l]) {
                listaFinal.tabela[j] = L1.tabela[k];
                k--;
            } else if (l >= 0) {
                listaFinal.tabela[j] = L2.tabela[l];
                l--;
            }
            j++;
        }

        for(int p = 0; p < listaFinal.tabela.length; p++){
            System.out.println(listaFinal.tabela[p]);
        }

        return listaFinal;
    }
    
    public static void main(String[] args) {

        Tabela listaUm = new Tabela(6);

        listaUm.tabela[0] = 59;
        listaUm.tabela[1] = 65;
        listaUm.tabela[2] = 80;
        listaUm.tabela[3] = 98;
        listaUm.tabela[4] = 100;
        listaUm.tabela[5] = 120;

        Tabela listaDois = new Tabela(5);

        listaDois.tabela[0] = 5;
        listaDois.tabela[1] = 14;
        listaDois.tabela[2] = 213;
        listaDois.tabela[3] = 467;
        listaDois.tabela[4] = 546;
        ordemDecrescente(listaUm, listaDois);
        
    }
}


class No{
    Integer chave;
}

class Tabela{
    Integer maximo;
    Integer ultimo;
    Integer[] tabela;

    public Tabela(int maximo) {
        this.tabela = new Integer[maximo];
        this.maximo = maximo;
        ultimo = tabela.length; //Ultimo indice
    }

    
}
