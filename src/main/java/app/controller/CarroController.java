package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin("*")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping
	public ResponseEntity<Carro> novo(@RequestBody Carro carro) {
		try {
			Carro data = this.carroService.novo(carro);
			return new ResponseEntity<Carro>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Carro> editById(@PathVariable long id, @RequestBody Carro carro) {
		try {
			Carro data = this.carroService.editById(id, carro);
			return new ResponseEntity<Carro>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		try {
			String data = this.carroService.deleteById(id);
			return new ResponseEntity<String>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao tentar excluir registro!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Carro> findById(@PathVariable long id) {
		try {
			Carro data = this.carroService.findById(id);
			return new ResponseEntity<Carro>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
		try {
			List<Carro> data = this.carroService.findAll();
			return new ResponseEntity<List<Carro>>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
