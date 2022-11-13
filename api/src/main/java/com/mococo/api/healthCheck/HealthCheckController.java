package com.mococo.api.healthCheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/check")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Long> healthCheck() {
        return ResponseEntity.ok( System.currentTimeMillis());
    }

}
