package automobile.demo.config;

import java.util.List;
import java.util.UUID;

import automobile.demo.entity.Customer;

public interface CustomerServices  {
	
	 Customer getCustomerById(Long id);
	    Customer getCustomerByUuid(UUID uuid);
	    List<Customer> getAllCustomers();
	    Customer saveCustomer(Customer customer);
	    void deleteCustomer(Long id);
	    Customer updateCustomer(Long id, Customer customer);
	    Customer updateCustomerByUuid(UUID uuid, Customer customer);
	    void addInteraction(UUID uuid, String interaction);
	    void addFeedback(UUID uuid, String feedback);
	    void addInquiry(UUID uuid, String inquiry);
	    void addFollowUp(UUID uuid, String followUp);

}
