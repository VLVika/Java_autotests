package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private  String name;
    private  String sername;
    private  String nikename;
    private  String phone;
    private  String mail;


    private  String group;


    public int getId(){
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }


    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withSername(String sername) {
        this.sername = sername;
        return this;
    }

    public ContactData withNikename(String nikename) {
        this.nikename = nikename;
        return this;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
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
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(sername, that.sername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sername);
    }
}
