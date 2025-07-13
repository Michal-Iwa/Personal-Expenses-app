package hexarc.pea.user;

import hexarc.pea.user.port.out.RegisterUserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RegisterUserAdapter implements RegisterUserPort {
    private final UserRepository userRepository;
    @Override
    public Long registerUser(User user) {
        var registerdUser = userRepository.save(user);
        return registerdUser.getId();
    }
}
