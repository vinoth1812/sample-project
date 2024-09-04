package automobile.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automobile.demo.config.CustomerServices;
import automobile.demo.entity.Customer;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerServices {

    @Autowired
    private automobile.demo.repo.CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer getCustomerByUuid(UUID uuid) {
        return customerRepository.findByUuid(uuid);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer updateCustomerByUuid(UUID uuid, Customer customer) {
        Customer existingCustomer = customerRepository.findByUuid(uuid);
        if (existingCustomer != null) {
            customer.setId(existingCustomer.getId());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void addInteraction(UUID uuid, String interaction) {
        Customer customer = customerRepository.findByUuid(uuid);
        if (customer != null) {
            customer.getInteractions().add(interaction);
            customerRepository.save(customer);
        }
    }

    @Override
    public void addFeedback(UUID uuid, String feedback) {
        Customer customer = customerRepository.findByUuid(uuid);
        if (customer != null) {
            customer.getFeedback().add(feedback);
            customerRepository.save(customer);
        }
    }

    @Override
    public void addInquiry(UUID uuid, String inquiry) {
        Customer customer = customerRepository.findByUuid(uuid);
        if (customer != null) {
            customer.getInquiries().add(inquiry);
            customerRepository.save(customer);
        }
    }

    @Override
    public void addFollowUp(UUID uuid, String followUp) {
        Customer customer = customerRepository.findByUuid(uuid);
        if (customer != null) {
            customer.getFollowUps().add(followUp);
            customerRepository.save(customer);
        }
    }
}
