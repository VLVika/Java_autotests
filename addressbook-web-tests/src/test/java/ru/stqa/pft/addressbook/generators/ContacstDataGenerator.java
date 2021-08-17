package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContacstDataGenerator {

    @Parameter(names = "-c2", description = "Contact count")
    public int count;

    @Parameter(names = "-f2", description = "Target file2")
    public String file;

    public static void main(String[] args) throws IOException {
        ContacstDataGenerator generator = new ContacstDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContact(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact: contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getName(), contact.getSername(),
                    contact.getNikename(), contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork(),
                    contact.getMail(), contact.getMail2(), contact.getMail3(), contact.getGroup()));
        }
        writer.close();


    }

    private List<ContactData> generateContact(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i= 0; i<count; i++){
            contacts.add(new ContactData().withName(String.format("Vika %s", i))
                    .withSername(String.format("Ledovskikh %s", i))
                    .withNikename(String.format("LedoVik %s", i)).withPhoneHome(String.format("996-58-96 %s", i))
                    .withphoneMobile(String.format("9965-84-99 %s", i)).withphoneWork(String.format("647-99-85 %s", i))
                    .withMail(String.format("addressnew@mail.ru %s", i)).withMail2(String.format("addressnew2@mail.ru %s", i)).withMail3(String.format("addressnew3@mail.ru %s", i)).withGroup(String.format("test1 %s", i)));
        }
        return contacts;
    }
}
