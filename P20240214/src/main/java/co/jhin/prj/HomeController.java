package co.jhin.prj;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		try {
			Connection conn = dataSource.getConnection();
			System.out.println("db connected");
		} catch (Exception e) {
			System.out.println("db connection failed");
		}
		
		return "home";
	}
	
}
