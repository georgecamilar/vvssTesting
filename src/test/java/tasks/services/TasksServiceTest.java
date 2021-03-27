package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {

    private String stringTime;
    private TasksService tasksService;

    @BeforeEach
    void setUp() {
        tasksService = null;
        stringTime = "17:23";
    }

    // Teste pentru parametrul time
    @DisplayName("Test pentru metoda parseFromStringToSeconds")
    @Test
    void addECPNonValid1() {
        try {
            tasksService.parseFromStringToSeconds("12:34:56");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void parseFromStringToSeconds() {
        assert tasksService.parseFromStringToSeconds(stringTime) == 62580;
        stringTime = "a3:40";
        try {
            tasksService.parseFromStringToSeconds(stringTime);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}