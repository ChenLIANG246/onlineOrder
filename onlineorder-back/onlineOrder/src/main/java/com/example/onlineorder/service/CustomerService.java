package com.example.onlineorder.service;

import com.example.onlineorder.dao.CustomerDao;
import com.example.onlineorder.entity.Cart;
import com.example.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //spring 提供的annotation. 已自带@Component
public class CustomerService { //注入到CustomerService

    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
