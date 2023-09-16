package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Factura;

@Repository
public class FacturaDAOImpl implements FacturaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Factura> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select fac from Factura fac",Factura.class).getResultList();
	}

	@Override
	@Transactional
	public List<Factura> findAll(String busqueda) {
		Session session = sessionFactory.getCurrentSession();
		Query<Factura> query = session.createQuery("SELECT fac from Factura fac "
				+ "WHERE fac.numFactura like: busqueda ", Factura.class);
		
		query.setParameter("busqueda", "%"+ busqueda +"%");		
		return query.getResultList();
	}
	
	
	@Override
	@Transactional
	public Factura findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Factura> consulta = session.createQuery("select fac from Factura fac where fac.idFactura =: keyIdFactura", Factura.class);
		consulta.setParameter("keyIdFactura", id);
		return consulta.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Factura factura) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(factura);
	}

	@Override
	@Transactional
	public void up(Factura factura) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Factura set "
				+ "numFactura =: keyNumFac, "
				+ "fecha =: keyFcha, "
				+ "totalNeto =: keyTNeto, "
				+ "iva =: keyIva, "
				+ "total =: keyTotal, "
				+ "cliente =: keyCli "
				+ "where idFactura=: keyIdFactura "
				);
		query.setParameter("keyNumFac", factura.getNumFactura());
		query.setParameter("keyFcha", factura.getFecha());
		query.setParameter("keyTNeto", factura.getTotalNeto());
		query.setParameter("keyIva", factura.getIva());
		query.setParameter("keyTotal", factura.getTotal());
		query.setParameter("keyCli", factura.getCliente());
		query.setParameter("keyIdFactura", factura.getIdFactura());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Factura where idFactura =: keyIdFactura");
		query.setParameter("keyIdFactura", id);
		query.executeUpdate();
	}
	
	@Override
	@Transactional
	public int findMax() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select max(fac.idFactura) from Factura fac");
		return (int) query.getSingleResult();
	}
}