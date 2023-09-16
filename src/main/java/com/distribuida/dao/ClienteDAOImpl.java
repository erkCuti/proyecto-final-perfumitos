package com.distribuida.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.distribuida.entities.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select cli from Cliente cli",Cliente.class).getResultList();
	}
	
	@Override
	@Transactional
	public List<Cliente> findAll(String busqueda) {
		Session session = sessionFactory.getCurrentSession();
		Query<Cliente> query = session.createQuery("SELECT CL FROM Cliente CL "
				+ "WHERE CL.cedula like: busqueda "
				+ "or CL.nombre like: busqueda "
				+ "or CL.apellido like: busqueda "
				+ "or CL.direccion like: busqueda "
				+ "or CL.telefono like: busqueda "
				+ "or CL.correo like: busqueda", Cliente.class);

		query.setParameter("busqueda", "%"+ busqueda +"%");		
		return query.getResultList();
	}

	@Override
	@Transactional
	public Cliente findOne(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Cliente> consulta = session.createQuery("select cli from Cliente cli where cli.idCliente =: keyIdCliente", Cliente.class);
		consulta.setParameter("keyIdCliente", id);
		return consulta.getSingleResult();
	}

	@Override
	@Transactional
	public void add(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cliente);
	}

	@Override
	@Transactional
	public void up(Cliente cliente) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Cliente set "
				+ "cedula =: keyCed, "
				+ "nombre =: keyNom, "
				+ "apellido =: keyApe, "
				+ "direccion =: keyDir, "
				+ "telefono =: keyTlf "
				+ "where idCliente =: keyIdCliente "
				);
		query.setParameter("keyCed", cliente.getCedula());
		query.setParameter("keyNom", cliente.getNombre());
		query.setParameter("keyApe", cliente.getApellido());
		query.setParameter("keyDir", cliente.getDireccion());
		query.setParameter("keyTlf", cliente.getTelefono());
		query.setParameter("keyIdCliente", cliente.getIdCliente());
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void del(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Cliente where idCliente =: keyIdCliente");
		query.setParameter("keyIdCliente", id);
		query.executeUpdate();;
	}

}