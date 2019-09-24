package seedu.address.model.common;

import seedu.address.model.person.Name;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Reference ID for Person.
 * Guarantees: Reference Id is present, validated and immutable.
 */
public abstract class PersonReferenceId implements ReferenceId {

    public static final String MESSAGE_CONSTRAINTS =
        "Reference Id should only contain alphanumeric characters and it should be atleast 3 characters long";

    /*
     * The reference ID should only contain alphanumeric characters.
     */
    public static final String VALIDATION_REGEX = "[a-zA-Z0-9]{3,}";
    public final String referenceId;

    /**
     * Constructs a {@code PersonReferenceId}.
     *
     * @param referenceId A valid identifier.
     */
    public PersonReferenceId(String referenceId) {
        requireNonNull(referenceId);
        checkArgument(isValidId(referenceId), MESSAGE_CONSTRAINTS);
        this.referenceId = referenceId;
    }

    /**
     * Returns true if a given string is a valid id.
     */
    public static boolean isValidId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String getReferenceIdentifier() {
        return referenceId;
    }

    @Override
    public String toString() {
        return referenceId;
    }

    @Override
    public int hashCode() {
        return referenceId.hashCode();
    }

}
