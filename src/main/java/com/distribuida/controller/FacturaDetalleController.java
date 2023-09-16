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

import com.distribuida.dto.FacturaDetalleService;
import com.distribuida.dto.FacturaService;
import com.distribuida.dto.ProductoService;
import com.distribuida.entities.FacturaDetalle;



@Controller
@RequestMapping("/facturasDetalle") 	
public class FacturaDetalleController {

	@Autowired
	private FacturaDetalleService facDetalleService;
	
	@Autowired
	private FacturaService facturaService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<FacturaDetalle> facturasDetalle = facDetalleService.findAll();
		
		model.addAttribute("facDetallesModel", facturasDetalle);
		
		return "listar-detalles";
	}
	
	//Falta metdo de findAll(busqueda);
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idFacturaDetalle") @Nullable Integer idFacturaDetalle, 
						  @RequestParam("opcion") @Nullable Integer opcion, ModelMap modelMap) {
		
		if(idFacturaDetalle != null){
			FacturaDetalle facturaDetalle = facDetalleService.findOne(idFacturaDetalle);
			modelMap.addAttribute("facDetallesModel", facturaDetalle);
			modelMap.addAttribute("facturas", facturaService.findAll());
			modelMap.addAttribute("perfumes", productoService.findAll());
		}else {
			modelMap.addAttribute("facturas", facturaService.findAll());
			modelMap.addAttribute("perfumes", productoService.findAll());
		}
		
		if(opcion == 1) return "agregar-detalles";
		else return "eliminar-detalles";
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam("idFacturaDetalle") @Nullable Integer idFacturaDetalle
			,@RequestParam("cantidad") @Nullable Integer cantidad
			,@RequestParam("subtotal")  @Nullable Double subtotal
			,@RequestParam("idFactura") @Nullable Integer idFactura
			,@RequestParam("idProducto") @Nullable Integer idProducto) {
		
		if(idFacturaDetalle == null) facDetalleService.add(0, cantidad, subtotal, idFactura, idProducto);
		else facDetalleService.add(idFacturaDetalle, cantidad, subtotal, idFactura, idProducto);
		return "redirect:/facturasDetalle/findAll";
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idFacturaDetalle") @Nullable Integer idFacturaDetalle) {
		facDetalleService.del(idFacturaDetalle);
		return "redirect:/facturasDetalle/findAll";
	}
	
	
}
