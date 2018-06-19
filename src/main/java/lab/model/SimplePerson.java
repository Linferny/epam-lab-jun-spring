package lab.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class SimplePerson implements Person {
    @Id
    @Column
    int id;

    @Column
    String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    Country country;

    int age;
    float height;
    boolean isProgrammer;

    List<Contact> contacts;

    public void sayHello(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "SimplePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", age=" + age +
                ", height=" + height +
                ", isProgrammer=" + isProgrammer +
                ", contacts=" + contacts +
                '}';
    }
}