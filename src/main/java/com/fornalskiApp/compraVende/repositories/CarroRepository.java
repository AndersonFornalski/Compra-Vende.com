package com.fornalskiApp.compraVende.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fornalskiApp.compraVende.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	@Query("select m from Carro m where m.marca like %?1%")
	List<Carro> findCarroByName(String marca);
}
