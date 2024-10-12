package com.cakes.Service;

import com.cakes.DTO.GateauDto;
import com.cakes.Mapper.GateauMapper;
import com.cakes.Model.Forme;
import com.cakes.Model.Garniture;
import com.cakes.Model.Gateau;
import com.cakes.Model.Saveur;
import com.cakes.Repository.FormeRepository;
import com.cakes.Repository.GarnitureRepository;
import com.cakes.Repository.GateauRepository;
import com.cakes.Repository.SaveurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GateauServiceTest {

    @InjectMocks
    private GateauService gateauService;

    @Mock
    private GateauRepository gateauRepository;

    @Mock
    private GateauMapper gateauMapper;

    @Mock
    private FormeRepository formeRepository;

    @Mock
    private SaveurRepository saveurRepository;

    @Mock
    private GarnitureRepository garnitureRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createGateau() {

        // Création d'un gateauDto m3a ma3lomat
        GateauDto gateauDto = new GateauDto();
        gateauDto.setIdShape(1L);
        gateauDto.setIdFlavor(2L);
        gateauDto.setIdTopping(3L);

        // Mock repositories: Simulons les prix
        Forme forme = new Forme();
        forme.setPrice(100.0);
        when(formeRepository.findById(1L)).thenReturn(Optional.of(forme));

        Saveur saveur = new Saveur();
        saveur.setPrice(50.0);
        when(saveurRepository.findById(2L)).thenReturn(Optional.of(saveur));

        Garniture garniture = new Garniture();
        garniture.setPrice(30.0);
        when(garnitureRepository.findById(3L)).thenReturn(Optional.of(garniture));

        Gateau gateau = new Gateau();
        when(gateauMapper.toEntity(gateauDto)).thenReturn(gateau);
        when(gateauRepository.save(any(Gateau.class))).thenReturn(gateau);

        // Action
        GateauDto result = gateauService.createGateau(gateauDto);

        // Vérifions si le prix est correct
        assertEquals(180.0, gateau.getPrixtotal());

        // Verifier si les repos sont consultés
        verify(formeRepository, times(1)).findById(1L);
        verify(saveurRepository, times(1)).findById(2L);
        verify(garnitureRepository, times(1)).findById(3L);
        verify(gateauRepository, times(1)).save(any(Gateau.class));
    }


    @Test
    void getGateauById() {

        // Données: Créons un gateau
        Gateau gateau = new Gateau();
        gateau.setIdGateau(1L);
        when(gateauRepository.findById(1L)).thenReturn(Optional.of(gateau));

        // Action
        Optional<Gateau> result = gateauService.getGateauById(1L);

        // Vérification: Kat khdmt gateau ID b se7a
        assertEquals(true, result.isPresent());
        assertEquals(1L, result.get().getIdGateau());

        // Vérifier l'interaction avec le repo
        verify(gateauRepository, times(1)).findById(1L);
    }
}