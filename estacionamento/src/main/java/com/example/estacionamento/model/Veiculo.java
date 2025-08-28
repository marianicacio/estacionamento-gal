package com.example.estacionamento.model;
//esta classe é a representação de seu objeto de negócio
import jakarta.persistence.*;
//importa todas as classes e interfaces do pacote jakarta persistence. e
// uma especificação java que define como os objetos java devem ser persistidos no
// banco de dados

import java.time.Duration;
//serve para representar um periodo de tempo
import java.time.LocalDateTime;
//representa uma data e hora sem a informação de fuso horário

@Entity
//diz ao springBoot que esta classe e uma entitade e deve ser mapeada
// para uma tabela no banco de dados

@Table(name = "veiculos")

public class Veiculo {

    @Id
    //marca o campo ID como chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //configura o banco de dados para gerar automaticamente um valor unico e
    //incremental para o ID a cada novo registro

    private Long id_carro;
    private String placa;
    private LocalDateTime hr_entrada;
    private LocalDateTime hr_saida;
    private Integer tempo_permanencia;
    private Double preco_total;
    private Double valor_hr;

    //metodo get e set. Eles permitem ler e modificar os valores dos atributos do
    //objeto de forma controlada

    public Long getId_carro() {return id_carro;}

    public void setId_carro(Long id_carro) {
        this.id_carro = id_carro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHr_entrada() {
        return hr_entrada;
    }

    public void setHr_entrada(LocalDateTime hr_entrada) {
        this.hr_entrada = hr_entrada;
    }

    public LocalDateTime getHr_saida() {
        return hr_saida;
    }

    public void setHr_saida(LocalDateTime hr_saida) {
        this.hr_saida = hr_saida;
    }

    public int getTempo_permanencia(){
        return tempo_permanencia;
    }

    public void setTempo_permanencia(Integer tempo_permanencia) {
        this.tempo_permanencia = tempo_permanencia;
    }

    public Double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(Double preco_total) {
        this.preco_total = preco_total;
    }

    public Double getValor_hr() {
        return valor_hr;
    }

    public void setValor_hr(Double valor_hr) {
        this.valor_hr = valor_hr;
    }

    public void calcularValor(){
        if (hr_entrada != null && hr_saida != null){
            Duration duracao = Duration.between(hr_entrada,hr_saida);
            this.tempo_permanencia = (int)Math.ceil((double) duracao.toMinutes()/60);
            this.preco_total = this.tempo_permanencia * this.valor_hr;
        }
    }

}
