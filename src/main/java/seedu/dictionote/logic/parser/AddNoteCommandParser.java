package seedu.dictionote.logic.parser;

import seedu.dictionote.logic.commands.AddCommand;
import seedu.dictionote.logic.commands.AddNoteCommand;
import seedu.dictionote.logic.parser.exceptions.ParseException;
import seedu.dictionote.model.note.Note;
import seedu.dictionote.model.person.Address;
import seedu.dictionote.model.person.Email;
import seedu.dictionote.model.person.Name;
import seedu.dictionote.model.person.Person;
import seedu.dictionote.model.person.Phone;
import seedu.dictionote.model.tag.Tag;

import java.util.Set;
import java.util.stream.Stream;

import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_CONTENT;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.dictionote.logic.parser.CliSyntax.PREFIX_TAG;

public class AddNoteCommandParser implements Parser<AddNoteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddNoteCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_CONTENT);

        if (!arePrefixesPresent(argMultimap, PREFIX_CONTENT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddNoteCommand.MESSAGE_USAGE));
        }

        String noteContent = ParserUtil.parseNote(argMultimap.getValue(PREFIX_CONTENT).get());

        Note note = new Note(noteContent);

        return new AddNoteCommand(note);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
