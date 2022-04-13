package es.pildoras.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			//Obtener el cliente de la tabla cliente de la bd
			Cliente cliente = miSession.get(Cliente.class, 2);
			
			System.out.println("Cliente: "+cliente);
			System.out.println("Pedidos del cliente: "+cliente.getPedidos());
			
			miSession.beginTransaction();
			
			miSession.getTransaction().commit();
			miSession.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			miFactory.close();
		}
		
	}

}
