package klu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import klu.repository.OrderRepository;

@Service
public class OrderManager {

    @Autowired
    OrderRepository OR;
    
    // Custom query to check if an order with a specific id exists
    public boolean isOrderExist(Long id) {
        return OR.validateOrderId(id) > 0; // Check if the order with the given id exists
    }
    
    public String addOrder(Order O)
    {
        // Check if the order id already exists
        if (isOrderExist(O.getId())) {
            Map<String, String> resp = new HashMap<>();
            resp.put("code", "400");
            resp.put("msg", "Order with the given ID already exists");
            return toJSON(resp);
        }
        
        OR.save(O); // INSERT OPERATION
        
        Map<String, String> resp = new HashMap<>();
        resp.put("code", "200");
        resp.put("msg", "New order has been added");
        return toJSON(resp);
    }
    
    public List<String> getOrder()
    {
        List<String> olist = new ArrayList<>();
        for(Order O : OR.findAll())
        {
            olist.add(toJSON(O));
        }
        return olist;
    }
    
    public String toJSON(Object obj)
    {
        GsonBuilder GB = new GsonBuilder();
        Gson G = GB.create();
        return G.toJson(obj);
    }
}
