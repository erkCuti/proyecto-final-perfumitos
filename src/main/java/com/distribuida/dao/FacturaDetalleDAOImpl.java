package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.FacturaDetalle;

@Repository
public class FacturaDetalleDAOImpl implements FacturaDetalleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<FacturaDetalle> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select fade from FacturaDetalle fade",FacturaDetalle.class).getResultList();
	}

	@Override
	@Transactional
	public FacturaDetalle findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<FacturaDetalle> consulta = session.createQuery("select fade from FacturaDetalle fade where fade.idFacturaDetalle =: keyIdFacturaDetalle", FacturaDetalle.class);
		consulta.setParameter("keyIdFacturaDetalle", id);
		return consulta.getSingleResult();
	}

	@Override
	@Transactional
	public void add(FacturaDetalle facturaDetalle) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(facturaDetalle);
	}

	@Override
	@Transactional
	public void up(FacturaDetalle facturaDetalle) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update FacturaDetalle set "
				+ "cantidad =: keyCan, "
				+ "subtotal =: keySubT, "
				+ "factura =: keyFac, "
				+ "producto =: keyProd "
				+ "where idFacturaDetalle =: keyIdFacturaDetalle "
				);
		query.setParameter("keyCan", facturaDetalle.getCantidad());
		query.setParameter("keySubT", facturaDetalle.getSubtotal());
		query.setParameter("keyFac", facturaDetalle.getFactura());
		query.setParameter("keyProd", facturaDetalle.getProducto());
		query.setParameter("keyIdFacturaDetalle", facturaDetalle.getIdFacturaDetalle());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from FacturaDetalle where idFacturaDetalle =: keyIdFacturaDetalle");
		query.setParameter("keyIdFacturaDetalle", id);
		query.executeUpdate();
		
	}
}