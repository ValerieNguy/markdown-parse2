import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MarkdownParseTest {
    @Test
    public void testEmpty() throws IOException {
        assertLinks(List.of(), "testCases/empty.md");
    }

    @Test
    public void testExtraSpace() throws IOException {
        assertLinks(List.of(), "testCases/extraSpace.md");
    }

    @Test
    public void testEscape() throws IOException {
        assertLinks(List.of("https://somethingelse.com"), "testCases/escape.md");
    }

    @Test
    public void testJustEscape() throws IOException {
        assertLinks(List.of(), "testCases/justEscape.md");
    }

    @Test
    public void testImage() throws IOException {
        assertLinks(List.of(), "testCases/image.md");
    }

    @Test
    public void testJustBrackets() throws IOException {
        assertLinks(List.of(), "testCases/justBrackets.md");
    }

    @Test
    public void testJustParentheses() throws IOException {
        assertLinks(List.of(), "testCases/justParentheses.md");
    }

    @Test
    public void testMultiline() throws IOException {
        assertLinks(List.of("https://isthisfound.com"), "testCases/multiline.md");
    }

    @Test
    public void testLastLine() throws IOException {
        assertLinks(List.of("last line link should be found"), "testCases/lastLine.md");
    } 

    /*
    @Test
    public void testBackticks() {
        String fileName = "snippet1.md";
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");

        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNested() {
        String fileName = "snippet2.md";
        List<String> expected = List.of("a.com", "a.com(())", "example.com");

        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLongText() {
        String fileName = "snippet3.md";
        List<String> expected = List.of("https://ucsd-cse15l-w22.github.io/");

        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    public static void assertLinks(List<String> expectedLinks, String fileName) throws IOException {
        Path filePath = Path.of(fileName);
        String contents = Files.readString(filePath);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(expectedLinks, links);
    }
}
