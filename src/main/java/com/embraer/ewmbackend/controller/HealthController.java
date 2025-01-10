package com.embraer.ewmbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health Check", description = "Endpoints related to the application's health verification")
public class HealthController {

    @GetMapping("/health")
    @Operation(
            summary = "Checks if the application is running",
            description = "Returns 200 (OK) if the application is healthy or 503 (Service Unavailable) if it's down"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Application is up!",
                    content = @Content(schema = @Schema(type = "string"))
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Application is down!",
                    content = @Content(schema = @Schema(type = "string"))
            )
    })
    public ResponseEntity<String> health() {

        boolean isOk = checkSomething();

        if (isOk) {
            return new ResponseEntity<>("Application is up!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Application is down!", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    private boolean checkSomething() {
        return true;
    }
}
