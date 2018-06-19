import lab.model.Contact;
import lab.model.Country;
import lab.model.SimpleContact;
import lab.model.SimplePerson;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpringTCFAppTest {

    @Autowired
    SimplePerson person;

    static SimplePerson expectedPerson;


    @BeforeAll
    static void setUp() throws Exception {
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        assertEquals(expectedPerson, person);
        System.out.println(person);
    }

    static SimplePerson getExpectedPerson() {
        SimplePerson person = new SimplePerson();
        person.setAge(35);
        person.setHeight(1.78F);
        person.setProgrammer(true);
        person.setName("John Smith");

        Country country = new Country();
        country.setId(1);
        country.setName("Russia");
        country.setCodeName("RU");

        person.setCountry(country);

        List<Contact> contacts = new ArrayList<>();

        SimpleContact contact1 = new SimpleContact();
        contact1.setType("TELEPHONE");
        contact1.setValue("+7-234-456-67-89");

        SimpleContact contact2 = new SimpleContact();
        contact2.setType("EMAIL");
        contact2.setValue("asd@asd.ru");

        contacts.add(contact1);
        contacts.add(contact2);

        person.setContacts(contacts);

        return person;
    }

}

