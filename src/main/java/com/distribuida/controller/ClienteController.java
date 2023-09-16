package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dto.ClienteService;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/clientes") 								//"clientes" debe ir igual en index.jsp
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Cliente> clientes = clienteService.findAll();
		
		model.addAttribute("clientesModel", clientes);	//"clientes" es en realidad una key para el model.
		
		return "listar-clientes";
	}
	

	@GetMapping("/findAllBusqueda")
	public String findAll(@RequestParam("busqueda")@Nullable String busqueda, Model model) {
		 
		if(busqueda == null) busqueda = "";
		
		List<Cliente> clientes = clienteService.findAll(busqueda);
		model.addAttribute("clientesModel", clientes);
		
		
		return "listar-clientes";
	}

	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCliente") @Nullable Integer idCliente, 
						  @RequestParam("opcion") @Nullable Integer opcion, Model model) {
		
		if(idCliente == null) idCliente = 0;
		else {
			Cliente cliente = clienteService.findOne(idCliente);
			model.addAttribute("clientesModel", cliente);
		}
		
		if(opcion == 1) return "agregar-clientes";
		else return "eliminar-clientes";
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam("idCliente") @Nullable Integer idCliente
					,@RequestParam("cedula") @Nullable String cedula
					,@RequestParam("nombre") @Nullable String nombre
					,@RequestParam("apellido") @Nullable String apellido
					,@RequestParam("direccion") @Nullable String direccion
					,@RequestParam("telefono") @Nullable String telefono
					,@RequestParam("correo") @Nullable String correo) {
		
		if(idCliente == null) idCliente = 0;
		clienteService.add(idCliente, cedula, nombre, apellido, direccion, telefono, correo);
		return "redirect:/clientes/findAll"; //redirect hace que el controller se mueva entre paths
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idCliente") @Nullable Integer idCliente) {
		clienteService.del(idCliente);
		return "redirect:/clientes/findAll";
	}
	
	
}
