package hexarc.pea.user.port.in;

public record RegisterUserCommand (String firstName, String lastName, String email, String password, String repeatedPassword) {
}
