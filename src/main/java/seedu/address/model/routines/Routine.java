package seedu.address.model.routines;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Routine in the FitBook.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Routine {

    private final RoutineName routineName;
    private final List<Exercise> exercises = new ArrayList<>();

    /**
     * Constructs a {@code Routine}.
     *
     * @param routineName A valid routine name.
     */
    public Routine(RoutineName routineName, List<Exercise> exercises) {
        requireNonNull(routineName);
        this.exercises.addAll(exercises);
        this.routineName = routineName;
    }

    public RoutineName getRoutineName() {
        return routineName;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    /**
     * Returns true if both routines have the same identity and data fields.
     * This defines a stronger notion of equality between two routines.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Routine)) {
            return false;
        }

        Routine otherRoutine = (Routine) other;
        return otherRoutine.getRoutineName().equals(getRoutineName());
    }

    /**
     * Returns true if both routines have the same name.
     * This defines a weaker notion of equality between two routines.
     */
    public boolean isSameRoutine(Routine otherRoutine) {
        if (otherRoutine == this) {
            return true;
        }

        return otherRoutine != null
                && otherRoutine.getRoutineName().equals(getRoutineName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(routineName);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getRoutineName());
        return builder.toString();
    }
}
