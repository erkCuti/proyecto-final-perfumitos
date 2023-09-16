package com.distribuida.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dto.ClienteService;
import com.distribuida.dto.FacturaService;
import com.distribuida.entities.Factura;


@Controller
@RequestMapping("/facturas") 	
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Factura> facturas = facturaService.findAll();
		
		model.addAttribute("facturasModel", facturas);
		
		return "listar-facturas";
	}
	

	@GetMapping("/findAllBusqueda")
	public String findAll(@RequestParam("busqueda")@Nullable String busqueda, Model model) {
		 
		if(busqueda == null) busqueda = "";
		
		List<Factura> facturas = facturaService.findAll(busqueda);
		model.addAttribute("facturasModel", facturas);
		
		return "listar-facturas";
	}

	@GetMapping("/findOne")
	public String findOne(@RequestParam("idFactura") @Nullable Integer idFactura, 
						  @RequestParam("opcion") @Nullable Integer opcion, ModelMap modelMap) {
		
		if(idFactura != null){
			Factura factura = facturaService.findOne(idFactura);
			modelMap.addAttribute("facturasModel", factura);
			modelMap.addAttribute("clientes", clienteService.findAll());
		}else {
			modelMap.addAttribute("clientes", clienteService.findAll());
		}
		
		if(opcion == 1) return "agregar-facturas";
		else return "eliminar-facturas";
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam("idFactura") @Nullable Integer idFactura
			,@RequestParam("numFactura") @Nullable String numFactura
			,@RequestParam("fecha")  @Nullable @DateTimeFormat(pattern= "yyyy-MM-dd") Date fecha
			,@RequestParam("totalNeto") @Nullable Double totalNeto
			,@RequestParam("iva") @Nullable Double iva
			,@RequestParam("total") @Nullable Double total
			,@RequestParam("idCliente") @Nullable Integer idCliente) {
		
		if(idFactura == null) facturaService.add(0, numFactura, fecha, totalNeto, iva, total, idCliente);
		else facturaService.add(idFactura, numFactura, fecha, totalNeto, iva, total, idCliente);
		return "redirect:/facturas/findAll";
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idFactura") @Nullable Integer idFactura) {
		facturaService.del(idFactura);
		return "redirect:/facturas/findAll";
	}
	
}
