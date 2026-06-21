package com.utsem.app.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.utsem.app.dto.PedidoDTO;
import com.utsem.app.service.ClienteService;
import com.utsem.app.service.PedidoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("rutaPedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("listar")
    public String metodoListar(Model model) {

        model.addAttribute("pedidos", pedidoService.listar());

        return "/catalogoPedidos/moduloPedidos";
    }

    @GetMapping("nuevo")
    public String metodoNuevo(Model model) {

        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("pedido", new PedidoDTO());

        return "/catalogoPedidos/FormularioPedido";
    }

    @PostMapping("guardar")
    public String metodoGuardar(
            @Valid @ModelAttribute("pedido") PedidoDTO pedido,
            BindingResult result,
            Model model) {

        System.out.println("ENTRO AL GUARDAR");

        if(result.hasErrors()) {

            System.out.println("TIENE ERRORES");

            result.getAllErrors().forEach(System.out::println);

            model.addAttribute("clientes", clienteService.listar());

            return "/catalogoPedidos/FormularioPedido";
        }

        pedidoService.guardar(pedido);

        return "redirect:/rutaPedidos/listar";
    }

    @GetMapping("editar/{uuid}")
    public String metodoEditar(
            Model model,
            @PathVariable UUID uuid) {

        model.addAttribute("clientes", clienteService.listar());

        model.addAttribute("pedido",
                pedidoService.obtenerPedidoUUID(uuid));

        return "/catalogoPedidos/FormularioPedido";
    }

    @PostMapping("actualizar")
    public String metodoActualizar(
            @Valid @ModelAttribute("pedido") PedidoDTO pedido,
            BindingResult result,
            Model model) {

        if(result.hasErrors()) {

            model.addAttribute("clientes", clienteService.listar());

            return "/catalogoPedidos/FormularioPedido";
        }

        pedidoService.actualiza(pedido);

        return "redirect:/rutaPedidos/listar";
    }

    @GetMapping("eliminar/{uuid}")
    public String metodoEliminar(@PathVariable UUID uuid) {

        pedidoService.borrar(uuid);

        return "redirect:/rutaPedidos/listar";
    }
}