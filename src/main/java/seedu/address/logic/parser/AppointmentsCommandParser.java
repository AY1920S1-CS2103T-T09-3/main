package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_REFERENCEID;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.Arrays;
import java.util.stream.Stream;

import seedu.address.logic.commands.AckAppCommand;
import seedu.address.logic.commands.AddAppCommand;
import seedu.address.logic.commands.AppointmentsCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.common.ReferenceId;
import seedu.address.model.events.ContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class AppointmentsCommandParser implements Parser<AppointmentsCommand> {
    private Model model;

    public AppointmentsCommandParser(Model model) {
        this.model = model;
    }
    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AppointmentsCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        if (args.trim().isEmpty()) {
            return new AppointmentsCommand();
        } else {
            ReferenceId referenceId = ParserUtil.parsePatientReferenceId(argMultimap.getPreamble());

            if (!model.hasPerson(referenceId)) {
                throw new ParseException(String.format(MESSAGE_INVALID_REFERENCEID, AddAppCommand.MESSAGE_USAGE));
            }

            return new AppointmentsCommand(referenceId);
        }

    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
