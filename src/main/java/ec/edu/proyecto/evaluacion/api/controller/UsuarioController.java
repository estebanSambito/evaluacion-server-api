package ec.edu.proyecto.evaluacion.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.proyecto.evaluacion.api.exception.ResourceNotFoundException;
import ec.edu.proyecto.evaluacion.api.model.Usuario;
import ec.edu.proyecto.evaluacion.api.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + usuarioId));
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping("/usuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> loginUsuario(@Valid @RequestBody Usuario usuarioEnviado) throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(usuarioEnviado.getNombreUsuario())
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + usuarioEnviado.getNombreUsuario()));
		if (usuarioEnviado.getClave().equals(usuario.getClave())){
			String token = getJWTToken(usuario);
//			String token = "BEARER asfasfad";
			
			Usuario uResponse = new Usuario();
			uResponse.setNombreUsuario(usuarioEnviado.getNombreUsuario());
			uResponse.setNombre(usuario.getNombre());
			uResponse.setToken(token);
			return ResponseEntity.ok(uResponse);
		}else {
			throw new ResourceNotFoundException("Usuario o clave incorrectos: " + usuarioEnviado.getNombreUsuario());
		}
				
	}
	
	private String getJWTToken(Usuario username) {
		
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER"+","+username.getRol());
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username.getNombreUsuario())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioId,
			@Valid @RequestBody Usuario detallesUsuario) throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + usuarioId));

		usuario.setCedula(detallesUsuario.getCedula());
		/**
		 * Agregar todos los campos
		 */
		final Usuario updatedUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}

	@DeleteMapping("/usuario/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario not found for this id :: " + usuarioId));

		usuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
