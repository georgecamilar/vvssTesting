package tasks.services;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {

    private String stringTime;
    private TasksService tasksService;

    @BeforeEach
    void setUp() {
        tasksService = null;
        stringTime = "17:23";
    }

    @Tag("ECP")
    @Disabled
    @Test
    void addECPValid1() {
        try {
            tasksService.parseFromStringToSeconds("11:24");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("ECP")
    @RepeatedTest(3)
    void addECPValid2() {
        try {
            tasksService.parseFromStringToSeconds("01:59");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("ECP")
    @DisplayName("Test ECP pentru metoda parseFromStringToSeconds")
    @Test
    void addECPNonValid3() {
        try {
            tasksService.parseFromStringToSeconds("12:34:56");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("ECP")
    @Timeout(1000)
    @Test
    void addECPNonValid4(){
        try {
            tasksService.parseFromStringToSeconds("0907");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("ECP")
    @RepeatedTest(5)
    @Test
    void addECPNonValid5(){
        try {
            tasksService.parseFromStringToSeconds("10:4b");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("BVA")
    @Test
    void addBVAValid1() {
        try {
            tasksService.parseFromStringToSeconds("00:00");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("BVA")
    @Timeout(1000)
    @Disabled
    @Test
    void addBVAValid2() {
        try {
            tasksService.parseFromStringToSeconds("23:59");
            assert(true);
        } catch (Exception e) {
            assert(false);
        }
    }

    @Tag("BVA")
    @DisplayName("Test BVA pentru metoda parseFromStringToSeconds")
    @Test
    void addBVANonValid3() {
        try {
            tasksService.parseFromStringToSeconds("30:00");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }

    @Tag("BVA")
    @RepeatedTest(10)
    @Test
    void addBVANonValid4() {
        try {
            tasksService.parseFromStringToSeconds("23:60");
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }
}