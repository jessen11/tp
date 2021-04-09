package seedu.dictionote.testutil;

import seedu.dictionote.model.Dictionary;
import seedu.dictionote.model.dictionary.DisplayableContent;
import seedu.dictionote.model.note.Note;
import seedu.dictionote.ui.DictionaryContentConfig;
import seedu.dictionote.ui.NoteContentConfig;

/**
 * A utility class containing a arrau of {@code UiActionOption} objects to be used in tests.
 */
public class TypicalDictionaryContentConfig {


    public static DictionaryContentConfig getTypicalDictionaryContentConfig() {
        return new EmptyDictionaryContentConfig();
    }


    /**
     * A stub for note content config for failure test
     */
    private static class EmptyDictionaryContentConfig implements DictionaryContentConfig {
        @Override
        public void setDisplayContent(DisplayableContent displayableContent) {

        }

        @Override
        public boolean isContentVisible() {
            return false;
        }

        @Override
        public void openContentDisplay() {

        }

        @Override
        public void openDefinitionDisplay() {

        }
    }
}
