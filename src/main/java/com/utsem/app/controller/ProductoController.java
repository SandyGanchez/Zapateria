package com.utsem.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utsem.app.dto.ProductoDTO;
import com.utsem.app.enums.Estatus;
import com.utsem.app.service.ProductoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("extraerProductos")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@GetMapping("listar")
	public String metodoListar (Model model) {
	model.addAttribute("productos", productoService.listar());
	return "/catalogoProductos/moduloProductos.html";

	}
	@GetMapping("nuevo")
	public String metodoNuevo(Model model) {
		model.addAttribute("estados", Estatus.values());
		model.addAttribute("producto", new ProductoDTO());
		return"/catalogoProductos/FormularioProducto";
	}
	
	
	@PostMapping("guardar")
	public String metodoGuarda(@Valid @ModelAttribute("producto") ProductoDTO producto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("estados", Estatus.values());
			return "/catalogoProductos/FormularioProducto";
			
		} productoService.guardar(producto);
		return "redirect:/extraerProductos/listar";
	}
	
	@PostMapping("actualizar")
	public String metodoActualiza(@Valid @ModelAttribute ("producto") ProductoDTO producto, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
		    
			model.addAttribute("uuid",producto.getUuid());
			model.addAttribute("estados", Estatus.values());
			return "/catalogoProductos/FormularioProducto";
			
		} productoService.actualiza(producto);
		return "redirect:/extraerProductos/listar";
	}

}
