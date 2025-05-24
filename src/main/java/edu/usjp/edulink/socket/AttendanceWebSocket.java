/*
package edu.usjp.edulink.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;


import java.net.InetSocketAddress;
@Slf4j
public class AttendanceWebSocket extends WebSocketServer {
    private WebSocket currentConnection;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public AttendanceWebSocket(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        log.info("Connected to " + conn.getRemoteSocketAddress());
        this.currentConnection = conn;

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        log.info("Disconnected from " + conn.getRemoteSocketAddress());
        this.currentConnection = null;
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        log.info("Received message from " + conn.getRemoteSocketAddress() + ": " + message);


    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void onStart() {
        log.info("Starting WebSocket Server");
    }



    public void sendCustomMessage(Object obj) {
        try {
            if (currentConnection != null) {
                String jsonMessage = objectMapper.writeValueAsString(obj);
                currentConnection.send(jsonMessage);
            } else {
                log.warn("No current connection");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
