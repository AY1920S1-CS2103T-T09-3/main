package seedu.address.logic.commands.utils;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyAppointmentBook;
import seedu.address.model.ReferenceId;
import seedu.address.model.events.Event;
import seedu.address.model.exceptions.EntryNotFoundException;
import seedu.address.model.person.Person;
import seedu.address.model.queue.QueueManager;
import seedu.address.model.queue.Room;
import seedu.address.model.userprefs.ReadOnlyUserPrefs;

/**
 * A default model stub that have all of the methods failing.
 */
public class ModelStub implements Model {
    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public GuiSettings getGuiSettings() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addPerson(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setPatientAddressBook(ReadOnlyAddressBook newData) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyAddressBook getPatientAddressBook() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasPerson(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasPatient(ReferenceId person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasExactPerson(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deletePerson(Person target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setStaffAddressBook(ReadOnlyAddressBook staffAddressBook) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyAddressBook getStaffAddressBook() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasStaff(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasExactStaff(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deleteStaff(Person target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addStaff(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setStaff(Person target, Person editedPerson) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Person> getFilteredStaffList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredStaffList(Predicate<Person> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public QueueManager getQueueManager() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeFromQueue(ReferenceId target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void enqueuePatient(ReferenceId id) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void enqueuePatientToIndex(ReferenceId id, int index) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean isPatientInQueue(ReferenceId id) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Room> getConsultationRoomList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addRoom(Room room) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeRoom(Room room) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasRoom(Room room) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAppointmentSchedule(ReadOnlyAppointmentBook schedule) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyAppointmentBook getAppointmentBook() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasAppointment(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasExactAppointment(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deleteAppointment(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addAppointment(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAppointment(Event target, Event editedEvent) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Event> getFilteredAppointmentList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredAppointmentList(Predicate<Event> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredEventList(ReferenceId referenceId) {

    }

    @Override
    public void updateFilteredEventList() {

    }

    @Override
    public void updateToMissedEventList() {

    }

    @Override
    public void updateToSettleEventList() {

    }

    @Override
    public void displayApprovedAndAckedPatientEvent(ReferenceId referenceId) {

    }


    @Override
    public Boolean isPatientList() {
        return null;
    }

    @Override
    public Boolean isMissedList() {
        return null;
    }

    @Override
    public ObservableList<ReferenceId> getQueueList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Person resolvePatient(ReferenceId person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Person resolveStaff(ReferenceId id) throws EntryNotFoundException {
        return null;
    }

    @Override
    public boolean hasStaff(ReferenceId id) {
        return false;
    }
}
