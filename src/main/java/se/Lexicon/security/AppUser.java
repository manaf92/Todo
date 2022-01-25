package se.Lexicon.security;

import java.util.Objects;

public class AppUser {
    private String userName;
    private String passWord;
    private AppRole role;

    public AppUser(String userName, String passWord, AppRole role) {
        setUserName(userName);
        setPassWord(passWord);
        setRole(role);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName==null)
            throw new IllegalArgumentException("Parameter: String userName was null");
        if (userName.trim().isEmpty())
            throw new IllegalArgumentException("Parameter: String userName was empty");
        this.userName = userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord==null)
            throw new IllegalArgumentException("Parameter: String passWord was null");
        if (passWord.trim().isEmpty())
            throw new IllegalArgumentException("Parameter: String passWord was empty");
        this.passWord = passWord.trim();
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role==null)
            throw new IllegalArgumentException("Parameter: String passWord was null");
        this.role = role;
    }

    @Override
    public String toString() {
        return  "userName='" + userName + '\'' +
                ", role=" + role.getRole();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return getUserName().equals(appUser.getUserName()) && getRole() == appUser.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getRole());
    }
}
