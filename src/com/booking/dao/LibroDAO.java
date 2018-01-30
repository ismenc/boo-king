package com.booking.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.booking.modelo.BookingException;
import com.booking.persistencia.HibernateUtil;
import com.booking.persistencia.Libro;

/**
 * Define las operaciones sobre libros en la base de datos.
 * @author Ismael Nunez
 *
 */
public class LibroDAO extends GenericEntity<Libro> {

	public Libro obtener(int idLibro) throws BookingException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Libro libro = (Libro) session.get(Libro.class, idLibro);
		
		if(libro == null)
			throw new BookingException("Error. El libro "+ idLibro + " no existe.");
		
		return libro;
	}
	
	@SuppressWarnings("unchecked")
	public List<Libro> obtenerLista()  {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Criteria criterio = session.createCriteria(Libro.class);
		
		return criterio.list();
	}
	
}