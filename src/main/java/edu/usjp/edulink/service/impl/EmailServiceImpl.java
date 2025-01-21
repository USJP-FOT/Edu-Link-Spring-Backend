package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
        final private JavaMailSender javaMailSender;

        public void sendEmail(String to, String subject, String body) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("edulinknotification@gmail.com");  // sender's email address
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);

            log.info("Email send successfully {}", to);
        }

/*        public void sendAnnouncementEmail(String to, String subject, String body) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("indumawijesingha@gmail.com");  // sender's email address
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);
        }*/
}
