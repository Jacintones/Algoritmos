package AtividadePratica;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Pessoa> pessoas;

    private static Sistema instance;

    private Sistema() {
        this.pessoas = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa) throws Exception{

        if (pessoa.getCpf() == 0 || pessoa.getNome() == null) {
            throw new Exception("Cpf ou nome inválido");

        }else{
            pessoas.add(pessoa);
            System.out.println(pessoa.getNome() + " Cadastrado(a) com Sucesso");
        }
    }

    public void comprarIngresso(Ingresso ingresso, Pessoa pessoa){
        if (pessoa != null && ingresso != null) {
            pessoa.setIngresso(ingresso);

            System.out.println("Ingresso comprado por: "+ pessoa.getNome());
            System.out.println("Para o jogo entre: "+ ingresso.getJogo().getEquipeA()  + " x " + 
            ingresso.getJogo().getEquipeB());
            System.out.println("No estádio: "+ ingresso.getJogo().getNomeEstadio());
            System.out.println("Na data: "+ ingresso.getJogo().getData());
        }
    }

    public static Sistema getInstance(){
        if (instance == null) {
            return new Sistema();
        }else{
            return instance;
        }
    }
}
