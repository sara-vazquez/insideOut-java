package dev.sara.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;

import dev.sara.controllers.MomentController;
import dev.sara.singletons.MomentControllerSingleton;

public class MomentDeleteViewTest {
    
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private MockedStatic<MomentControllerSingleton> mockedControllerSingleton;
    private MockedStatic<HomeView> mockedHomeView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedControllerSingleton = mockStatic(MomentControllerSingleton.class);
        mockedHomeView = mockStatic(HomeView.class);
    }

    @Test
    void testDeleteMoment_Option3() {
        
        MomentController mockController = mock(MomentController.class);
        mockedControllerSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

        String inputId = "1\n";
        System.setIn(new ByteArrayInputStream(inputId.getBytes()));
        View.SCANNER = new Scanner(System.in); 

    
        MomentDeleteView.printDeleteMoment();

        verify(mockController).deleteMoment(1); 

        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("Ingrese el identificador del momento:"));
        assertThat(output, containsString("Momento vivido eliminado correctamente"));

        mockedHomeView.verify(() -> HomeView.printMenu());
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        mockedControllerSingleton.close();
        mockedHomeView.close();
        View.SCANNER.close(); 
    }
}
