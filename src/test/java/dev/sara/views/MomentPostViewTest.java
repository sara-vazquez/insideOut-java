package dev.sara.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import dev.sara.controllers.MomentController;
import dev.sara.dtos.MomentDTO;
import dev.sara.singletons.MomentControllerSingleton;

public class MomentPostViewTest {
    
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private MockedStatic<MomentControllerSingleton> mockedControllerSingleton;
    private MockedStatic<HomeView> mockedHomeView;
    private MomentController mockController;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        
        mockController = mock(MomentController.class);
        mockedControllerSingleton = mockStatic(MomentControllerSingleton.class);
        mockedControllerSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

        mockedHomeView = mockStatic(HomeView.class);
    }

    @Test
    void testMomentPostView_Option1() {
        String titleInput = "Java\n";
        String dateInput = "13/08/2025\n";
        String descriptionInput = "Llorando\n";
        String emotionInput = "6\n";
        
        String fullInput = titleInput + dateInput + descriptionInput + emotionInput;
        System.setIn(new ByteArrayInputStream(fullInput.getBytes()));
        View.SCANNER = new Scanner(System.in);
        
        MomentPostView.printStoreMenu();
        
        
        verify(mockController).storeMoment(any(MomentDTO.class));
        
        String output = outputStreamCaptor.toString();
        assertThat(output, containsString("Ingrese el título:"));
        assertThat(output, containsString("Ingresa la fecha (dd/mm/year):"));
        assertThat(output, containsString("Ingrese la descripción:"));
        assertThat(output, containsString("Selecciona una emoción:"));
        assertThat(output, containsString("Momento añadido con éxito."));
        
        mockedHomeView.verify(HomeView::printMenu);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        View.SCANNER = new Scanner(System.in);
        mockedControllerSingleton.close();
        mockedHomeView.close();
    }

}
