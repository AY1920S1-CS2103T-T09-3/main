package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.common.CommandResult;
import seedu.address.logic.commands.common.ReversibleCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.common.ReferenceId;
import seedu.address.model.events.ContainsKeywordsPredicate;
import seedu.address.model.events.Event;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

/**
 * cancel a appointments for a patient.
 */
public class CancelAppCommand extends ReversibleCommand {
    public static final String COMMAND_WORD = "cancelappt";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Cancels appointment from the schedule. "
            + "Parameters: INDEX (positive integer)\n"
            + "need to go to patient's appointment list first\n"
            + "Example: " + "appoinments 001A \n"
            + COMMAND_WORD + " 1";
    public static final String MESSAGE_CANCEL_APPOINTMENT_SUCCESS = "Appointment cancelled: %1$s";

//    private final Index apptIdx;
    private final Event toDelete;
//    private Event appointment;


//    public CancelAppCommand(Index apptIdx) {
//        this.apptIdx = apptIdx;
//        appointment = null;
//    }

    public CancelAppCommand(Event toDelete) {
        requireNonNull(toDelete);
        this.toDelete = toDelete;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasExactEvent(toDelete)) {
            throw new CommandException(String.format(Messages.MESSAGE_EVENT_NOT_FOUND, toDelete));
        }

//        if (model.isPatientInQueue(toDelete.getReferenceId())) {
//            model.removeFromQueue(toDelete.getReferenceId());
//        }
//
//        if (model.isPatientInQueue(toDelete.getReferenceId())) {
//            model.removeFromQueue(toDelete.getReferenceId());
//        }

        model.deleteEvent(toDelete);
        return new CommandResult(String.format(MESSAGE_CANCEL_APPOINTMENT_SUCCESS, toDelete));
//        requireNonNull(model);
//        ObservableList<Event> filterEventList = model.getFilteredEventList();
//
//        if (apptIdx.getZeroBased() >= filterEventList.size()) {
//            throw new CommandException(Messages.MESSAGE_INVALID_APPOINTMENT_DISPLAYED_INDEX);
//        }
//
//        if (!model.isPatientList()) {
//            throw new CommandException(Messages.MESSAGE_NOT_PATIENTLIST);
//        }
//
//        appointment = filterEventList.get(apptIdx.getZeroBased());
//        model.deleteEvent(appointment);
//
//        ContainsKeywordsPredicate predicate = new ContainsKeywordsPredicate(appointment);
//        model.updateFilteredEventList(predicate);
//
//        return new CommandResult(String.format(MESSAGE_CANCEL_APPOINTMENT_SUCCESS, appointment));
    }

    /*
    @Override
    public CommandResult undo(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasEvent(appointment)) {
            throw new CommandException(String.format(MESSAGE_UNDO_ADD_ERROR, appointment));
        }

        model.addEvent(appointment);

        ContainsKeywordsPredicate predicate = new ContainsKeywordsPredicate(appointment);
        model.updateFilteredEventList(predicate);

        return new CommandResult(String.format(MESSAGE_UNDO_ADD_SUCCESS, appointment));
    }
*/
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CancelAppCommand // instanceof handles nulls
                && toDelete.equals(((CancelAppCommand) other).toDelete));
    }
}
