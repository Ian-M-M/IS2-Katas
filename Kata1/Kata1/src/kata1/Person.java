package kata1;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    
    private String name;
    private LocalDate birthdate;
    private final long MILLIS_YEAR = 31556900000L;
    
    public Person(String nm,  LocalDate btd){
        name = nm;
        birthdate = btd;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    
    public int getAge(){
        return (int) (Period.between(birthdate, LocalDate.now()).getYears());
    }
}