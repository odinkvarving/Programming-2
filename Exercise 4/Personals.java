package no.ntnu.idata1001.oblig4;

public class Personals {
    private final String surname;
    private final String firstname;
    private final String emailAddress;
    private String password;

    public Personals(String firstname, String surname, String emailAddress, String password){
        if (firstname == null || surname == null || emailAddress == null || password == null || firstname.trim().equals("") || surname.trim().equals("") || emailAddress.trim().equals("") || password.trim().equals("")){
            throw new IllegalArgumentException("One or more of the parameters are invalid.");
        }
        this.firstname = firstname.trim();
        this.surname = surname.trim();
        this.emailAddress = emailAddress.trim();
        this.password = password.trim();
    }
    public String getFirstname(){
        return firstname;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public String getPassword(){
        return password;
    }

    public boolean okPassword(String password){
        return this.password.equalsIgnoreCase(password);
    }

    public boolean changePassword(String oldPassword, String newPassword){
        if(oldPassword == null) {
            throw new IllegalArgumentException("The old password was registered as null. ");
        }
        if(newPassword == null) {
            throw new IllegalArgumentException("Your new password is invalid. ");
        }

        boolean successful;
        if (!password.equalsIgnoreCase(oldPassword.trim())){
            successful = false;
        }
        else {
            password = newPassword.trim();
            successful = true;
        }
        return successful;
    }

    public String toString(){
        return "" + firstname + " " + surname;
    }
}


