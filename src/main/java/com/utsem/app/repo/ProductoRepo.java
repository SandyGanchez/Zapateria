package com.utsem.app.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utsem.app.model.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long>{
    Optional<Producto> findByUuid(UUID uuid);

}
