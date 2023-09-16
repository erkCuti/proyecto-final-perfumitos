package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Cliente;
import com.distribuida.entities.Producto;

@Repository
public class ProductoDAOImpl implements ProductoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select pro from Producto pro",Producto.class).getResultList();
	}

	@Override
	@Transactional
	public List<Producto> findAll(String busqueda){
		Session session = sessionFactory.getCurrentSession();
		Query<Producto> query = session.createQuery("SELECT pro from Producto pro WHERE "
				+ "pro.nombre like: busqueda "
				+ "or pro.marca like: busqueda "
				+ "or pro.descripcion like: busqueda "
				+ "or pro.fabricacion like: busqueda "
				+ "or pro.fechaFabricacion like: busqueda "
				+ "or pro.fechaExpiracion like: busqueda "
				+ "or pro.coloniaFor like: busqueda "
				+ "or pro.tamanio like: busqueda "
				+ "or pro.logo like: busqueda "
				+ "or pro.precio like: busqueda "
				+ "or pro.stock like: busqueda "
				+ "or pro.categoria like: busqueda", Producto.class);
		
		query.setParameter("busqueda", "%"+ busqueda +"%");		
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public Producto findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Producto> consulta = session.createQuery("select pro from Producto pro where pro.idProducto =: keyIdProducto", Producto.class);
		consulta.setParameter("keyIdProducto", id);
		return consulta.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Producto producto) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(producto);
	}

	@Override
	@Transactional
	public void up(Producto producto) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Producto set "
				+ "nombre =: keyNom, "
				+ "marca =: keyMar, "
				+ "descripcion =: keyDes, "
				+ "fabricacion =: keyFab, "
				+ "fechaFabricacion =: keyFchaFab, "
				+ "fechaExpiracion =: keyFchaExp, "
				+ "coloniaFor =: keyColFor, "
				+ "tamanio =: keyTam, "
				+ "logo =: keyLog, "
				+ "precio =: keyPre, "
				+ "stock =: keyStock, "
				+ "categoria =: keyCate "
				+ "where idProducto =: keyIdProducto "
				);
		query.setParameter("keyNom", producto.getNombre());
		query.setParameter("keyMar", producto.getMarca());
		query.setParameter("keyDes", producto.getDescripcion());
		query.setParameter("keyFab", producto.getFabricacion());
		query.setParameter("keyFchaFab", producto.getFechaFabricacion());
		query.setParameter("keyFchaExp", producto.getFechaExpiracion());
		query.setParameter("keyColFor", producto.getColoniaFor());
		query.setParameter("keyTam", producto.getTamanio());
		query.setParameter("keyLog", producto.getLogo());
		query.setParameter("keyPre", producto.getPrecio());
		query.setParameter("keyStock", producto.getStock());
		query.setParameter("keyCate", producto.getCategoria());
		query.setParameter("keyIdProducto", producto.getIdProducto());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void del(int id) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Producto where idProducto =: keyIdProducto");
		query.setParameter("keyIdProducto", id);
		query.executeUpdate();
	}
}