package AtividadePratica;

import java.time.LocalDate;

public class Teste {

    public static void main(String[] args) throws Exception {
        Jogo partida1 = new Jogo("Santa cruz", "Sport", "Arruda", LocalDate.of(2024, 2, 3));
        Pessoa thiago = new Pessoa(70282330498l, "Thiago", "Brasil");
        Pessoa leao = new Pessoa(21l, "Leao", "Brasil");

        Ingresso ingresso1 = new Ingresso(partida1);
    
        Sistema sistema = Sistema.getInstance();

        sistema.cadastrarPessoa(thiago);
        sistema.comprarIngresso(ingresso1, thiago);

        sistema.cadastrarPessoa(leao);
        sistema.comprarIngresso(ingresso1, leao);

    }

}
