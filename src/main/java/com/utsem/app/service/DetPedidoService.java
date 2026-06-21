package com.utsem.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utsem.app.dto.DetPedidoDTO;
import com.utsem.app.model.DetPedido;
import com.utsem.app.repo.DetPedidoRepo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DetPedidoService {
	@Autowired
	DetPedidoRepo detPedidoRepo;

	@Autowired
	ModelMapper mapper;

	public List<DetPedidoDTO> listar() {

		return detPedidoRepo.findAll()
				.stream()
				.map(detPedido -> mapper.map(detPedido, DetPedidoDTO.class))
				.toList();
	}

	public void guardar(DetPedidoDTO detPedidoDTO) {

		detPedidoRepo.save(mapper.map(detPedidoDTO, DetPedido.class));
	}

	public void actualiza(DetPedidoDTO detPedidoDTO) {

		Optional<DetPedido> optDetPedido =
				detPedidoRepo.findByUuid(detPedidoDTO.getUuid());

		if (optDetPedido.isPresent()) {

			mapper.map(detPedidoDTO, optDetPedido.get());
			detPedidoRepo.save(optDetPedido.get());

		} else {

			throw new EntityNotFoundException(
					"Detalle de pedido no encontrado con UUID "
							+ detPedidoDTO.getUuid());
		}
	}

	public DetPedidoDTO obtenerDetPedidoUUID(UUID uuid) {

		Optional<DetPedido> optDetPedido =
				detPedidoRepo.findByUuid(uuid);

		if (optDetPedido.isPresent()) {

			return mapper.map(optDetPedido.get(), DetPedidoDTO.class);
		}

		throw new EntityNotFoundException(
				"Detalle de pedido no encontrado con UUID " + uuid);
	}
	
	public void borrar(UUID uuid) {

	    Optional<DetPedido> optDetPedido =
	            detPedidoRepo.findByUuid(uuid);

	    if(optDetPedido.isPresent()) {

	        detPedidoRepo.delete(optDetPedido.get());

	    } else {

	        throw new EntityNotFoundException(
	                "Detalle de pedido no encontrado con UUID " + uuid);
	    }
	}
}
