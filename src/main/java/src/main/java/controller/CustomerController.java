package src.main.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.dao.CustomerDAO;
import src.main.java.model.Customer;

@RestController
//@RequestMapping("/customers") -- we can define it here as well.
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	@GetMapping("/listCusotmers")
	public List<Customer> customerList(){
		
		return customerDAO.list();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="/{id}", headers ="Accept=application/xml") // Will Return data in  XML
	public ResponseEntity getCustomer(@PathVariable("id") Long id){
		
		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value="/customer")
	public ResponseEntity createCustomer(@RequestBody Customer customer){
		
		customerDAO.create(customer);
		return new ResponseEntity(customer, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value="/customer/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		
		customer = customerDAO.update(id, customer);
		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(customer, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/customer/{id}")
	public String deleteCustomer(@PathVariable Long id){
		
		Long deletedId = customerDAO.delete(id);
		if(deletedId == null){
			return "No Profile found for ID "+id;
		}
		return "Profile of ID "+id+ " Deleted Successfully .";
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}


}
