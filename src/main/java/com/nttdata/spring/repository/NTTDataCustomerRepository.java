package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Formación Spring.
 * 
 * @author NTTData
 *
 */
@Repository
public interface NTTDataCustomerRepository extends JpaRepository<NTTDataCustomer, Long> {

	/**
	 * Obtención del cliente mediante el nombre.
	 * 
	 * @param name
	 * @return List<EverisClient>
	 */
	public List<NTTDataCustomer> findByName(final String name);

	/**
	 * Obtención del cliente mediante el nombre completo.
	 * 
	 * @param name
	 * @return List<EverisClient>
	 */
	public List<NTTDataCustomer> findByNameAndSurName1AndSurName2(final String name, final String surname1, final String surname2);

}
