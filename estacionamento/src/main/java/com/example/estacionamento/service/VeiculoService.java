package com.example.estacionamento.service;

import com.example.estacionamento.model.Veiculo;
import com.example.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//anotação que marca esta classe como um componente de serviço
@Service


public class VeiculoService {
    @Autowired //injeta uma instancia do VeiculoRepository na classe de serviço. Agora
    //a classe VeiculoService pode usar todos os metodos do repository para interagir
    //com o banco de dados
    private VeiculoRepository repository;

    //registrarEntrada recebe um objeto Veiculo veiculo.setEntrada(LocalDataTime.now -
    //define a data e hora de entrada do veiculo para o momento atual)

    public Veiculo registrarEntrada(Veiculo veiculo) {
        veiculo.setHr_entrada(LocalDateTime.now());
        return repository.save(veiculo);//salva o novo veiculo no banco e retorna o objeto
        //salvo
    }

    //recebe o id do veiculo que está saindo.
    //optional<Veiculo> veiculoOptional = repository.findById(id)-tentando encontrar o
    //veiculo no banco de dados pelo ID usado o Optional para lidar com a possibilidade
    //de o veiculo não exitir, evitando erros.

    public Veiculo registrarSaida(Long id) {
        //tente encontrar o veiculo no banco de dados pelo id.
        Optional<Veiculo> veiculoOptional= repository.findById(id);
        if (veiculoOptional.isPresent()) { //verifica se o veiculo foi encontrado
            Veiculo veiculo = veiculoOptional.get(); //pega o objeto veiculo do optional
            veiculo.setHr_saida(LocalDateTime.now()); //define a data e hora de saida
            veiculo.calcularValor(); //chama o metodo dentro do modelo para calcular o tempo
            // e o valor real
            return repository.save(veiculo); //salva o veiculo no banco de dados atualizando
            // os campos de saida, tempo e valor
        }
        //se o veiculo não for encontrado, ele lança uma exceção
        throw new RuntimeException(("Veiculo não encontrado"));
    }

    public List<Veiculo> ListarVeiculo() {
        return repository.findAll();
    }
}
