
package io.helidon.observe.app;

import java.util.concurrent.atomic.AtomicReference;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * For traces
 */
import org.eclipse.microprofile.opentracing.Traced; 

/**
 * Provider for greeting message.
 */
@ApplicationScoped
@Traced
public class GreetingProvider {
    private final AtomicReference<String> message = new AtomicReference<>();

    /**
     * Create a new greeting provider, reading the message from configuration.
     *
     * @param message greeting to use
     */
    @Inject
    public GreetingProvider(@ConfigProperty(name = "app.greeting") String message) {
        this.message.set(message);
    }

    String getMessage() {
        return message.get();
    }

    void setMessage(String message) {
        this.message.set(message);
    }
}
