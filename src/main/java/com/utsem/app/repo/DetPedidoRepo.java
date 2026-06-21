package com.utsem.app.repo;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.utsem.app.model.DetPedido;

@Repository
public interface DetPedidoRepo extends JpaRepository<DetPedido, Long>{
	Optional<DetPedido> findByUuid(UUID uuid);
	void deleteByUuid(UUID uuid);
}
