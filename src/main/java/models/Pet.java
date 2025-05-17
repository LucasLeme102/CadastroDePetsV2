package models;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class Pet {
    Integer id;
    String nome;
    String sobrenome;
    String raca;
    String rua;
    String cidade;
    int numeroResidencia;
    int idade;
    double peso;
    String tipoPet;
    String sexo;
}
