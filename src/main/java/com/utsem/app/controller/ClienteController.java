package com.utsem.app.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.utsem.app.dto.ClienteDTO;
import com.utsem.app.service.ClienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("rutaClientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("listar")
	public String metodoListar(Model model) {

		model.addAttribute("clientes", clienteService.listar());

		return "/catalogoClientes/moduloClientes";
	}

	@GetMapping("nuevo")
	public String metodoNuevo(Model model) {

		model.addAttribute("cliente", new ClienteDTO());

		return "/catalogoClientes/FormularioCliente";
	}

	@PostMapping("guardar")
	public String metodoGuardar(
			@Valid @ModelAttribute("cliente") ClienteDTO cliente,
			BindingResult result) {

		if(result.hasErrors()) {
			return "/catalogoClientes/FormularioCliente";
		}

		clienteService.guardar(cliente);

		return "redirect:/rutaClientes/listar";
	}

	@GetMapping("editar/{uuid}")
	public String metodoEditar(
			Model model,
			@PathVariable UUID uuid) {

		model.addAttribute("cliente",
				clienteService.obtenerClienteUUID(uuid));

		return "/catalogoClientes/FormularioCliente";
	}
	
	@GetMapping("eliminar/{uuid}")
	public String metodoEliminar(@PathVariable UUID uuid) {

		clienteService.borrar(uuid);

		return "redirect:/rutaClientes/listar";
	}
	
	@PostMapping("actualizar")
	public String metodoActualizar(
	        @Valid @ModelAttribute("cliente") ClienteDTO cliente,
	        BindingResult result) {

	    if(result.hasErrors()) {
	        return "/catalogoClientes/FormularioCliente";
	    }

	    clienteService.actualiza(cliente);

	    return "redirect:/rutaClientes/listar";
	}
}