package automobile.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import  org.springframework.mail.SimpleMailMessage;
@SpringBootTest
class CarshowroomApplicationTests {

	@Test
	void contextLoads() {
	}
	  @Autowired
	    private JavaMailSender mailSender;

	    public void sendEmail(String to, String subject, String text) {
	        try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(to);
	            message.setSubject(subject);
	            message.setText(text);
	            mailSender.send(message);
	            System.out.println("Email sent successfully to " + to);
	        } catch (Exception e) {
	            System.out.println("Failed to send email to " + to);
	            e.printStackTrace();
	        }
	    }
}
