package seedu.address.logic.commands;

import java.io.FileNotFoundException;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FitBookModel;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code FitBookModel} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute(FitBookModel model) throws CommandException, FileNotFoundException;

}
