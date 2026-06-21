package com.utsem.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utsem.app.dto.PedidoDTO;
import com.utsem.app.model.Pedido;
import com.utsem.app.repo.PedidoRepo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoService {
	@Autowired
	PedidoRepo pedidoRepo;

	@Autowired
	ModelMapper mapper;

	public List<PedidoDTO> listar() {

		return pedidoRepo.findAll()
				.stream()
				.map(pedido -> mapper.map(pedido, PedidoDTO.class))
				.toList();
	}

	public void guardar(PedidoDTO pedidoDTO) {

		pedidoRepo.save(mapper.map(pedidoDTO, Pedido.class));
	}

	public void actualiza(PedidoDTO pedidoDTO) {

		Optional<Pedido> optPedido = pedidoRepo.findByUuid(pedidoDTO.getUuid());

		if (optPedido.isPresent()) {

			mapper.map(pedidoDTO, optPedido.get());
			pedidoRepo.save(optPedido.get());

		} else {

			throw new EntityNotFoundException(
					"Pedido no encontrado con UUID " + pedidoDTO.getUuid());
		}
	}

	public PedidoDTO obtenerPedidoUUID(UUID uuid) {

		Optional<Pedido> optPedido = pedidoRepo.findByUuid(uuid);

		if (optPedido.isPresent()) {

			return mapper.map(optPedido.get(), PedidoDTO.class);
		}

		throw new EntityNotFoundException(
				"Pedido no encontrado con UUID " + uuid);
	}
	
	public void borrar(UUID uuid) {

	    Optional<Pedido> optPedido = pedidoRepo.findByUuid(uuid);

	    if(optPedido.isPresent()) {

	        pedidoRepo.delete(optPedido.get());

	    } else {

	        throw new EntityNotFoundException(
	                "Pedido no encontrado con UUID " + uuid);
	    }
	}
}
