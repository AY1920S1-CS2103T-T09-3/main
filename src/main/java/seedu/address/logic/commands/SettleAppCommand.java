package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.common.CommandResult;
import seedu.address.logic.commands.common.ReversibleCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.events.*;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * mark a appointment's status as SETTLED for a patient.
 */
public class SettleAppCommand extends ReversibleCommand {
    public static final String COMMAND_WORD = "settleAppt";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": change the appointment date "
            + "by the index number used in the displayed patient's list. "
            + "Existing date will be overwritten by the input date.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_START + "PREFIX_EVENT "
            + PREFIX_END + "PREFIX_EVENT \n"
            + "[" + PREFIX_TAG + "TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_START + "01/11/19 1800 "
            + PREFIX_END + "01/11/19 1900";

    private final Index apptIdx;
    private Event oldAppt;
    private Event newAppt;

    public static final String MESSAGE_CANCEL_APPOINTMENT_SUCCESS = "Appointment cancelled: %1$s";
    public static final String MESSAGE_UNDO_ADD_SUCCESS = "Undo successful! Person '%1$s' has been removed.";
    public static final String MESSAGE_UNDO_ADD_ERROR = "Could not undo the addition of person: %1$s";

    public SettleAppCommand(Index index) {
        this.apptIdx = index;
        oldAppt = null;
        newAppt = null;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Event> filterEventList = model.getFilteredEventList();

        if (apptIdx.getZeroBased() >= filterEventList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_APPOINTMENT_DISPLAYED_INDEX);
        }

        if (!model.isMissedList()) {
            throw new CommandException(Messages.MESSAGE_NOT_MISSEDLIST);
        }

        oldAppt = filterEventList.get(apptIdx.getZeroBased());
        newAppt = new Appointment(oldAppt.getPersonId(), oldAppt.getEventTiming(), new Status(Status.AppointmentStatuses.SETTLED));

        if(model.hasEvent(newAppt)){
            throw new CommandException(Messages.MESSAGE_DUPLICATE_SETTLE);
        }

        model.setEvent(oldAppt, newAppt);

        model.updateToMissedEventList();

        return new CommandResult(String.format(MESSAGE_CANCEL_APPOINTMENT_SUCCESS, newAppt));
    }

    @Override
    public CommandResult undo(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasEvent(oldAppt)) {
            throw new CommandException(String.format(MESSAGE_UNDO_ADD_ERROR, oldAppt));
        }

        model.setEvent(newAppt, oldAppt);
        model.updateToMissedEventList();

        return new CommandResult(String.format(MESSAGE_UNDO_ADD_SUCCESS, oldAppt));
    }
}
