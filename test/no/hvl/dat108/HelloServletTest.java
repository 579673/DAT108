package no.hvl.dat108;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloServletTest {

    @Test
    public void chooseLanguageTest() {
        assertEquals("Hello", HelloServlet.chooseLanguage("en"));
    }
}