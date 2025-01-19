package edu.usjp.edulink.task;

import edu.usjp.edulink.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailSender {
    private final EmailService emailService;

    @Scheduled(fixedRate = 2000)
    public void sendEmail() {
       /* emailService.sendEmail("indumawijesinghe@outlook.com",
                "Test Sample",
                "This is the email body");
        log.info("Email Send Success");*/
    }
}
