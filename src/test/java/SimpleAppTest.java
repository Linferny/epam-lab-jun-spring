import lab.model.Contact;
import lab.model.Country;
import lab.model.SimpleContact;
import lab.model.SimplePerson;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleAppTest {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

    static AbstractApplicationContext context;

    static SimplePerson expectedPerson;

    @BeforeAll
    static void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(
                APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        SimplePerson person = (SimplePerson) context.getBean("person");
//		FYI: Another way to achieve the bean
//		person = context.getBean(SimplePerson.class);
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
