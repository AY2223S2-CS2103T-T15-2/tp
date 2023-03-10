package seedu.fitbook.logic.commands;

import static seedu.fitbook.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.fitbook.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.Test;

import seedu.fitbook.model.FitBookModel;
import seedu.fitbook.model.FitBookModelManager;

public class ExitCommandTest {
    private FitBookModel model = new FitBookModelManager();
    private FitBookModel expectedFitBookModel = new FitBookModelManager();

    @Test
    public void execute_exit_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true);
        assertCommandSuccess(new ExitCommand(), model, expectedCommandResult, expectedFitBookModel);
    }
}
