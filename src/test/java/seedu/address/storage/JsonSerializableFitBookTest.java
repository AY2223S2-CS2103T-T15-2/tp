package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.FitBook;
import seedu.address.testutil.client.TypicalClients;

public class JsonSerializableFitBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableFitBookTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalClientsFitBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidRoutineFitBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicateRoutineFitBook.json");

    @Test
    public void toFitBookModelType_typicalClientsFile_success() throws Exception {
        JsonSerializableFitBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableFitBook.class).get();
        FitBook fitBookFromFile = dataFromFile.toFitBookModelType();
        FitBook typicalClientsFitBook = TypicalClients.getTypicalFitBook();
        assertEquals(fitBookFromFile, typicalClientsFitBook);
    }

    @Test
    public void toFitBookModelType_invalidClientFile_throwsIllegalValueException() throws Exception {
        JsonSerializableFitBook dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableFitBook.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toFitBookModelType);
    }

    @Test
    public void toFitBookModelType_duplicateClients_throwsIllegalValueException() throws Exception {
        JsonSerializableFitBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableFitBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableFitBook.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toFitBookModelType);
    }

}
