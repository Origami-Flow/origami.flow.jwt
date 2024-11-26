package origami.flow.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import origami.flow.jwt.domain.User;
import origami.flow.jwt.infra.security.TokenService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @PostMapping("/generating-token")
    public ResponseEntity<String> generetingToken(@RequestBody User user) {
        return ResponseEntity.ok(tokenService.generateToken(user));
    }

    @PostMapping("/validate-token")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        return ResponseEntity.ok(tokenService.validateToken(token));
    }
}
