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
	
	public static No encontrarMinimo(No no) {
		while (no.esquerda != null) {
			no = no.esquerda;
		}
		return no;
	}
	
	public static No encontrarMaximo(No no) {
		while (no.direita != null) {
			no = no.direita;
		}
		return no;
	}
	
	public static No encontrarSucessor(No no) {
		if (no.direita != null) {
			return encontrarMinimo(no.direita);
		}
		else {
			No pai = no.pai;
			while(pai != null && no.chave == pai.direita.chave) {
				no = pai;
				pai = pai.pai;
			}
			return pai;
		}
	}
	
	public static void removerSemFilhos(No no, ArvoreBin arvore) {
		No pai = no.pai;
		if (pai != null) {
			if(pai.chave >= no.chave) {
				pai = pai.esquerda = null;
			}else {
				pai.direita = null;
			}
		}else {
			arvore.raiz = null;
		}
		no.pai = null;
	}
	
	public static void removerUnicoFilho(No no, ArvoreBin arvore) {
		No pai = no.pai;
		No filho = null;
		
		if (no.esquerda != null) {
			filho = no.esquerda;
			no.esquerda = null;
		}else {
			filho = no.direita;
			no.direita = null;
		}
		
		if(pai != null) {
			filho.pai = pai;
			if (filho.chave <= pai.chave) {
				pai.esquerda = filho;
			}else {
				pai.direita = filho;
			}
		}else {
			arvore.raiz = filho;
		}
		no.pai = null;
	}
	
	public static void removerComDoisFilhos(No no, ArvoreBin arvore) {
		No sucessor = encontrarSucessor(no);
		sucessor = removerArvoreBinaria(sucessor.chave, arvore);
		sucessor.pai = no.pai;
		no.pai = null;
		sucessor.esquerda = no.esquerda;
		no.esquerda = null;
		sucessor.direita = no.direita;
		no.direita = null;
		No pai = sucessor.pai;
		
		if (pai != null) {
			if (pai.chave >= sucessor.chave) {
				pai.esquerda = sucessor;
			}else {
				pai.direita = sucessor;
			}
		}else {
			arvore.raiz = sucessor;
		}
		sucessor.esquerda.pai = sucessor;
		if (sucessor.direita != null) {
			sucessor.direita.pai = sucessor;
		}
	}
	
	public static No removerArvoreBinaria(int chave, ArvoreBin arvore) {
		No atual = busca(chave, arvore.raiz);
		if (atual == null) {
			System.out.println("Nó com chave: "+chave+ " não existe na árvore!");
		}else {
			if (atual.esquerda == null && atual.direita == null) {
				removerSemFilhos(atual, arvore);
			}else if(atual.esquerda != null && atual.direita !=null) {
				removerComDoisFilhos(atual, arvore);
			}else {
				removerUnicoFilho(atual, arvore);
			}
		}
		return atual;
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
		
		removerArvoreBinaria(4, arvore);
		
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
