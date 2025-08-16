package dev.sara.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import dev.sara.controllers.MomentController;
import dev.sara.models.Emotion;
import dev.sara.models.Moment;
import dev.sara.singletons.MomentControllerSingleton;

public class FilterDateViewTest {
    
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream outputCaptor;

    private MockedStatic<MomentControllerSingleton> mockedSingleton;
    private MomentController mockController;

    @BeforeEach
    void setUp() {
        outputCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputCaptor));

        mockController = mock(MomentController.class);
        mockedSingleton = mockStatic(MomentControllerSingleton.class);
        mockedSingleton.when(MomentControllerSingleton::getInstance).thenReturn(mockController);

        View.SCANNER = new java.util.Scanner(System.in);
    }

    @Test
    void testFilterByDate_Option4() {

        LocalDate date = LocalDate.of(2025, 8, 13);
        Moment testMoment = new Moment("Java", "Un día más sobreviviendo", Emotion.ANSIEDAD, date);

        when(mockController.getMomentsByDate(8, 2025)).thenReturn(List.of(testMoment));

        String input = "8\n2025\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        View.SCANNER = new java.util.Scanner(System.in);

        List<Moment> result = FilterDateView.filterByDate();

        assertThat(outputCaptor.toString(), containsString("Ingresa el mes:"));
        assertThat(outputCaptor.toString(), containsString("Ingresa el año:"));
        assertThat(outputCaptor.toString(), containsString("Lista de momentos vividos:"));
        assertThat(result.size(), org.hamcrest.Matchers.is(1));
        assertThat(result.get(0).getMomentTitle(), org.hamcrest.Matchers.is("Java"));
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
        mockedSingleton.close();
        View.SCANNER.close();
    }
}
