package dev.sara.views;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mockStatic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import dev.sara.dtos.MomentDTOResponse;
import dev.sara.models.Emotion;

public class MomentGetViewTest {
    
    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private MockedStatic<HomeView> mockedHomeView;
   
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        mockedHomeView = mockStatic(HomeView.class);
    }

    @Test
    void testViewAllMoments_Option2_MomentGetView() {

       LocalDate date = LocalDate.of(2025, 8, 13);
        MomentDTOResponse moment = new MomentDTOResponse(1, "Java", "Un día más sobreviviendo", Emotion.ANSIEDAD, date);

        MomentGetView.viewAllMoments(List.of(moment));

        String output = outputStreamCaptor.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expectedDate = date.format(formatter);

        assertThat(output, containsString("Lista de momentos vividos:"));
        assertThat(output, containsString("1. Ocurrió el: " + expectedDate));
        assertThat(output, containsString("Título: Java"));
        assertThat(output, containsString("Descripción: Un día más sobreviviendo"));
        assertThat(output, containsString("Emoción: ANSIEDAD"));
       
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
        mockedHomeView.close();
    }
}
