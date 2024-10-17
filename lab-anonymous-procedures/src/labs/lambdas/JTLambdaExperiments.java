package labs.lambdas;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * JTLambdaExperiments.java
 *
 * A variety of experiments for working with lambdas, based on the
 * Java Tutorial on lambda expressions, available at 
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class JTLambdaExperiments {

  public static void printPersonsOlderThan(List<Person> roster, int age) {
    for (Person p : roster) {
        if (p.getAge() >= age) {
            p.printPerson();
        }
    }
}

  public static void printPersonsWithinAgeRange(
    List<Person> roster, int low, int high) {
    for (Person p : roster) {
        if (low <= p.getAge() && p.getAge() < high) {
            p.printPerson();
        }
    }
}

interface CheckPerson {
  boolean test(Person p);
}

static class CheckPersonEligibleForSelectiveService implements CheckPerson {
  public boolean test(Person p) {
      return p.gender == Person.Sex.MALE &&
          p.getAge() >= 18 &&
          p.getAge() <= 25;
  }
}

public static void printPersons(
    List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}


  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   */
  public static void main(String[] args) {

    ArrayList people = new ArrayList<>();
    people.add(
             new Person(
             "Mitch",
             IsoChronology.INSTANCE.date(2005, 12, 29),
             Person.Sex.MALE,
             "paivam@gg"));
    people.add(
             new Person(
             "JJ",
             IsoChronology.INSTANCE.date(2005, 8, 17),
             Person.Sex.MALE,
             "jjj@gg"));
    people.add(
             new Person(
             "Koast",
             IsoChronology.INSTANCE.date(2010, 11, 11),
             Person.Sex.MALE,
             "koast@gg"));

    printPersonsOlderThan(people, 10);
    printPersonsWithinAgeRange(people, 5, 16);
    printPersons(people, new CheckPersonEligibleForSelectiveService());


  } // main(String[])

  // +--------------------------------+------------------------------
  // | Methods from the Java Tutorial |
  // +--------------------------------+

} // class JTLambdaExperiments
