package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			//obtener DetallesCliente a obtener
			DetallesCliente detallesCliente= miSession.get(DetallesCliente.class, 1);
			System.out.println(detallesCliente);
			System.out.println("Eliminando cliente");
			miSession.delete(detallesCliente);
			miSession.getTransaction().commit();
		}
			catch(Exception e) {
				System.out.println("No se puede borrar");
			}
			
		finally{
			miSession.close();
			miFactory.close();
		}
		
	}

}
