package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import springmvc.model.User;

@Controller
public class HomeController {
	
// sending data from controller to view using modelAttribute
	
	@RequestMapping(path="/home",method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("name","Shashank Pandey");
		return "index";
	}
	
// 	sending data from controller to view using modelandView object
	
	@RequestMapping(path="/help", method=RequestMethod.GET)
	public ModelAndView help()
	{
		// creating modelandview object
		ModelAndView m1 = new ModelAndView();
		m1.addObject("name","Shashank Pandey");
		m1.addObject("Pagename","Help Page");
		m1.setViewName("help");
		return m1;
	}
	
	@RequestMapping(path="/contact", method=RequestMethod.GET)
	public String showForm()
	{
		return "contact";
	}
	
	// There are Two ways to handle data coming from Form
	
	// 1.Handling Form With @RequestParam Annotation      // uncomment to see it's working
	
//	@RequestMapping(path="/formsubmit", method=RequestMethod.POST)
//	public String formHandler(
//			 @RequestParam("email") String email,
//			 @RequestParam("username") String username,
//			 @RequestParam("password") String password, Model model)
//	{
//			
//		User user = new User();
//		user.setEmail(email);
//		user.setUsername(username);
//		user.setPassword(password);
//		
//		System.out.println(user);    // just to check the data coming from the form
//		
//		//processing the data
//		
//		model.addAttribute("user",user);
//		
//		return "success";
//	}
	
	// 2. Handling Form With @ModelAttribute Annotation 
	
	@RequestMapping(path="/formsubmit", method=RequestMethod.POST)
	public String formHandler(@ModelAttribute User user)
	{
		System.out.println(user);    // just to check the data coming from the form
	
		return "success";
	}
	
	// Generic Exceptional Handling
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler()
	{
		return "error";
	}

    
	
}
