package com.embraer.ewmbackend.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isOk = checkExternalService();

        if (isOk) {
            return Health.up()
                    .withDetail("custom-check", "External service is OK")
                    .build();
        } else {
            return Health.down()
                    .withDetail("custom-check", "External service FAILED")
                    .build();
        }
    }

    // Exemplo simples de checagem
    private boolean checkExternalService() {
        // Aqui você faria algo como verificar status de um serviço, fila, etc.
        // Retorne true se estiver OK, false se estiver com problemas.
        return true;
    }
}
