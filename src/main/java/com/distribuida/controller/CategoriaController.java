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

import com.distribuida.dto.CategoriaService;
import com.distribuida.entities.Categoria;

@Controller
@RequestMapping("/categorias") 	
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Categoria> categorias = categoriaService.findAll();
		
		model.addAttribute("categoriasModel", categorias);
		
		return "listar-categorias";
	}

	
	@GetMapping("/findAllBusqueda")
	public String findAll(@RequestParam("busqueda")@Nullable String busqueda, Model model) {
		 
		if(busqueda == null) busqueda = "";
		
		List<Categoria> categoria = categoriaService.findAll(busqueda);
		model.addAttribute("categoriasModel", categoria);
		
		return "listar-categorias";
	}

	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCategoria") @Nullable Integer idCategoria, 
						  @RequestParam("opcion") @Nullable Integer opcion, Model model) {
		
		if(idCategoria == null) idCategoria = 0;
		else {
			Categoria categoria = categoriaService.findOne(idCategoria);
			model.addAttribute("categoriasModel", categoria);
		}
		
		if(opcion == 1) return "agregar-categorias";
		else return "eliminar-categorias";
	}
	
	
	@PostMapping("/add")
	public String add(@RequestParam("idCategoria") @Nullable Integer idCategoria
					,@RequestParam("categoriaConcentacion") @Nullable String categoriaConcentracion	
					,@RequestParam("aroma") @Nullable String aroma	
					,@RequestParam("descripcion") @Nullable String descripcion
					,@RequestParam("durabilidad") @Nullable String durabilidad) {
		
		if(idCategoria == null) idCategoria = 0;
		categoriaService.add(idCategoria, categoriaConcentracion, aroma, descripcion, durabilidad);
		return "redirect:/categorias/findAll";
	}
	
	
	@GetMapping("/del")
	public String del(@RequestParam("idCategoria") @Nullable Integer idCategoria) {
		categoriaService.del(idCategoria);
		return "redirect:/categorias/findAll";
	}
	
}
