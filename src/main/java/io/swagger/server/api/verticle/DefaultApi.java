package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //DELETE_rhcustomer
    public Customer rhcustomerDelete();
    
    //GET_rhcustomer
    public Customer rhcustomerGet();
    
    //POST_rhcustomer
    public Customer rhcustomerPost(Customer body);
    
    //PUT_rhcustomer
    public Customer rhcustomerPut(Customer body);
    
}
