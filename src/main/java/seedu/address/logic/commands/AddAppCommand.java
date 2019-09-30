package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT;


import seedu.address.logic.commands.common.CommandResult;
import seedu.address.logic.commands.common.ReversibleCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.events.Appointment;
import seedu.address.model.events.Event;

/**
 * Adds a person to the address book.
 */
public class AddAppCommand extends ReversibleCommand {

    public static final String COMMAND_WORD = "addappt";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a appointment to the address book. "
            + "Parameters: "
            + PREFIX_ID + "REFERENCE ID "
            + PREFIX_NAME + "PREFIX_NAME "
            + PREFIX_EVENT + "PREFIX_EVENT \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_ID + "001A "
            + PREFIX_NAME + "John Doe "
            + PREFIX_EVENT + "01/01/2001 1900";

    public static final String MESSAGE_SUCCESS = "New appointment added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This appointment already exists in the address book";
    public static final String MESSAGE_wrong_PERSON = "This appointment already exists in the address book";
    public static final String MESSAGE_UNDO_ADD_SUCCESS = "Undo successful! Appointment '%1$s' has been removed.";
    public static final String MESSAGE_UNDO_ADD_ERROR = "Could not undo the addition of appointment: %1$s";

    private final Event appointment;

    /**
     * Creates an AddAppCommand to add the specified {@code Person}
     */
    public AddAppCommand(Event appt) {
        requireNonNull(appt);
        appointment = appt;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasEvent(appointment)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addEvent(appointment);
        return new CommandResult(String.format(MESSAGE_SUCCESS, appointment));
    }

    @Override
    public CommandResult undo(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasEvent(appointment)) {
            throw new CommandException(String.format(MESSAGE_UNDO_ADD_ERROR, appointment));
        }

        model.deleteEvent(appointment);
        return new CommandResult(String.format(MESSAGE_UNDO_ADD_SUCCESS, appointment));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddAppCommand // instanceof handles nulls
                && appointment.equals(((AddAppCommand) other).appointment));
    }
}
