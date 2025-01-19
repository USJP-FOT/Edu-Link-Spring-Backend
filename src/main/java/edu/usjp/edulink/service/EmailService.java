package edu.usjp.edulink.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
