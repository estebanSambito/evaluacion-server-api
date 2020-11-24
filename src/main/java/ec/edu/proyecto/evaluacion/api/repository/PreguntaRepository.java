/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.proyecto.evaluacion.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.proyecto.evaluacion.api.model.Pregunta;

/**
 *
 * @author bryan
 */
@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
   
    // public List<Pregunta> findByIdEvaluacion(int idEvaluacion) ;
}