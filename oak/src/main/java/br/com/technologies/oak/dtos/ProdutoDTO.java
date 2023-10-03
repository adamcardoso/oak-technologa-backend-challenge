package br.com.technologies.oak.dtos;

import br.com.technologies.oak.entities.enums.Disponibilidade;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private Disponibilidade disponivel;

    @JsonCreator
    public ProdutoDTO(@JsonProperty("id") Long id,
                      @JsonProperty("nome") String nome,
                      @JsonProperty("descricao") String descricao,
                      @JsonProperty("valor") Double valor,
                      @JsonProperty("disponivel") Disponibilidade disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

}
