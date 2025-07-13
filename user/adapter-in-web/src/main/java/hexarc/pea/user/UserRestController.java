package hexarc.pea.user;


import hexarc.pea.user.port.in.RegisterUserCommand;
import hexarc.pea.user.port.in.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        var userId = registerUserUseCase.apply(new RegisterUserCommand(userDto.firstName(),
                userDto.lastName(), userDto.email(), userDto.password()));
        return null;
    }

}
