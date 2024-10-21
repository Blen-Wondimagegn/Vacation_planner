//package com.example.vacationplanner;
//
//import com.example.vacationplanner.model.Vacation;
//import com.example.vacationplanner.repository.VacationRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@DataJdbcTest
//public class VacationRepositoryTest {
//
//    @Autowired
//    private VacationRepository vacationRepository;
//
//    @MockBean
//    private Vacation vacation1;
//
//    @MockBean
//    private Vacation vacation2;
//
//    @BeforeEach
//    void setUp() {
//        vacation1 = new Vacation(1L, "Beach Vacation", "Hotel Paradise", "2024-10-01", "2024-10-10", "Hawaii");
//        vacation2 = new Vacation(2L, "Mountain Adventure", "Mountain Lodge", "2024-11-01", "2024-11-10", "Alps");
//    }
//
//    @Test
//    void testFindByTitleContaining() {
//        // Mock the repository response
//        when(vacationRepository.findByTitleContaining("Beach")).thenReturn(Arrays.asList(vacation1));
//
//        // Call the method and verify the result
//        List<Vacation> foundVacations = vacationRepository.findByTitleContaining("Beach");
//        assertEquals(1, foundVacations.size());
//        assertEquals("Beach Vacation", foundVacations.get(0).getTitle());
//    }
//
//    @Test
//    void testFindByTitleContaining_NoResults() {
//        // Mock the repository response
//        when(vacationRepository.findByTitleContaining("Safari")).thenReturn(Arrays.asList());
//
//        // Call the method and verify the result
//        List<Vacation> foundVacations = vacationRepository.findByTitleContaining("Safari");
//        assertEquals(0, foundVacations.size());
//    }
//}
