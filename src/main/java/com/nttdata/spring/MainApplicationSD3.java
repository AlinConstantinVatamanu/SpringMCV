package com.nttdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.NTTDataCustomer;
import com.nttdata.spring.services.NTTDataCustomerManagementServiceI;

/**
 * Formación Spring.
 * 
 * @author NTTData
 *
 */
@SpringBootApplication
public class MainApplicationSD3 implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private NTTDataCustomerManagementServiceI customerService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplicationSD3.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----- NTTData SYS - INI -----");

		// Nuevos clientes.
		final NTTDataCustomer newCustomer1 = new NTTDataCustomer();
		
		
		newCustomer1.setName("Alejandro");
		newCustomer1.setSurName1("Téllez");
		newCustomer1.setSurName2("Rubio");
		newCustomer1.setIdentityDocNumber("28999666A");
		customerService.insertNewCustomer(newCustomer1);

		final NTTDataCustomer newCustomer2 = new NTTDataCustomer();
		newCustomer2.setName("Alejandro");
		newCustomer2.setSurName1("Brazo");
		newCustomer2.setSurName2("Luque");
		newCustomer2.setIdentityDocNumber("30111555B");
		customerService.insertNewCustomer(newCustomer2);

		final NTTDataCustomer newCustomer3 = new NTTDataCustomer();
		newCustomer3.setName("Estefanía");
		newCustomer3.setSurName1("Cano");
		newCustomer3.setSurName2("Muñiz");
		newCustomer3.setIdentityDocNumber("27000888C");
		customerService.insertNewCustomer(newCustomer3);

//		System.out.println("----- INICIO TODOS LOS CLIENTES -----");
		
		// Muestra todos los clientes.
		customerService.searchAllCustomers();
		
//		System.out.println("----- FIN TODOS LOS CLIENTES -----");

//		System.out.println("----- INICIO TODOS LOS CLIENTES POR NOMBRE -----");
		
		// Obtiene los clientes por nombre.
		customerService.searchByName("Alejandro");

//		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE -----");
		
//		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");
		
		// Obtiene los clientes por nombre y apellidos.
		customerService.searchByFullName("Alejandro", "Téllez", "Rubio");

//		System.out.println("----- FIN TODOS LOS CLIENTES POR NOMBRE Y APELLIDOS -----");
		
//		System.out.println("----- EVERIS SYS - FIN -----");

	}

}
