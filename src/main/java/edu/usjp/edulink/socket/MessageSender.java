package edu.usjp.edulink.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSender {
    AttendanceWebSocket server;
    public MessageSender() {
        server = new AttendanceWebSocket(8887);
        server.start();
        log.info("Server started at {}", server.getPort());
    }

    public void sendMessage(Object message) {
        server.sendCustomMessage(message);
    }

}
