//@@author SakuraBlossom
package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.common.Command;
import seedu.address.logic.commands.common.CommandHistoryManager;
import seedu.address.logic.commands.common.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Redoes the action of an {@code UndoableCommand} command.
 */
public class RedoCommand implements Command {

    public static final String COMMAND_WORD = "redo";
    private final CommandHistoryManager history;

    public RedoCommand(CommandHistoryManager history) {
        requireNonNull(history);
        this.history = history;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return history.performRedo(model);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || other instanceof RedoCommand; // instanceof handles nulls
    }
}
