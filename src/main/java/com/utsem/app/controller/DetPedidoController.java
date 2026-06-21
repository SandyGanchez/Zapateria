package com.utsem.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.utsem.app.dto.DetPedidoDTO;
import com.utsem.app.service.DetPedidoService;
import com.utsem.app.service.PedidoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("rutaDetPedidos")
public class DetPedidoController {

    @Autowired
    DetPedidoService detPedidoService;

    @Autowired
    PedidoService pedidoService;

    @GetMapping("listar")
    public String metodoListar(Model model) {

        model.addAttribute("detPedidos",
                detPedidoService.listar());

        return "/catalogoDetPedidos/moduloDetPedidos";
    }

    @GetMapping("nuevo")
    public String metodoNuevo(Model model) {

        model.addAttribute("pedidos",
                pedidoService.listar());

        model.addAttribute("detPedido",
                new DetPedidoDTO());

        return "/catalogoDetPedidos/FormularioDetPedido";
    }

    @PostMapping("guardar")
    public String metodoGuardar(
            @Valid @ModelAttribute("detPedido")
            DetPedidoDTO detPedido,
            BindingResult result,
            Model model) {

        if(result.hasErrors()) {

            model.addAttribute("pedidos",
                    pedidoService.listar());

            return "/catalogoDetPedidos/FormularioDetPedido";
        }

        detPedidoService.guardar(detPedido);

        return "redirect:/rutaDetPedidos/listar";
    }

    @GetMapping("editar/{uuid}")
    public String metodoEditar(
            Model model,
            @PathVariable UUID uuid) {

        model.addAttribute("pedidos",
                pedidoService.listar());

        model.addAttribute("detPedido",
                detPedidoService.obtenerDetPedidoUUID(uuid));

        return "/catalogoDetPedidos/FormularioDetPedido";
    }

    @PostMapping("actualizar")
    public String metodoActualizar(
            @Valid @ModelAttribute("detPedido")
            DetPedidoDTO detPedido,
            BindingResult result,
            Model model) {

        if(result.hasErrors()) {

            model.addAttribute("pedidos",
                    pedidoService.listar());

            return "/catalogoDetPedidos/FormularioDetPedido";
        }

        detPedidoService.actualiza(detPedido);

        return "redirect:/rutaDetPedidos/listar";
    }

    @GetMapping("eliminar/{uuid}")
    public String metodoEliminar(@PathVariable UUID uuid) {

        detPedidoService.borrar(uuid);

        return "redirect:/rutaDetPedidos/listar";
    }
}