package automobile.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import automobile.demo.entity.Car;
import automobile.demo.repo.Carrepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportExportService {

    private final Carrepository carRepository;

    public ReportExportService(Carrepository carRepository) {
        this.carRepository = carRepository;
    }

    public String generateCarReport(String format) {
    	 try {
 	        List<Car> items = carRepository.findAll();
 	        System.out.println(items);
 	        String path = "E:\\checkReport";
 	        File file = ResourceUtils.getFile("classpath:salesreport.jrxml");
 	        JasperReport report;
 	        report = JasperCompileManager.compileReport(file.getAbsolutePath());
 	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);
 	        HashMap<String, Object> parameters = new HashMap<>();
 	        parameters.put("createdBy", "java");

 	        JasperPrint jasprint = JasperFillManager.fillReport(report, parameters, dataSource);

 	        if (format.equalsIgnoreCase("pdf")) {
 	            JasperExportManager.exportReportToPdfFile(jasprint, path + "\\car.pdf");
 	        }

 	        return "Report generated in path: " + path;
 	    } catch (FileNotFoundException e) {
 	        // Handle file not found exception
 	        e.printStackTrace(); // You might want to log the exception or handle it appropriately
 	        return "Error: File not found";
 	    } catch (JRException e) {
 	        // Handle JasperReport exception
 	        e.printStackTrace(); // You might want to log the exception or handle it appropriately
 	        return "Error generating report";
 	    } catch (Exception e) {
 	        // Handle other exceptions
 	        e.printStackTrace(); // You might want to log the exception or handle it appropriately
 	        return "Error: " + e.getMessage();
 	    }
    }
}
