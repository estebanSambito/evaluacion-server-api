package ec.edu.proyecto.evaluacion.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.proyecto.evaluacion.api.exception.ResourceNotFoundException;
import ec.edu.proyecto.evaluacion.api.model.Categoria;
import ec.edu.proyecto.evaluacion.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categoria")
	public List<Categoria> getAllCategoria() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value = "id") Long idCategoria)
			throws ResourceNotFoundException {
		Categoria categoria = categoriaRepository.findById(idCategoria)
				.orElseThrow(() -> new ResourceNotFoundException("categoria not found for this id :: " + idCategoria));
		return ResponseEntity.ok().body(categoria);
	}
	

}
