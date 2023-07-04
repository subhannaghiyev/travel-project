package az.spring.model;

import lombok.Data;

@Data
public class UserToken {
    private String id;
    private String username;
    private String password;
    private String token;

    public String getToken() {
        return token;
    }
}
