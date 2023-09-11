import java.util.ArrayList;
import java.util.List;

public class Codec {
    private static final char DELIMITER = '\n'; // Delimiter character
    private static final char ESCAPE_CHAR = '\\';

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String str : strs) {
            for (char c : str.toCharArray()) {
                if (c == DELIMITER || c == ESCAPE_CHAR) {
                    // Escape the delimiter and backslash characters
                    encodedString.append(ESCAPE_CHAR);
                }
                encodedString.append(c);
            }
            encodedString.append(DELIMITER);
        }

        return encodedString.toString();
    }

    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        boolean escaped = false;

        for (char c : s.toCharArray()) {
            if (escaped) {
                currentString.append(c);
                escaped = false;
            } else if (c == ESCAPE_CHAR) {
                escaped = true;
            } else if (c == DELIMITER) {
                decodedStrings.add(currentString.toString());
                currentString = new StringBuilder();
            } else {
                currentString.append(c);
            }
        }

        // Add the last string (if any) after reaching the end of the input
        if (currentString.length() > 0) {
            decodedStrings.add(currentString.toString());
        }

        return decodedStrings;
    }
}

