//package com.example.vacationplanner;
//
//import com.example.vacationplanner.model.Vacation;
//import com.example.vacationplanner.repository.VacationRepository;
//import com.example.vacationplanner.service.VacationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class VacationServiceParameterizedTest {
//
//    @Mock
//    private VacationRepository vacationRepository;
//
//    @InjectMocks
//    private VacationService vacationService;
//
//    private Vacation vacation1;
//    private Vacation vacation2;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        vacation1 = new Vacation(1L, "Beach Vacation", "Hotel Paradise", "2024-10-01", "2024-10-10", "Hawaii");
//        vacation2 = new Vacation(2L, "Mountain Adventure", "Mountain Lodge", "2024-11-01", "2024-11-10", "Alps");
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "Beach, 1",
//            "Mountain, 1",
//            "Vacation, 2",
//            "Adventure, 1",
//            "Nonexistent, 0"  // Test for a keyword that doesn't match any vacation
//    })
//    void testSearchVacations(String keyword, int expectedCount) {
//        // Setup mock behavior
//        if (keyword.contains("Beach") || keyword.contains("Mountain") || keyword.contains("Vacation") || keyword.contains("Adventure")) {
//            when(vacationRepository.findByTitleContaining(keyword)).thenReturn(Arrays.asList(vacation1, vacation2));
//        } else {
//            when(vacationRepository.findByTitleContaining(keyword)).thenReturn(Arrays.asList());
//        }
//
//        // Perform the search operation
//        List<Vacation> foundVacations = vacationService.searchVacations(keyword);
//
//        // Assert the expected number of results
//        assertEquals(expectedCount, foundVacations.size());
//    }
//}
