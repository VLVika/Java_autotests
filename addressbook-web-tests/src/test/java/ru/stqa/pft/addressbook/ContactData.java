package ru.stqa.pft.addressbook;

public class ContactData {
    private final String name;
    private final String sername;
    private final String nikename;
    private final String phone;
    private final String mail;

    public ContactData(String name, String sername, String nikename, String phone, String mail) {
        this.name = name;
        this.sername = sername;
        this.nikename = nikename;
        this.phone = phone;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getSername() {
        return sername;
    }

    public String getNikename() {
        return nikename;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }
}