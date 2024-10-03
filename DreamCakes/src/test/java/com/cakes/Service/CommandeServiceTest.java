package com.cakes.Service;

import com.cakes.DTO.CommandeDto;
import com.cakes.Model.Commande;
import com.cakes.Model.Gateau;
import com.cakes.Model.User;
import com.cakes.Repository.CommendeRepository;
import com.cakes.Repository.GateauRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class CommandeServiceTest {



    @Mock
    private CommendeRepository commendeRepository;

    @Mock
    private GateauRepository gateauRepository;

    @InjectMocks
    private CommandeService commandeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void saveCommende() {

        // Arrange
        CommandeDto commandeDto = new CommandeDto();
        commandeDto.setGateauId(1L);

        User user = new User();

        Gateau gateau = new Gateau();
        gateau.setIdGateau(1L);

        when(gateauRepository.findById(1L)).thenReturn(Optional.of(gateau));
        when(commendeRepository.save(any(Commande.class))).thenAnswer(invocation -> {
            Commande savedCommande = invocation.getArgument(0);
            savedCommande.setIdCommende(1L);
            return savedCommande;
        });

        // Act
        CommandeDto savedCommandeDto = commandeService.saveCommende(commandeDto, user);

        // Assert
        assertNotNull(savedCommandeDto);
        assertEquals(1L, savedCommandeDto.getGateauId());
        assertEquals(1L, savedCommandeDto.getIdCommende());
        verify(gateauRepository, times(1)).findById(1L);
        verify(commendeRepository, times(1)).save(any(Commande.class));
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