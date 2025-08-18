package dev.sara.views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import dev.sara.controllers.MomentController;
import dev.sara.models.Emotion;
import dev.sara.models.Moment;
import dev.sara.singletons.MomentControllerSingleton;

public class FilterEmotionViewTest {
    
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private MockedStatic<MomentControllerSingleton> mockedControllerSingleton;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedControllerSingleton = mockStatic(MomentControllerSingleton.class);
    }

    @Test
    void testFilterByEmotion_Option4() {

        MomentController mockController = org.mockito.Mockito.mock(MomentController.class);
        mockedControllerSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

        LocalDate date = LocalDate.of(2025, 8, 13);
        Moment moment = new Moment("Java", "Un día más sobreviviendo", Emotion.ANSIEDAD, date);
        when(mockController.getMomentsByEmotion(Emotion.ANSIEDAD)).thenReturn(List.of(moment));

        String input = "6\n"; 
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View.SCANNER = new java.util.Scanner(System.in);

        FilterEmotionView.filterByEmotion();

        String output = outputStreamCaptor.toString();
        
        assertThat(output, containsString("Seleccione una emoción:"));
      
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        mockedControllerSingleton.close();
    }

}
