package ReadAndSave.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ReadAndSave.app.Service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/WriteToExcel")
	public void ReadExcel() {
		userservice.ReadExcel();
		
		
	}
	

}
