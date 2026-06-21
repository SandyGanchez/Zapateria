package com.utsem.app.repo;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.utsem.app.model.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long>{
	Optional<Cliente> findByUuid(UUID uuid);
	void deleteByUuid(UUID uuid);
}
