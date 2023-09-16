package com.distribuida.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dto.ClienteService;
import com.distribuida.dto.FacturacionService;
import com.distribuida.dto.ProductoService;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Producto;

@Controller
@RequestMapping("/facturacion")
public class FacturacionController {

	@Autowired
	private FacturacionService facturacionService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;
	
	
	private static String numFactura;
	private static String fechaActual;
	private static Double totalNeto=0.0;
	private static Double iva=0.0;
	private static Double total=0.0;
	private static Cliente cliente;	
	private static List<FacturaDetalle> list = new ArrayList<FacturaDetalle>();
	private static List<Cliente> clientes;		
	private static List<Producto> perfumes;
	
	
//	@SuppressWarnings("static-access")
//	@GetMapping("/principal")
//	private String principal(ModelMap modelMap) {
//		
//		this.fechaActual = getFechaActual();
//		this.numFactura = getNumFactura();
//		
//		List<Cliente> clientes = clienteService.findAll(); 
//		
//		modelMap.addAttribute("fechaActual", this.fechaActual);
//		modelMap.addAttribute("numFactura", this.numFactura);
//		modelMap.addAttribute("clientesModel", clientes);
//		
//		return "facturacion";
//	}
	
	
	@SuppressWarnings("static-access")
	@GetMapping("/principal")
	private String cabeceraFactura(ModelMap modelMap) {
		
//		try {
			load(modelMap);
			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
				
		return "facturacion";
	}
	
	
	@SuppressWarnings("static-access")
	@GetMapping("/findOneCliente")
	private String findOneCliente(@RequestParam("idCliente") @Nullable Integer idCliente, ModelMap modelMap)  {

//		try {
			if(idCliente != null) this.cliente = clienteService.findOne(idCliente); 			
			load(modelMap);					
			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}				
			
		return "facturacion";		
	}
	
	
	@SuppressWarnings("static-access")
	@GetMapping("/findOneProducto")
	private String findOneProducto(@RequestParam("idProducto") @Nullable Integer idProducto, ModelMap modelMap)  {
		
//		try {
			if(idProducto != null) {
				Producto producto = productoService.findOne(idProducto);
				add(1, producto);				
				
				this.totalNeto = getFormatNumber(this.totalNeto + producto.getPrecio() * 1);
				this.iva = getFormatNumber(this.totalNeto * 0.12);
				this.total = getFormatNumber(this.totalNeto + this.iva);
			}
			
			load(modelMap);
			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
							
		return "facturacion";	
	}
	
// --------------------------------------------------------------------------------------------------------------------------------
	
	@SuppressWarnings("static-access")
	@GetMapping("/addDetalleTemporal")
	public String add(@RequestParam("idFDList") @Nullable Integer idFDList, @RequestParam("cantidad") @Nullable Integer cantidad,
					  @RequestParam("opcionDetalle") @Nullable Integer opcionDetalle, ModelMap modelMap ) {
		
	//	try {
			
			if(opcionDetalle == 1) {										
				 
			 	FacturaDetalle facturaDetalle = this.list.get(idFDList);				
				
			 	if(cantidad != facturaDetalle.getCantidad()) {
			 		this.totalNeto = this.totalNeto - facturaDetalle.getProducto().getPrecio()*facturaDetalle.getCantidad();
			 		this.totalNeto = getFormatNumber(this.totalNeto + facturaDetalle.getProducto().getPrecio()*cantidad);
			 		this.iva = getFormatNumber(this.totalNeto * 0.12);
					this.total = getFormatNumber(this.totalNeto + this.iva);
					up(cantidad, idFDList);
			 	}				 										 										 
			
			} else {		    	 
		 		
				FacturaDetalle facturaDetalle = this.list.get(idFDList);				
				
				this.totalNeto = getFormatNumber(this.totalNeto - facturaDetalle.getProducto().getPrecio()*facturaDetalle.getCantidad());
				this.iva = getFormatNumber(this.totalNeto * 0.12);
				this.total = getFormatNumber(this.totalNeto + this.iva);
				
				del(idFDList); 			 		
		    }	
			
			load(modelMap);										 					
			
//		} catch (Exception e) {
//			// TODO: handle exception
//			
//		}
		
		return "redirect:/facturacion/principal";
	}
	
	
	@SuppressWarnings({ "static-access", "deprecation" })
	@PostMapping("/addDetalle")
	public String add(@RequestParam("numFactura") @Nullable String numFactura
			, @RequestParam("fechaActual") @Nullable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaActual
			, @RequestParam("totalNeto") @Nullable Double totalNeto
			, @RequestParam("iva") @Nullable Double iva
			, @RequestParam("total") @Nullable Double total
			, @RequestParam("idCliente") @Nullable Integer idCliente			
			, @RequestParam("list") @Nullable List<FacturaDetalle> list						
			, ModelMap modelMap 
			) {
		
	//	try {
			load(modelMap);
		
			this.cliente = clienteService.findOne(idCliente);
			
			facturacionService.addFactura(0, this.numFactura, new Date(), this.totalNeto, this.iva, this.total, idCliente);
						
			this.list.forEach(item -> {
				facturacionService.addDetalle(0, item.getCantidad(), item.getSubtotal(), facturacionService.findMax(), item.getProducto().getIdProducto());
			});
			
			this.list.forEach(item -> {
				productoService.up(item.getProducto());
			});
			
			clear(modelMap);
			
//		} catch (Exception e) {
//			// TODO: handle exception
//			
//		}
		
		return "redirect:/facturacion/principal";
	}
	
