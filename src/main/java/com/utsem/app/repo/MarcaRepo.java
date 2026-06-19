package com.utsem.app.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utsem.app.model.Marca;

@Repository
public interface MarcaRepo extends JpaRepository<Marca, Long> {

}