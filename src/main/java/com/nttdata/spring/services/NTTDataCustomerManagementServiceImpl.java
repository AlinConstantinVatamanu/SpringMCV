package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nttdata.spring.repository.NTTDataCustomer;
import com.nttdata.spring.repository.NTTDataCustomerRepository;

/**
 * Formación Spring.
 * 
 * @author NTTData
 *
 */
@Service
public class NTTDataCustomerManagementServiceImpl implements NTTDataCustomerManagementServiceI {

	/** Repositorio - Tabla: t_h_customer */
	@Autowired
	private NTTDataCustomerRepository customerRepository;

	@Override
	public NTTDataCustomer insertNewCustomer(NTTDataCustomer newCustomer) {

		// Verificación de nulidad.
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción de cliente.
			newCustomer = customerRepository.save(newCustomer);
		}

		return newCustomer;
	}

	@Override
	public List<NTTDataCustomer> searchAllCustomers() {

		// Consulta clientes.
		final List<NTTDataCustomer> customerList = customerRepository.findAll();

		// Itera e imprime los clientes.
		//customerList.forEach((final NTTDataCustomer customer) -> System.out.println(customer.toString()));
		return customerList;
	}

	@Override
	public void searchByFullName(final String name, final String surname1, final String surname2) {

		// Obtención del listado de clientes por nombre completo.
		final List<NTTDataCustomer> searchClients = customerRepository.findByNameAndSurName1AndSurName2(name, surname1, surname2);

		// Muestra el listado obtenido.
		printCustomers(searchClients);
	}

	@Override
	public void searchByName(final String name) {

		// Obtención del listado de clientes por nombre.
		final List<NTTDataCustomer> searchCustomers = customerRepository.findByName(name);

		// Muestra el listado obtenido.
		printCustomers(searchCustomers);
	}

	/**
	 * Recorre e imprime listado de clientes.
	 * 
	 * @param searchCustomers
	 */
	private void printCustomers(final List<NTTDataCustomer> searchCustomers) {
		if (!CollectionUtils.isEmpty(searchCustomers)) {
			for (NTTDataCustomer customer : searchCustomers) {
				System.out.println(customer.toString());
			}
		}
	}

}
