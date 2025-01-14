package domain.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeakReport {
    private int id,postalCode, serviceAssignmentId;

    private String firstName,lastName,email,city,street,comment,houseNumber;
    private LeakStatus status;

    public LeakReport(int id, int postalCode, String houseNumber, String firstName, String lastName, String email, String city, String street, int serviceAssignmentId) {
        this.id = id;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.street = street;
        this.serviceAssignmentId = serviceAssignmentId;
    }

    public LeakReport(int id, int postalCode, String houseNumber, String firstName, String lastName, String email, String city, String street, String comment, int serviceAssignmentId){
        this(id,postalCode, houseNumber, firstName, lastName,email,city,street, serviceAssignmentId);
        this.comment = comment;
    }
    public LeakReport() {
    }

    @Override
    public String toString() {
        return "LeakReport{" +
                "id=" + id +
                ", postalCode=" + postalCode +
                ", houseNumber=" + houseNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostalCode(int postalCode) {
        if(String.valueOf(postalCode).length()!=4){
            throw new IllegalArgumentException("Postcode is niet geldig");
        }
        this.postalCode = postalCode;

    }

    public void setHouseNumber(String houseNumber) {
        if(houseNumber.isBlank()){
            throw new IllegalArgumentException("Vul een juist huisnummer in.");
        }
//        if(Integer.parseInt(houseNumber)<=0){
//            throw new IllegalArgumentException("Vul een juist huisnummer in.");
//        }
        this.houseNumber = houseNumber;
    }

    public void setFirstName(String firstName) {
        if(this.firstName != null){
            throw new IllegalArgumentException("Voornaam mag niet veranderd worden.");
        }

        if(firstName.isEmpty()){
            throw new IllegalArgumentException("Vul een voornaam in.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(this.lastName != null){
            throw new IllegalArgumentException("Achternaam mag niet veranderd worden.");
        }
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("Vul een achternaam in.");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if(this.email != null){
            throw new IllegalArgumentException("Email mag niet veranderd worden.");
        }
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Vul een email in.");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Geef een geldige email in.");
        }
        this.email = email;
    }

    public void setCity(String city) {
        if(city.isEmpty()){
            throw new IllegalArgumentException("Vul een juiste plaats in.");
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if(street.isEmpty()){
            throw new IllegalArgumentException("Vul een juiste straat in.");
        }
        this.street = street;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setAssignmentId(int assignmentId) {
        this.serviceAssignmentId = assignmentId;
    }

    public int getServiceAssignmentId() {
        return serviceAssignmentId;
    }

    public LeakStatus getStatus() {
        return status;
    }

    public void setStatus(LeakStatus status) {
        this.status = status;
    }

}
