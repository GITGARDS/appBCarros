package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public Carro novo(Carro carro) {
		return this.carroRepository.save(carro);
	}

	public Carro editById(long id, Carro carro) {
		Carro regEdit = carro;
		regEdit.setId(id);
		return this.carroRepository.save(regEdit);
	}

	public String deleteById(long id) {
		this.carroRepository.deleteById(id);
		return "Registro excluido com sucesso!";
	}

	public Carro findById(long id) {
		return this.carroRepository.findById(id).get();
	}

	public List<Carro> findAll() {
		return this.carroRepository.findAll();
	}

}
