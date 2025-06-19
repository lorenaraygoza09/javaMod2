package org.bedu.nesflis.repository;

import org.bedu.nesflis.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
JpaRepository implementa el CRUD basico de una base de datos
findAll() -> regresa todos los registros de la tabla
findById() -> regresa un registro particular por ID
save(entity) -> Crea/actualiza un nuevo registro
deleteById(id) -> elimina un registro
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
