/*
 * package automobile.demo.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.stereotype.Service; import
 * org.springframework.mail.SimpleMailMessage;
 * 
 * 
 * @Service public class EmileService{
 * 
 * 
 * @Autowired private JavaMailSender mailSender;
 * 
 * public void sendEmail(String to, String subject, String text) {
 * SimpleMailMessage message = new SimpleMailMessage(); message.setTo(to);
 * message.setSubject(subject); message.setText(text); mailSender.send(message);
 * } }
 */


