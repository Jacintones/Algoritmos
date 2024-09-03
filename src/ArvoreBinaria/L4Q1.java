package L4;

public class L4Q1 {
	
	public static No busca(int chave, No no) {
		if (no == null || no.chave == chave) {
			return no;
		}
		else if(chave < no.chave) {
			return busca(chave, no.esquerda); 
		}else {
			return busca(chave, no.direita);
		}
	}
	
	public static void inserir(No no, ArvoreBin arvore) {
		No pai = null;
		No atual = arvore.raiz;
		
		while(atual != null) {
			pai = atual;
			if (no.chave <= atual.chave) {
				atual = atual.esquerda;
			}
			else {
				atual = atual.direita;
			}
		}
		no.pai = pai;
		if (pai == null) {
			arvore.raiz = no;
		}else if (no.chave <= pai.chave) {
			pai.esquerda = no;
		}else {
			pai.direita = no;
		}
	}
	
	public static void imprimirEmOrdem(No no) {
		if (no.esquerda != null) {
			imprimirEmOrdem(no.esquerda);
			
		}
		System.out.println(no.chave);
		if(no.direita != null) {
			imprimirEmOrdem(no.direita);
		}
	}
	
	public static void main(String[] args) {
		ArvoreBin arvore = new ArvoreBin();
		No no1 = new No(1);
		No no2 = new No(2);
		No no5 = new No(5);
		No no4 = new No(4);
		
		inserir(no1, arvore);
		inserir(no4, arvore);
		inserir(no5, arvore);
		inserir(no2, arvore);
		
		imprimirEmOrdem(arvore.raiz);
	}
}

class No {
	int chave;
	No esquerda;
	No direita;
	No pai;
	
	public No (int chave) {
		this.chave = chave;
	}
}

class ArvoreBin{
	No raiz;
	
}