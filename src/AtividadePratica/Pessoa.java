package AtividadePratica;

public class Pessoa {
    //Atributos padrão
    private long cpf; 
    private String nome;
    private String paisOrigem;
    private Ingresso ingresso;
    
    public Pessoa(long cpf, String nome, String paisOrigem) {
        this.cpf = cpf;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.ingresso = null; //Inicia com ingresso nulo

    }
    

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}