// --------------------------------------------------------------------------------
	
	@SuppressWarnings("static-access")
	public void load(ModelMap modelMap) {
		this.fechaActual = getFechaActual();
		this.numFactura = getNumFactura();					
		this.clientes = clienteService.findAll();
		this.perfumes = productoService.findAll();
								
		modelMap.addAttribute("fechaActual", this.fechaActual);
		modelMap.addAttribute("numFactura", this.numFactura);								
		modelMap.addAttribute("totalNeto", this.totalNeto);
		modelMap.addAttribute("iva", this.iva);
		modelMap.addAttribute("total", this.total);
		modelMap.addAttribute("cliente", this.cliente);		
	//	modelMap.addAttribute("libro", this.libro);
		modelMap.addAttribute("list", this.list);
		modelMap.addAttribute("clientesModel", this.clientes);
		modelMap.addAttribute("perfumesModel", this.perfumes);
	}
	
	
	@SuppressWarnings("static-access")
	public void clear(ModelMap modelMap) {
		this.fechaActual = getFechaActual();
		this.numFactura = getNumFactura();
		this.totalNeto = 0.0;
		this.iva = 0.0;
		this.total = 0.0;
		this.list.clear();
		this.cliente = null;
		this.clientes = clienteService.findAll();
		this.perfumes = productoService.findAll();
								
		modelMap.addAttribute("fechaActual", this.fechaActual);
		modelMap.addAttribute("numFactura", this.numFactura);								
		modelMap.addAttribute("totalNeto", this.totalNeto);
		modelMap.addAttribute("iva", this.iva);
		modelMap.addAttribute("total", this.total);
		modelMap.addAttribute("cliente", this.cliente);		
	//	modelMap.addAttribute("libro", this.libro);
		modelMap.addAttribute("list", this.list);
		modelMap.addAttribute("clientesModel", this.clientes);
		modelMap.addAttribute("librosModel", this.perfumes);
	}
	
// ----------------------------------------------------------------------
	
	public String getFechaActual() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fechaActual = format.format(new Date());
		return fechaActual;
	}
	
	public String getNumFactura() {
		int max = facturacionService.findMax();
		String numFactura = String.join("-", "FAC","000".concat(String.valueOf(max+1)));
		return numFactura;
	}
	
	private Double getFormatNumber(Double numero) {
//		DecimalFormat df = new DecimalFormat("#.00");
//		return Double.parseDouble(df.format(numero));		
		return (double) Math.round(numero * 100d) / 100d;
	}
// ----------------------------------------------------------------------
	
	@SuppressWarnings("static-access")
	public void add(int cantidad, Producto producto) {
		
		FacturaDetalle facturaDetalle = new FacturaDetalle();
		
		facturaDetalle.setProducto(producto);				
		facturaDetalle.setCantidad(cantidad);
		facturaDetalle.setSubtotal(facturaDetalle.getProducto().getPrecio() * cantidad);
		facturaDetalle.getProducto().setStock(facturaDetalle.getProducto().getStock() - cantidad);
		
		this.list.add(facturaDetalle);		
		int index = this.list.indexOf(facturaDetalle);		
		facturaDetalle.setIdFacturaDetalle(index);		
		this.list.set(index, facturaDetalle);
	}
	
	
	@SuppressWarnings("static-access")
	public void up(int cantidad, int idFDList) {
		
		FacturaDetalle facturaDetalle = findAll().get(idFDList);
		
		facturaDetalle.getProducto().setStock(facturaDetalle.getProducto().getStock() + facturaDetalle.getCantidad());
														
		facturaDetalle.setCantidad(cantidad);
		facturaDetalle.setSubtotal(facturaDetalle.getProducto().getPrecio() * cantidad);
		
		facturaDetalle.getProducto().setStock(facturaDetalle.getProducto().getStock() - cantidad);
						
		this.list.set(idFDList, facturaDetalle);
	}
	
	
	@SuppressWarnings("static-access")
	public void del(int idFDList) {
				
		this.list.remove(idFDList);			
	
		for (FacturaDetalle facturaDetalle : this.list) {
			int index = this.list.indexOf(facturaDetalle);		
			facturaDetalle.setIdFacturaDetalle(index);		
			this.list.set(index, facturaDetalle);
		}
	}
	
	
	@SuppressWarnings("static-access")
	public List<FacturaDetalle> findAll(){
		return this.list;
	}
}
