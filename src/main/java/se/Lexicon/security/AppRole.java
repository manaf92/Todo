package se.Lexicon.security;

public enum AppRole {
    ROLE_APP_User("User"),
    ROLE_APP_ADMIN("Admin");


    private String role ;
    AppRole(String role) {
        this.role=role;
    }

    String getRole(){
        return this.role;
    }

}
