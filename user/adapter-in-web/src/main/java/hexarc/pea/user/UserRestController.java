package hexarc.pea.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    @GetMapping("/user/{userId}")
    public ResponseEntity<String> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userId + " user", HttpStatus.CREATED);
    }

}
