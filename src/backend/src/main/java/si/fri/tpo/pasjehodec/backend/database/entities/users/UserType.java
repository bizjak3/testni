package si.fri.tpo.pasjehodec.backend.database.entities.users;

public class UserType {
    // vsi naj imajo ROLE_ prefix, ker ga zahteva Spring Boot
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String DOG_OWNER = "ROLE_DOG_OWNER";
    public static final String SERVICE_WORKER = "ROLE_SERVICE_WORKER";
}
