package AtividadePratica;

import java.time.LocalDate;

public class Jogo {

    private String equipeA;
    private String equipeB;
    private String nomeEstadio;
    private LocalDate data;
    
    public Jogo(String equipeA, String equipeB, String nomeEstadio, LocalDate data) {
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.nomeEstadio = nomeEstadio;
        this.data = data;
    }

    public String getEquipeA() {
        return equipeA;
    }

    public String getEquipeB() {
        return equipeB;
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public LocalDate getData() {
        return data;
    }

    

}
