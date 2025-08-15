package dev.sara.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mockStatic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class HomeViewTest {

    private final InputStream inputPrintStream = System.in;
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    // Mock estático para la clase MomentPostView
    private MockedStatic<MomentPostView> mockedMomentPostView;
   
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedMomentPostView = mockStatic(MomentPostView.class);
    }

    @Test
    void testPrintMenu_Option1_MomentPostView() {
        
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View.SCANNER = new Scanner(System.in);

        HomeView.printMenu();

        mockedMomentPostView.verify(() -> MomentPostView.printStoreMenu());

        assertThat(outputStreamCaptor.toString(), containsString("Seleccione una opción:"));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(inputPrintStream);
        System.setOut(printStream);
        // Se cierra el mock estático después de cada test
        mockedMomentPostView.close();
        
        // Cierra el scanner para evitar errores en otros tests
        View.SCANNER.close(); 
    }
}
