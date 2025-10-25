package com.combinationlab.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/secure")
public class SecureHelloController {

    @GetMapping("/hello")
    public Map<String, Object> helloSecure(@RequestAttribute(name = "jwt.sub") String sub) {
        return Map.of(
                "message", "Hello, " + sub + " (secure)",
                "language", "Java",
                "secured", true
        );
    }
}
