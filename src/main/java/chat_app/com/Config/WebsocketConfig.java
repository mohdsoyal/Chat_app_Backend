package chat_app.com.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// Enables WebSocket message handling backed by a message broker
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    // Configure message broker for handling messages
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Prefix for where messages will be sent from server to client
        config.enableSimpleBroker("/topic");

        // Prefix for messages coming from client to server
        config.setApplicationDestinationPrefixes("/app");
    }

    // Register STOMP (WebSocket) endpoint
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint for WebSocket connection with fallback to SockJS
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:5173") // Allow frontend connection (React app etc.)
                .withSockJS(); // Enable SockJS fallback for browsers that don’t support WebSocket
    }
}
