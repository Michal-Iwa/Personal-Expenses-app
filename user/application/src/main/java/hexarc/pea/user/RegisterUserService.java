package hexarc.pea.user;

import hexarc.pea.user.port.in.RegisterUserCommand;
import hexarc.pea.user.port.in.RegisterUserUseCase;
import hexarc.pea.user.port.out.RegisterUserPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
class RegisterUserService implements RegisterUserUseCase {
    private final RegisterUserPort registerUserPort;

    @Transactional
    @Override
    public Long apply(RegisterUserCommand command) {

        //here implement hashing and probably keycloak #TODO
        final var newUser = new User.UserBuilder()
                .firstName(command.firstName())
                .lastName(command.lastName())
                .email(command.email())
                .passwordHash(command.password())
                .build();
        return registerUserPort.registerUser(newUser);
    }
}
