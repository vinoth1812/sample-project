package automobile.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import automobile.demo.entity.Car;
import automobile.demo.entity.Customer;
import automobile.demo.service.CustomerServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

	  @Autowired
	    private CustomerServiceImpl customerService;

	  @PostMapping("/addcus")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	        Customer savedCustomer = customerService.saveCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }

	    @PostMapping("/bulk")
	    public ResponseEntity<List<Customer>> addCustomers(@RequestBody List<Customer> customers) {
	        List<Customer> savedCustomers = customers.stream()
	            .map(customerService::saveCustomer)
	            .toList();
	        return ResponseEntity.ok(savedCustomers);
	    }

	    @PutMapping("update/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
	        Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
	        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
	    }

	    @PutMapping("/uuid/{uuid}")
	    public ResponseEntity<Customer> updateCustomerByUuid(@PathVariable UUID uuid, @RequestBody Customer customerDetails) {
	        Customer updatedCustomer = customerService.updateCustomerByUuid(uuid, customerDetails);
	        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
	    }

	    @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = customerService.getAllCustomers();
	        return ResponseEntity.ok(customers);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	        Customer customer = customerService.getCustomerById(id);
	        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
	    }

	    @GetMapping("/uuid/{uuid}")
	    public ResponseEntity<Customer> getCustomerByUuid(@PathVariable UUID uuid) {
	        Customer customer = customerService.getCustomerByUuid(uuid);
	        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	        customerService.deleteCustomer(id);
	        return ResponseEntity.noContent().build();
	    }

	    @PostMapping("/interaction/{uuid}")
	    public ResponseEntity<Void> addInteraction(@PathVariable UUID uuid, @RequestBody String interaction) {
	        customerService.addInteraction(uuid, interaction);
	        return ResponseEntity.ok().build();
	    }

	    @PostMapping("/feedback/{uuid}")
	    public ResponseEntity<Void> addFeedback(@PathVariable UUID uuid, @RequestBody String feedback) {
	        customerService.addFeedback(uuid, feedback);
	        return ResponseEntity.ok().build();
	    }

	    @PostMapping("/inquiry/{uuid}")
	    public ResponseEntity<Void> addInquiry(@PathVariable UUID uuid, @RequestBody String inquiry) {
	        customerService.addInquiry(uuid, inquiry);
	        return ResponseEntity.ok().build();
	    }

	    @PostMapping("/followup/{uuid}")
	    public ResponseEntity<Void> addFollowUp(@PathVariable UUID uuid, @RequestBody String followUp) {
	        customerService.addFollowUp(uuid, followUp);
	        return ResponseEntity.ok().build();
	    }
}
