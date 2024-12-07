package klu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ViewController 
{
	
	
		@GetMapping("/")
		public ModelAndView customer()
		{
			ModelAndView mvc = new ModelAndView();
			mvc.setViewName("order.jsp");
			return mvc;
		}
		

}
