package seedu.fitbook.storage.routine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.fitbook.commons.exceptions.IllegalValueException;
import seedu.fitbook.model.routines.Exercise;
import seedu.fitbook.model.routines.Routine;
import seedu.fitbook.model.routines.RoutineName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Jackson-friendly version of {@link Routine}.
 */
class JsonAdaptedRoutine {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Routine's %s field is missing!";

    private final String routineName;
    private final List<JsonAdaptedExercise> exercises = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedRoutine} with the given routine details.
     */
    @JsonCreator
    public JsonAdaptedRoutine(@JsonProperty("routine") String routineName,
            @JsonProperty("exercises") List<JsonAdaptedExercise> exercises) {
        this.routineName = routineName;
        if (exercises != null) {
            this.exercises.addAll(exercises);
        }
    }

    /**
     * Converts a given {@code Routine} into this class for Jackson use.
     */
    public JsonAdaptedRoutine(Routine source) {
        routineName = source.getRoutineName().routineName;
        exercises.addAll(source.getExercises().stream()
                .map(JsonAdaptedExercise::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted routine object into the model's {@code Routine} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted routine.
     */
    public Routine toFitBookExerciseRoutineModelType() throws IllegalValueException {
        final List<Exercise> routineExercises = new ArrayList<>();
        for (JsonAdaptedExercise exercise : exercises) {
            routineExercises.add(exercise.toFitBookExerciseRoutineModelType());
        }
        final Set<Exercise> modelExercise = new HashSet<>(routineExercises);
        if (routineName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    RoutineName.class.getSimpleName()));
        }
        if (!RoutineName.isValidRoutineName(routineName)) {
            throw new IllegalValueException(RoutineName.MESSAGE_CONSTRAINTS);
        }
        final RoutineName modelRoutineName = new RoutineName(routineName);
        final Set<Exercise> modelRoutineExercises = new HashSet<>(routineExercises);
        return new Routine(modelRoutineName, modelRoutineExercises);
    }

}
