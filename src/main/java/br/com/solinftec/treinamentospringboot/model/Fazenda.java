package br.com.solinftec.treinamentospringboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FAZENDA")
@Data
@NoArgsConstructor
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_FAZENDEIRO")
    private Integer id_fazendeiro;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "AREA")
    private Float area;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "FAZENDEIRO", joinColumns = { @JoinColumn(name = "ID_FAZENDEIRO", referencedColumnName = "ID") })
    private List<Fazendeiro> fazendeiro;

    public Fazenda(Long id) {
        this.id = id;
    }

}
