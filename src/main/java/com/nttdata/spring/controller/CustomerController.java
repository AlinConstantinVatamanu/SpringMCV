package com.nttdata.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.spring.repository.NTTDataCustomer;
import com.nttdata.spring.repository.NTTDataCustomerRepository;
import com.nttdata.spring.services.NTTDataCustomerManagementServiceI;

@Controller
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private NTTDataCustomerManagementServiceI customerService;
	
	@Autowired
	private NTTDataCustomerRepository customerRepository;
	
	@GetMapping("/*")
	public String menu() {
		return "/menu";
	}
	
	@GetMapping("/mostrarCliente.html")
	public String mostrarCliente(Model model) {
		List<NTTDataCustomer> customers = customerService.searchAllCustomers();
		model.addAttribute("customers", customers);
		return "/mostrarCliente.html";
	}
	
	@PostMapping("/borrarCliente/{id}")
	public String borrarCliente(@PathVariable Long id) {
		customerRepository.deleteById(id);
		return "redirect:/mostrarCliente.html";
	}
	
	//no funciona, se cambia la ruta pero no se actualiza el contenido html
	@PostMapping("/anadirCliente")
	public String anadirCliente(@ModelAttribute NTTDataCustomer newCustomer, Model model) {
		model.addAttribute("newCustomer", newCustomer);
		return "/anadirCliente.html";
	}
	
	//no funciona, se cambia la ruta pero no se actualiza el contenido html
	@PostMapping("/consultarCliente")
	public String consultarCliente(@RequestParam("name") String name) {
		System.out.println(name);
		return "/cosultarClientePorNombre.html";
	}
	

}
