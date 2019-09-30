package seedu.address.model.person.parameters;

/**
 * Represents a Reference ID for Patient.
 * Guarantees: Reference Id is present, validated and immutable.
 */
public class StaffReferenceId extends PersonReferenceId {

    public static final String MESSAGE_CONSTRAINTS =
        "Reference Id for staff doctors should start with 'STAFF' followed by numbers.";

    /*
     * The reference ID should only contain alphanumeric characters.
     */
    public static final String VALIDATION_REGEX = "STAFF[0-9]*";

    /**
     * Constructs a {@code DoctorReferenceId}.
     *
     * @param referenceId A valid identifier.
     */
    public StaffReferenceId(String referenceId) {
        super(referenceId);
    }

    /**
     * Returns true if a given string is a valid reference id for staff.
     */
    public static boolean isValidStaffId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean isStaffDoctor() {
        return false;
    }

    @Override
    public boolean isPatient() {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof StaffReferenceId // instanceof handles nulls
            && getReferenceIdentifier().equals(((StaffReferenceId) other).getReferenceIdentifier())); // state check
    }
}
