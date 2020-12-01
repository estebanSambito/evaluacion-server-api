package ec.edu.proyecto.evaluacion.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.proyecto.evaluacion.api.exception.ResourceNotFoundException;
import ec.edu.proyecto.evaluacion.api.model.Evaluaciones;
import ec.edu.proyecto.evaluacion.api.repository.EvaluacionRepository;

@RestController
@RequestMapping("/api/v1")
public class EvaluacionController {

private EvaluacionRepository evaluacionRepository;
	
	@GetMapping("/evaluaciones")
	public List<Evaluaciones> getAllEvaluacion() {
		return evaluacionRepository.findAll();
	}

	@GetMapping("/evaluaciones/{id}")
	public ResponseEntity<Evaluaciones> getEvaluacionById(@PathVariable(value = "id") Long idCategoria)
			throws ResourceNotFoundException {
		Evaluaciones categoria = evaluacionRepository.findById(idCategoria)
				.orElseThrow(() -> new ResourceNotFoundException("categoria not found for this id :: " + idCategoria));
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping("/evaluacionesByIdUser/{id}")
	public List<Evaluaciones> getEvaluacionByIdUser(@PathVariable(value = "id") Long idUsuario)
			throws ResourceNotFoundException {
		return evaluacionRepository.findAll();
	}

	
}
