//package com.example.vacationplanner;
//
//import com.example.vacationplanner.model.Vacation;
//import com.example.vacationplanner.repository.VacationRepository;
//import com.example.vacationplanner.service.VacationService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
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
//public class VacationServiceTest {
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
//    @Test
//    void testGetAllVacations() {
//        when(vacationRepository.findAll()).thenReturn(Arrays.asList(vacation1, vacation2));
//
//        List<Vacation> vacations = vacationService.getAllVacations();
//        assertEquals(2, vacations.size());
//        assertEquals("Beach Vacation", vacations.get(0).getTitle());
//    }
//
//    @Test
//    void testGetVacationById() {
//        when(vacationRepository.findById(1L)).thenReturn(Optional.of(vacation1));
//
//        Vacation found = vacationService.getVacationById(1L).orElseThrow();
//        assertEquals("Beach Vacation", found.getTitle());
//    }
//
//    @Test
//    void testCreateVacation() {
//        when(vacationRepository.save(vacation1)).thenReturn(vacation1);
//
//        Vacation created = vacationService.createVacation(vacation1);
//        assertEquals("Beach Vacation", created.getTitle());
//    }
//
//    @Test
//    void testDeleteVacation() {
//        doNothing().when(vacationRepository).deleteById(1L);
//
//        assertDoesNotThrow(() -> vacationService.deleteVacation(1L));
//        verify(vacationRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    void testUpdateVacation() {
//        when(vacationRepository.findById(1L)).thenReturn(Optional.of(vacation1));
//        when(vacationRepository.save(any(Vacation.class))).thenReturn(vacation1);
//
//        Vacation updatedVacation = new Vacation(1L, "Updated Beach Vacation", "Updated Hotel", "2024-12-01", "2024-12-10", "Updated Hawaii");
//        Vacation result = vacationService.updateVacation(1L, updatedVacation);
//
//        assertEquals("Updated Beach Vacation", result.getTitle());
//        assertEquals("Updated Hotel", result.getHotel());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"Beach", "Mountain"})
//    void testSearchVacations(String keyword) {
//        when(vacationRepository.findByTitleContaining(keyword)).thenReturn(Arrays.asList(vacation1));
//
//        List<Vacation> foundVacations = vacationService.searchVacations(keyword);
//        assertFalse(foundVacations.isEmpty());
//    }
//}
