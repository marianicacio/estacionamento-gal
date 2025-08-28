package com.example.estacionamento.repository;

import com.example.estacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

//ao estender o JpaRepository, o SpringData fornecee uma serie de metodos CRUD para a
//entidade veiculo.
//veiculo - e o tipo de entidade que este repository gerencia.
//Long - e o tipo da chave primaria da entidade

public interface VeiculoRepository extends JpaRepository<Veiculo,Long>{

}
