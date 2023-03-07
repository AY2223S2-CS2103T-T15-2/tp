package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.FitBook;
import seedu.address.model.ReadOnlyFitBook;
import seedu.address.model.client.Address;
import seedu.address.model.client.Appointment;
import seedu.address.model.client.Client;
import seedu.address.model.client.Email;
import seedu.address.model.client.Gender;
import seedu.address.model.client.Goal;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.client.Weight;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code FitBook} with sample data.
 */
public class SampleDataUtil {

    public static Client[] getSampleClients() {
        return new Client[] {
            new Client(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), getAppointmentSet("12-12-2019"),
                new Weight("20"), new Gender("M"), new Goal("lose weight"), getTagSet("friends")),
            new Client(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), getAppointmentSet("12-12-2019"),
                new Weight("20"), new Gender("M"), new Goal("lose weight"), getTagSet("colleagues", "friends")),
            new Client(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), getAppointmentSet("12-12-2019"),
                new Weight("30"), new Gender("M"), new Goal("lose weight"), getTagSet("neighbours")),
            new Client(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), getAppointmentSet("12-12-2019"),
                new Weight("40"), new Gender("M"), new Goal("lose weight"), getTagSet("family")),
            new Client(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), getAppointmentSet("12-12-2019"),
                new Weight("50"), new Gender("M"), new Goal("lose weight"), getTagSet("classmates")),
            new Client(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), getAppointmentSet("12-12-2019"),
                new Weight("60"), new Gender("M"), new Goal("lose weight"), getTagSet("colleagues"))
        };
    }

    public static ReadOnlyFitBook getSampleFitBook() {
        FitBook sampleAb = new FitBook();
        for (Client sampleClient : getSampleClients()) {
            sampleAb.addClient(sampleClient);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns an appointment set containing the list of strings given.
     */
    public static Set<Appointment> getAppointmentSet(String... strings) {
        return Arrays.stream(strings)
                .map(Appointment::new)
                .collect(Collectors.toSet());
    }
}
