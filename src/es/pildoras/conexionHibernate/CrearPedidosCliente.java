package es.pildoras.conexionHibernate;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

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
			
			
			
			//Crear pedidos del cliente
			
			Pedido pedido1 = new Pedido(new GregorianCalendar(2022,4,13));
			Pedido pedido2 = new Pedido(new GregorianCalendar(2022,4,14));
			Pedido pedido3 = new Pedido(new GregorianCalendar(2022,4,15));
			
			//Agregar pedidos creados al cliente
			cliente.agregarPedido(pedido1);
			cliente.agregarPedido(pedido2);
			cliente.agregarPedido(pedido3);
			
			//Guardar pedidos en bd en tabla pedido
			
			miSession.save(pedido1);
			miSession.save(pedido2);
			miSession.save(pedido3);
			
			miSession.beginTransaction();
			
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente!");
			miSession.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			miFactory.close();
		}
		
	}

}
