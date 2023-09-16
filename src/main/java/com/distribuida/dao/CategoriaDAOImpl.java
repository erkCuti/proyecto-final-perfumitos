package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Categoria> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select ca from Categoria ca",Categoria.class).getResultList();
	}
	
	@Override
	@Transactional
	public List<Categoria> findAll(String busqueda) {
		Session session = sessionFactory.getCurrentSession();
		Query<Categoria> query = session.createQuery("SELECT ca from Categoria ca "
				+ "WHERE ca.categoriaConcentacion like: busqueda "
				+ "or ca.aroma like: busqueda "
				+ "or ca.descripcion like: busqueda "
				+ "or ca.durabilidad like: busqueda", Categoria.class);
		
		query.setParameter("busqueda", "%"+ busqueda +"%");		
		return query.getResultList();
	}

	@Override
	@Transactional
	public Categoria findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Categoria> consulta = session.createQuery("select ca from Categoria ca where ca.idCategoria =: keyIdCategoria", Categoria.class);
		consulta.setParameter("keyIdCategoria", id);
		return consulta.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Categoria categoria) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(categoria);
	}

	@Override
	@Transactional
	public void up(Categoria categoria) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Categoria set "
				+ "categoriaConcentacion =: keyCatCon, "
				+ "aroma =: keyAroma, "
				+ "descripcion =: keyDes, "
				+ "durabilidad =: keyDur "
				+ "where idCategoria =: keyIdCategoria "
				);
		query.setParameter("keyCatCon", categoria.getCategoriaConcentacion());
		query.setParameter("keyAroma", categoria.getAroma());
		query.setParameter("keyDes", categoria.getDescripcion());
		query.setParameter("keyDur", categoria.getDurabilidad());
		query.setParameter("keyIdCategoria", categoria.getIdCategoria());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Categoria where idCategoria=:keyIdCategoria");
		query.setParameter("keyIdCategoria", id);
		query.executeUpdate();	
	}

}