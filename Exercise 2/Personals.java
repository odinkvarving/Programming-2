public class Personals {
    private final String surname;
    private final String firstname;
    private final String ePostadr;
    private String password;

    public Personals(String firstname, String surname, String ePostadr, String password){
        if (firstname == null || surname == null || ePostadr == null || password == null || firstname.trim().equals("") || surname.trim().equals("") || ePostadr.trim().equals("") || password.trim().equals("")){
            throw new IllegalArgumentException("Et eller flere konstruktørargumenter er null og/eller blanke.");
        }
        this.firstname = firstname;
        this.surname = surname;
        this.ePostadr = ePostadr;
        this.password = password;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getSurname(){
        return surname;
    }
    public String getePostadr(){
        return ePostadr;
    }
    public String getPassword(){
        return password;
    }
    public boolean okPassword(String password){
        return this.password.equalsIgnoreCase(password);
    }
    public boolean changePassword(String oldPassword, String newPassword){
        if(oldPassword == null || newPassword == null){
            return false;
        }
        if (!password.equalsIgnoreCase(oldPassword.trim())){
            return false;
        }
        else {
            password = newPassword.trim();
            return true;
        }
    }
}
