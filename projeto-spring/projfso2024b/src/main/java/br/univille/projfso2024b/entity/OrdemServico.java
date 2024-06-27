package br.univille.projfso2024b.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //chave artificial

    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo não pode ser branco")

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataEntrada;

    @Column(length = 1000)
    private String servico;
    
    @Column(length = 1000)
    private String anotacao;
    
    @Column(length = 1000)
    private String formaPagamento;
    
    @Column(length = 1000)
    private String raca;

    @ManyToOne(cascade = CascadeType.ALL) //ALL = Se apaga o cliente, apaga o Pet. Para isso não acontecer fazemos cascade = {CascadeType.MERGE, CascadeType.REFRESH} refresh(quando busca o cliente, busca a cidade, para trazer o dado mais atual)
    private Pet Pet;

    
    /* 
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    */

    
}
