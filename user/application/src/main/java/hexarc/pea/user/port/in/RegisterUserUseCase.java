package hexarc.pea.user.port.in;

public interface RegisterUserUseCase {
    Long apply(RegisterUserCommand command);
}
