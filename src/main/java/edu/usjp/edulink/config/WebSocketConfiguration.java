package edu.usjp.edulink.config;

import edu.usjp.edulink.socket.AttendanceSocket;
import edu.usjp.edulink.socket.TrashBinGarbageClassificationSocket;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfiguration implements WebSocketConfigurer {

    private final AttendanceSocket attendanceSocket;
    private final TrashBinGarbageClassificationSocket trashBinGarbageClassificationSocket;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(attendanceSocket, "/attendance").setAllowedOrigins("*");
        registry.addHandler(trashBinGarbageClassificationSocket, "/trash-type").setAllowedOrigins("*");
    }
}
