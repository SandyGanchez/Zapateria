package com.utsem.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.utsem.app.dto.ColorDTO;
import com.utsem.app.service.ColorService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("extraerColores")
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping("listar")
    public String metodoListar(Model model) {
        model.addAttribute("colores", colorService.listar());
        return "catalogoColores/moduloColores";
    }

    @GetMapping("nuevo")
    public String metodoNuevo(Model model) {
        model.addAttribute("color", new ColorDTO());
        return "catalogoColores/FormularioColor";
    }

    @PostMapping("guardar")
    public String metodoGuardar(@Valid @ModelAttribute("color") ColorDTO color, BindingResult result) {

        if (result.hasErrors()) {
            return "catalogoColores/FormularioColor";
        }

        colorService.guardar(color);
        return "redirect:/extraerColores/listar";
    }

    @GetMapping("editar/{id}")
    public String metodoEditar(@PathVariable Long id, Model model) {
        model.addAttribute("color", colorService.obtenerColorId(id));
        return "catalogoColores/FormularioColor";
    }

    @GetMapping("eliminar/{id}")
    public String metodoEliminar(@PathVariable Long id) {
        colorService.eliminar(id);
        return "redirect:/extraerColores/listar";
    }
}