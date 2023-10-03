package br.com.technologies.oak.entities;

import br.com.technologies.oak.entities.enums.Disponibilidade;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private Disponibilidade disponivel;
}
