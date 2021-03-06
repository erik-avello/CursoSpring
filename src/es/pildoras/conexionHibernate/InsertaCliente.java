package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			Cliente cliente = new Cliente("Ana","Marin","Santiago");
			DetallesCliente detalle = new DetallesCliente("Twitter","2222","buena página");
			
			//Asociar los objetos 
			cliente.setDetallesCliente(detalle);
			
			//Esto guarda la información de dos tablas relacionadas
			
			miSession.beginTransaction();
			miSession.save(cliente);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente!");
			miSession.close();
			
		} finally{
			miFactory.close();
		}
		
	}

}
