package br.univille.projfso2024b.entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String nome; 

    @Column(length = 1000)
    private String especie;

    @Column(length = 1000)
    private long idade;

    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo raça não pode ser em branco")
    private String raca;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public long getIdade() {
        return idade;
    }
    public void setIdade(long idade) {
        this.idade = idade;
    }
}
