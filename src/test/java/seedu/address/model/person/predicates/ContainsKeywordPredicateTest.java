package seedu.address.model.person.predicates;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ContainsKeywordPredicateTest {

    @Test
    public void equals() {
        PersonContainsKeywordPredicate firstPredicate = new PersonContainsKeywordPredicate("first");
        PersonContainsKeywordPredicate secondPredicate = new PersonContainsKeywordPredicate("second");

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        PersonContainsKeywordPredicate firstPredicateCopy = new PersonContainsKeywordPredicate("first");
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_idContainsKeywords_returnsTrue() {
        Person testPerson = new PersonBuilder().withPatientId("14598A").withName("Alice").withPhone("12345").build();

        // One keyword
        PersonContainsKeywordPredicate predicate = new PersonContainsKeywordPredicate("459");
        assertTrue(predicate.test(testPerson));

        // Multiple keywords
        predicate = new PersonContainsKeywordPredicate("459");
        assertTrue(predicate.test(testPerson));

        predicate = new PersonContainsKeywordPredicate("98A");
        assertTrue(predicate.test(testPerson));

        // Only one matching keyword
        predicate = new PersonContainsKeywordPredicate("459");
        assertTrue(predicate.test(testPerson));

        predicate = new PersonContainsKeywordPredicate("124");
        assertFalse(predicate.test(testPerson));
    }

    @Test
    public void test_idContainsKeywords_returnsFalse() {
        Person testPerson = new PersonBuilder().withPatientId("14598A").withName("Alice").withPhone("12345").build();

        // Zero keywords
        PersonContainsKeywordPredicate predicate = new PersonContainsKeywordPredicate("");
        assertTrue(predicate.test(testPerson));

        // Non-matching keyword
        predicate = new PersonContainsKeywordPredicate("Carol");
        assertFalse(predicate.test(testPerson));

        predicate = new PersonContainsKeywordPredicate("23");
        assertTrue(predicate.test(testPerson));

        // Keywords match email and address, but does not match id, name or phone
        testPerson = new PersonBuilder().withPatientId("98A").withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build();
        predicate = new PersonContainsKeywordPredicate("+14598A");
        assertFalse(predicate.test(testPerson));

        predicate = new PersonContainsKeywordPredicate("alice@email.com");
        assertFalse(predicate.test(testPerson));

        predicate = new PersonContainsKeywordPredicate("Main");
        assertFalse(predicate.test(testPerson));

        predicate = new PersonContainsKeywordPredicate("Street");
        assertFalse(predicate.test(testPerson));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        PersonContainsKeywordPredicate predicate = new PersonContainsKeywordPredicate("Alice");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Multiple keywords
        predicate = new PersonContainsKeywordPredicate("Alice");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        predicate = new PersonContainsKeywordPredicate("Bob");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Only one matching keyword
        predicate = new PersonContainsKeywordPredicate("Bob");
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Carol").build()));

        predicate = new PersonContainsKeywordPredicate("Carol");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new PersonContainsKeywordPredicate("aLIce");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        predicate = new PersonContainsKeywordPredicate("bOB");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        PersonContainsKeywordPredicate predicate = new PersonContainsKeywordPredicate("");
        assertTrue(predicate.test(new PersonBuilder().withName("Alice").build()));

        // Non-matching keyword
        predicate = new PersonContainsKeywordPredicate("Carol");
        assertFalse(predicate.test(new PersonBuilder().withName("Alice Bob").build()));

        // Keywords match email and address, but does not match id, name or phone
        predicate = new PersonContainsKeywordPredicate("1245");
        assertFalse(predicate.test(new PersonBuilder().withPatientId("98A").withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));

        predicate = new PersonContainsKeywordPredicate("alice@email.com");
        assertFalse(predicate.test(new PersonBuilder().withPatientId("98A").withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));

        predicate = new PersonContainsKeywordPredicate("Main");
        assertFalse(predicate.test(new PersonBuilder().withPatientId("98A").withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));
    }

    @Test
    public void test_phoneContainsKeywords_returnsTrue() {
        // One keyword
        PersonContainsKeywordPredicate predicate = new PersonContainsKeywordPredicate("2345");
        assertTrue(predicate.test(new PersonBuilder().withPhone("12345").build()));

        // Multiple keywords
        predicate = new PersonContainsKeywordPredicate("1234");
        assertTrue(predicate.test(new PersonBuilder().withPhone("12345").build()));

        // Only one matching keyword
        predicate = new PersonContainsKeywordPredicate("4567");
        assertTrue(predicate.test(new PersonBuilder().withPhone("123456").build()));
    }

    @Test
    public void test_phoneContainsKeywords_returnsFalse() {
        // Zero keywords
        PersonContainsKeywordPredicate predicate = new PersonContainsKeywordPredicate("");
        assertTrue(predicate.test(new PersonBuilder().withPhone("12345").build()));

        // Non-matching keyword
        predicate = new PersonContainsKeywordPredicate("Carol");
        assertFalse(predicate.test(new PersonBuilder().withPhone("12345").build()));

        predicate = new PersonContainsKeywordPredicate("123");
        assertTrue(predicate.test(new PersonBuilder().withPatientId("98A")
                .withName("Alice").withPhone("12345").build()));

        // Keywords match email and address, but does not match id, name or phone
        predicate = new PersonContainsKeywordPredicate("12-45");
        assertFalse(predicate.test(new PersonBuilder().withPatientId("98A").withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));

        predicate = new PersonContainsKeywordPredicate("alice@email.com");
        assertFalse(predicate.test(new PersonBuilder().withPatientId("98A").withName("Alice").withPhone("12345")
                .withEmail("alice@email.com").withAddress("Main Street").build()));
    }

}
