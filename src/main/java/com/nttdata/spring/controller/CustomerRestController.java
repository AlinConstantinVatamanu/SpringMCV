package com.nttdata.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nttdata.spring.repository.NTTDataCustomer;
import com.nttdata.spring.repository.NTTDataCustomerRepository;
import com.nttdata.spring.services.NTTDataCustomerManagementServiceI;

@RestController
@RequestMapping("/")
public class CustomerRestController {

	@Autowired
	private NTTDataCustomerManagementServiceI customerService;
	
	@Autowired
	private NTTDataCustomerRepository customerRepository;
	
	//retorna todos los clientes
	@GetMapping("/showCustomers")
	@ResponseBody
	public String showCustomer() {
		List<NTTDataCustomer> customers = customerService.searchAllCustomers();
		String customersJson = new Gson().toJson(customers);
		return customersJson;
	}
	//borra el cliente y retorna los que quedan
	@DeleteMapping("/deleteCustomer/{id}")
	@ResponseBody
	public String deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
		List<NTTDataCustomer> customers = customerService.searchAllCustomers();
		return new Gson().toJson(customers);
	}
	
	//añade el cliente y retorna listado actualizado
	@PostMapping("/addCustomer")
	@ResponseBody
	public String addCustomer(@RequestBody String newCustomer) {
		NTTDataCustomer customer = new NTTDataCustomer();
		customer = new Gson().fromJson(newCustomer, NTTDataCustomer.class);
		customerRepository.save(customer);
		List<NTTDataCustomer> customers = customerService.searchAllCustomers();
		return new Gson().toJson(customers);
	}
	
	//retorna listado con clientes que coinciden
	@GetMapping("/getCustomerByName/{name}")
	@ResponseBody
	public String getCustomerByName(@PathVariable String name) {
		
		List<NTTDataCustomer> customers = customerRepository.findByName(name);
		String customersJson = new Gson().toJson(customers);
		return customersJson;
	}
}
