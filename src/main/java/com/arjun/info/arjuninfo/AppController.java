package com.arjun.info.arjuninfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	@Autowired
	JavaMailSender mailSender;
	private static final String FILE_PATH = "Resume.pdf";
    private static final String APPLICATION_PDF = "application/pdf";
	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public String sendEmail(@RequestParam String userName, @RequestParam String userEmail, @RequestParam String subject,
			@RequestParam String message) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
		try {
			/* mailMsg.setFrom(emailModle.getUserEmail()); */
			mailMsg.setTo("arjundevrana91info@gmail.com");
			mailMsg.setSubject(subject);
			mailMsg.setText("User Name:" + userName + ", From: " + userEmail + ", Query:" + message);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			return "success";
		}
		return "success";

	}
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = APPLICATION_PDF)
	public void downloadA(HttpServletResponse response) throws IOException {
        File file = getFile();
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }
	 private File getFile() throws FileNotFoundException {
		 ClassLoader classLoader = getClass().getClassLoader();
	        File file = new File(classLoader.getResource(FILE_PATH).getFile());
	        if (!file.exists()){
	            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
	        }
	        return file;
	    }
}
