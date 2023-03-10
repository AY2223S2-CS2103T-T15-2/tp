package seedu.fitbook.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.fitbook.model.FitBook;
import seedu.fitbook.model.FitBookModel;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute(FitBookModel model) {
        requireNonNull(model);
        model.setFitBook(new FitBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
