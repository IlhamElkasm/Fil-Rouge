package com.cakes.Service;

import com.cakes.DTO.FormDto;
import com.cakes.Model.Forme;

import java.util.List;
import java.util.Optional;

public interface IFormeService {
    FormDto saveForme(FormDto formDto);
    Optional<FormDto> getFormeById(Long id);
    List<FormDto> getAllFormes();
    Optional<FormDto> updateForme(Long id, FormDto formDto);
    void deleteForme(Long id);
}
