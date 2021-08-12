package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private  String name;
    private  String sername;
    private  String nikename;
    private  String phoneHome;
    private  String phoneMobile;
    private  String phoneWork;
    private  String mail;
    private  String mail2;
    private  String mail3;
    private  String allPhones;
    private  String allEmail;





    private  String group;


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

    public ContactData withPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
        return this;
    }

    public ContactData withphoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
        return this;
    }

    public ContactData withphoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
        return this;
    }


    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public ContactData withMail2(String mail2) {
        this.mail2 = mail2;
        return this;
    }


    public ContactData withMail3(String mail3) {
        this.mail3 = mail3;
        return this;
    }


    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }


    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }



    public int getId(){ return id;}

    public String getName() {
        return name;
    }

    public String getSername() {
        return sername;
    }

    public String getNikename() {
        return nikename;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getMail() {
        return mail;
    }

    public String getMail2() {
        return mail2;
    }

    public String getMail3() {
        return mail3;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public String getGroup(){
        return group;
    }

    public String getPhoneHome() {return phoneHome;}

    public String getPhoneWork() {return phoneWork; }

    public String getAllPhones() {return allPhones;}



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
