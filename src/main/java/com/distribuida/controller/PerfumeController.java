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

import com.distribuida.dto.CategoriaService;
import com.distribuida.dto.ProductoService;
import com.distribuida.entities.Producto;

@Controller
@RequestMapping("/perfumes") 	
public class PerfumeController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Producto> productos = productoService.findAll();
		
		model.addAttribute("perfumesModel", productos);
		
		return "listar-perfumes";
	}
	

	@GetMapping("/findAllBusqueda")
	public String findAll(@RequestParam("busqueda")@Nullable String busqueda, Model model) {
		 
		if(busqueda == null) busqueda = "";
		
		List<Producto> productos = productoService.findAll(busqueda);
		model.addAttribute("perfumesModel", productos);
		
		
		return "listar-perfumes";
	}

	@GetMapping("/findOne")
	public String findOne(@RequestParam("idProducto") @Nullable Integer idProducto, 
						  @RequestParam("opcion") @Nullable Integer opcion, ModelMap modelMap) {
		
		if(idProducto != null){
			Producto producto = productoService.findOne(idProducto);
			modelMap.addAttribute("perfumesModel", producto);
			modelMap.addAttribute("categorias", categoriaService.findAll());
		}else {
			modelMap.addAttribute("categorias", categoriaService.findAll());
		}
		
		if(opcion == 1) return "agregar-perfumes";
		else return "eliminar-perfumes";
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam("idProducto") @Nullable Integer idProducto
			,@RequestParam("nombre") @Nullable String nombre
			,@RequestParam("marca") @Nullable String marca
			,@RequestParam("descripcion") @Nullable String descripcion 
			,@RequestParam("fabricacion") @Nullable String fabricacion
			,@RequestParam("fechaFabricacion")  @Nullable @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaFabricacion 
			,@RequestParam("fechaExpiracion")  @Nullable @DateTimeFormat(pattern= "yyyy-MM-dd") Date fechaExpiracion 
			,@RequestParam("coloniaFor") @Nullable String coloniaFor
			,@RequestParam("tamanio") @Nullable String tamanio
			,@RequestParam("logo") @Nullable String logo
			,@RequestParam("precio") @Nullable Double precio
			,@RequestParam("stock") @Nullable Integer stock
			,@RequestParam("idCategoria") @Nullable Integer idCategoria) {
		
		if(idProducto == null) productoService.add(0, nombre, marca, descripcion, fabricacion, fechaFabricacion, fechaExpiracion, coloniaFor, tamanio, logo, precio, stock, idCategoria) ;
		else productoService.add(idProducto, nombre, marca, descripcion, fabricacion, fechaFabricacion, fechaExpiracion, coloniaFor, tamanio, logo, precio, stock, idCategoria);
		return "redirect:/perfumes/findAll"; //redirect hace que el controller se mueva entre paths
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idProducto") @Nullable Integer idProducto) {
		productoService.del(idProducto);
		return "redirect:/perfumes/findAll";
	}
	
}
