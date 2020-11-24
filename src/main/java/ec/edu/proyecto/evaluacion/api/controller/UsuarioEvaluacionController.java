package ec.edu.proyecto.evaluacion.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.proyecto.evaluacion.api.exception.ResourceNotFoundException;
import ec.edu.proyecto.evaluacion.api.model.UsuarioEvaluacion;
import ec.edu.proyecto.evaluacion.api.repository.UsuarioEvaluacionRepository;

@RestController
@RequestMapping("/api/v1")
public class UsuarioEvaluacionController {

	@Autowired
	private UsuarioEvaluacionRepository usuarioEvaluacionRepository;

	@GetMapping("/usuarioEvaluacionByIdValuacion/{id}")
	public ResponseEntity<UsuarioEvaluacion> getUsuarioEvaluacionByIdEvaluacion(@PathVariable(value = "id") Long idEvaluacion)
			throws ResourceNotFoundException {
		UsuarioEvaluacion usuarioRespuestas = usuarioEvaluacionRepository.findById(idEvaluacion)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + idEvaluacion));
		return ResponseEntity.ok().body(usuarioRespuestas);
	}
	
	@PostMapping("/usuarioEvaluacionByIdValuacion")
	public UsuarioEvaluacion createUsuarioEvaluacion(@Valid @RequestBody UsuarioEvaluacion usuarioEvaluacion) {
		return usuarioEvaluacionRepository.save(usuarioEvaluacion);
	}
	
}
