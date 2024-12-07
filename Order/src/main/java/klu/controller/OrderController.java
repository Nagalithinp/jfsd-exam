package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.Order;
import klu.model.OrderManager;



@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	OrderManager OM;
	
	@PostMapping("/save")
	public String saveOrder(@RequestBody Order O)
	{
		return OM.addOrder(O);
		
	}
	
	@GetMapping("/read")
	public String readOrder()
	{
		return OM.getOrder().toString();
	}

}
