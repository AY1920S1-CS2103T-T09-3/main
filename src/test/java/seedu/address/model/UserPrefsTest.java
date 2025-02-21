package seedu.address.model;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.userprefs.UserPrefs;

public class UserPrefsTest {

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        UserPrefs userPref = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPref.setGuiSettings(null));
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setPatientAddressBookFilePath(null));
        assertThrows(NullPointerException.class, () -> userPrefs.setStaffAddressBookFilePath(null));
        assertThrows(NullPointerException.class, () -> userPrefs.setPatientAppointmentBookFilePath(null));
        assertThrows(NullPointerException.class, () -> userPrefs.setDutyRosterBookFilePath(null));
    }

}
