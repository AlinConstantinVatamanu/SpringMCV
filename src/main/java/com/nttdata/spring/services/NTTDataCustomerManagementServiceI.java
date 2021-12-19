package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.repository.NTTDataCustomer;

public interface NTTDataCustomerManagementServiceI {

	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newCustomer
	 * @return NTTDataCustomer
	 */
	public NTTDataCustomer insertNewCustomer(final NTTDataCustomer newCustomer);

	/**
	 * Consulta todos los clientes.
	 */
	public List<NTTDataCustomer> searchAllCustomers();

	/**
	 * Búsqueda por nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 */
	public void searchByFullName(final String name, final String surname1, final String surname2);

	/**
	 * Búsqueda por nombre.
	 * 
	 * @param name
	 */
	public void searchByName(final String name);

}
