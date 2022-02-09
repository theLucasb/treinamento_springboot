package br.com.solinftec.treinamentospringboot.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDEM_SERVICO")
@Data
@NoArgsConstructor
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_COOPERATIVA")
    private Integer id_cooperativa;

    @Column(name = "ID_FAZENDA")
    private Integer id_fazenda;

    @Column(name = "ID_EQUIPAMENTO")
    private Integer id_equipamento;

    @Column(name = "ID_PRODUTO")
    private Integer id_produto;

    @Column(name = "DATA_EXECUCAO")
    private Date data_execucao;

    @Column(name = "TIPO_SERVICO")
    private Integer tipo_servico;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "COOPERATIVA", joinColumns = {
            @JoinColumn(name = "ID_COOPERATIVA", referencedColumnName = "ID") })
    private List<Cooperativa> coperativas;

    public OrdemServico(Long id) {
        this.id = id;
    }

}
