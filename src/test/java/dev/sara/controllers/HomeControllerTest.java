package dev.sara.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.sara.views.View;

class HomeControllerTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));

        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View.SCANNER = new java.util.Scanner(System.in);
    }

    @Test
    void testHomeController_printsMenu() {
        
        new HomeController();

        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("Seleccione una opción:"));
        assertThat(output, containsString("1. Añadir momento"));
        assertThat(output, containsString("5. Salir"));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
