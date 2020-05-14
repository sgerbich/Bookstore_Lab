import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Utils {
    

    public static void loadStringsToArray(final ArrayList<String> arrList) throws IOException {
        final Path path = Paths.get("C:\\Users\\admin\\Documents\\HW stuff\\JAVA\\day6\\Bookstore_Lab\\Bookfile.txt");
        arrList.clear();

        // The stream file will also be closed here
        try (Stream<String> lines = Files.lines(path)) {
            final Object[] arr = lines.toArray();

            for (final Object t : arr) {
                arrList.add(t.toString());
            }
        }
    }

  
}