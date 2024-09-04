package automobile.demo.controller;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import automobile.demo.service.ReportExportService;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportExportService jasperReportService;

@GetMapping("/carreport")
   	
   	public String OrderReport() throws FileNotFoundException, JRException {
	jasperReportService.generateCarReport("pdf");
		
		return "sucessfully genreated";
		
		
	}
	
    
    
    
}
    
