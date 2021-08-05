package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String name;
    private final String sername;
    private final String nikename;
    private final String phone;
    private final String mail;
    private final String group;

    public ContactData(int id, String name, String sername, String nikename, String phone, String mail, String group) {
        this.id = id;
        this.name = name;
        this.sername = sername;
        this.nikename = nikename;
        this.phone = phone;
        this.mail = mail;
        this.group = group;
    }


    public ContactData(String name, String sername, String nikename, String phone, String mail, String group) {
        this.id = Integer.MAX_VALUE;
        this.name = name;
        this.sername = sername;
        this.nikename = nikename;
        this.phone = phone;
        this.mail = mail;
        this.group = group;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGroup(){
        return group;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(sername, that.sername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sername);
    }
}
