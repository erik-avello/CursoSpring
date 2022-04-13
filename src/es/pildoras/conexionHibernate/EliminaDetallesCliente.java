package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			//obtener DetallesCliente a obtener
			DetallesCliente detallesCliente= miSession.get(DetallesCliente.class, 1);
			
			detallesCliente.getCliente().setDetallesCliente(null);
			
			if(detallesCliente != null) {
				miSession.delete(detallesCliente);
				System.out.println("Cliente eliminado");
			}else {
				System.out.println("No se puede borrar");
				miSession.close();
			}
			
	
			miSession.getTransaction().commit();
		}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("No se puede borrar");
			}
			
		finally{
			miSession.close();
			miFactory.close();
		}
		
	}

}
