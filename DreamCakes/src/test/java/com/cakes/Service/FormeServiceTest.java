package com.cakes.Service;

import com.cakes.DTO.FormDto;
import com.cakes.Mapper.FormMapper;
import com.cakes.Model.Forme;
import com.cakes.Repository.FormeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FormeServiceTest {


    @InjectMocks
    private FormeService formeService;

    @Mock
    private FormeRepository formeRepository;

    @Mock
    private FormMapper formMapper;

    private Forme forme;
    private FormDto formDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        forme = new Forme();
        forme.setIdShape(1L);
        forme.setName("Rectangle");
        forme.setImage("image.png");
        forme.setDimensions("20x30");
        forme.setPrice(15.0);

        formDto = new FormDto();
        formDto.setIdShape(1L);
        formDto.setName("Rectangle");
        formDto.setImage("image.png");
        formDto.setDimensions("20x30");
        formDto.setPrice(15.0);
    }

    @Test
    void saveForme() {

        when(formMapper.toEntity(formDto)).thenReturn(forme);
        when(formMapper.toDTO(forme)).thenReturn(formDto);
        when(formeRepository.save(forme)).thenReturn(forme);

        FormDto savedFormDto = formeService.saveForme(formDto);

        assertNotNull(savedFormDto);
        assertEquals(formDto.getName(), savedFormDto.getName());
        verify(formeRepository, times(1)).save(forme);
    }

    @Test
    void getFormeById() {

        when(formeRepository.findById(1L)).thenReturn(Optional.of(forme));
        when(formMapper.toDTO(forme)).thenReturn(formDto);

        Optional<FormDto> result = formeService.getFormeById(1L);

        assertTrue(result.isPresent());
        assertEquals("Rectangle", result.get().getName());
        verify(formeRepository, times(1)).findById(1L);
    }

    @Test
    void getAllFormes() {
        List<Forme> formes = Arrays.asList(forme);
        when(formeRepository.findAll()).thenReturn(formes);
        when(formMapper.toDTOList(formes)).thenReturn(Arrays.asList(formDto));

        List<FormDto> result = formeService.getAllFormes();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(formeRepository, times(1)).findAll();
    }

    @Test
    void deleteForme() {

        Long formeId = 1L;
        doNothing().when(formeRepository).deleteById(formeId);

        formeService.deleteForme(formeId);

        verify(formeRepository, times(1)).deleteById(formeId);
    }

    @Test
    void updateForme() {

        when(formeRepository.findById(1L)).thenReturn(Optional.of(forme));
        when(formeRepository.save(any(Forme.class))).thenReturn(forme);

        Optional<FormDto> updatedFormDto = formeService.updateForme(1L, formDto);

        assertTrue(updatedFormDto.isPresent());
        assertEquals(formDto.getName(), updatedFormDto.get().getName());
        verify(formeRepository, times(1)).save(any(Forme.class));
    }
}