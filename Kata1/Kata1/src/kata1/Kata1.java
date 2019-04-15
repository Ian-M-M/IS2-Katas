package kata1;

import java.time.LocalDate;
public class Kata1 {
    
    public static void main(String[] args) {
        Person p1 = new Person("Alfonso", LocalDate.of(1998,12,12));
        System.out.println(p1.getName() + " tiene " + p1.getAge() + " años");
    }
    
}
