package dev.sara.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeViewTest {

    private final InputStream inputPrintStream = System.in;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrintMenu_SelectOption1() {
        
        String momentTitleRequest = "Ingrese el título:";
        String momentDateRequest = "Ingrese la fecha (dd/mm/year):";
        String momentDescriptionRequest = "Ingrese la descripción";
        String emotionNumberRequest = "Selecciona la emoción:";

        String inputSimulated = String.join("\n",
                "1",
                "Sufriendo con java",
                "13/08/2025",
                "Un día más que aguanto sin llorar :)",
                "4"
        );
        System.setIn(new ByteArrayInputStream(inputSimulated.getBytes()));

        HomeView.printMenu();

        String exit = outputStreamCaptor.toString();

        assertThat(exit, containsString(momentTitleRequest));
        assertThat(exit, containsString(momentDateRequest));
        assertThat(exit, containsString(momentDescriptionRequest));
        assertThat(exit, containsString(emotionNumberRequest));
    }

    @AfterEach
    void tearDown() {
        System.setIn(inputPrintStream);
        System.setOut(printStream);
    }
}
