package com.cakes.Service;

import com.cakes.DTO.CommendeDto;
import com.cakes.Model.Commende;
import com.cakes.Model.Gateau;
import com.cakes.Model.User;
import com.cakes.Repository.CommendeRepository;
import com.cakes.Repository.GateauRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class CommendeServiceTest {



    @Mock
    private CommendeRepository commendeRepository;

    @Mock
    private GateauRepository gateauRepository;

    @InjectMocks
    private CommendeService commendeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void saveCommende() {

        // Arrange
        CommendeDto commendeDto = new CommendeDto();
        commendeDto.setGateauId(1L);

        User user = new User();

        Gateau gateau = new Gateau();
        gateau.setIdGateau(1L);

        when(gateauRepository.findById(1L)).thenReturn(Optional.of(gateau));
        when(commendeRepository.save(any(Commende.class))).thenAnswer(invocation -> {
            Commende savedCommende = invocation.getArgument(0);
            savedCommende.setIdCommende(1L);
            return savedCommende;
        });

        // Act
        CommendeDto savedCommendeDto = commendeService.saveCommende(commendeDto, user);

        // Assert
        assertNotNull(savedCommendeDto);
        assertEquals(1L, savedCommendeDto.getGateauId());
        assertEquals(1L, savedCommendeDto.getIdCommende());
        verify(gateauRepository, times(1)).findById(1L);
        verify(commendeRepository, times(1)).save(any(Commende.class));
    }

    @Test
    void getAllCommendes() {
    }

    @Test
    void getCommendeById() {
    }

    @Test
    void deleteCommendeById() {
    }
}