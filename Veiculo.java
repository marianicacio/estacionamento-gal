package com.example.estacionamento.model;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity

@Table(name = "veiculo")

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_carro;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private LocalDateTime hr_entrada;

    @Column(nullable = false)
    private LocalDateTime hr_saida;

    @Column(nullable = false)
    private int tempo_permanencia;


    @Column(nullable = false)
    private float preco_total;

    @Column(nullable = false)
    private float valor_hr;

    public Veiculo() {

    }

    public Veiculo(String placa, LocalDateTime hr_entrada, LocalDateTime hr_saida, int tempo_permanencia, float preco_total, float valor_hr) {
        this.placa = placa;
        this.hr_entrada = hr_entrada;
        this.hr_saida = hr_saida;
        this.tempo_permanencia = tempo_permanencia;
        this.preco_total = preco_total;
        this.valor_hr = valor_hr;
    }

    public long getId_carro() {
        return id_carro;
    }

    public void setId_carro(long id_carro) {
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

    public void setTempo_permanencia(int tempo_permanencia) {
        this.tempo_permanencia = tempo_permanencia;
    }

    public float getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(float preco_total) {
        this.preco_total = preco_total;
    }

    public float getValor_hr() {
        return valor_hr;
    }

    public void setValor_hr(float valor_hr) {
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
