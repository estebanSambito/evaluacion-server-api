package ec.edu.proyecto.evaluacion.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.proyecto.evaluacion.api.exception.ResourceNotFoundException;
import ec.edu.proyecto.evaluacion.api.model.Pregunta;
import ec.edu.proyecto.evaluacion.api.repository.PreguntaRepository;

@RestController
@RequestMapping("/api/v1")
public class PreguntaController {
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@GetMapping("/pregunta")
	public List<Pregunta> getAllPregunta() {
		return preguntaRepository.findAll();
	}

	@GetMapping("/pregunta/{id}")
	public ResponseEntity<Pregunta> getPreguntaById(@PathVariable(value = "id") Long idPregunta)
			throws ResourceNotFoundException {
		Pregunta categoria = preguntaRepository.findById(idPregunta)
				.orElseThrow(() -> new ResourceNotFoundException("Pregunta not found for this id :: " + idPregunta));
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping("/preguntaByIdEval/{id}")
	public List<Pregunta> getAllPreguntaByIdEvaluacion(@PathVariable(value = "id") Long idEvaluacion) {
		return preguntaRepository.findAll();
	}

}
