package com.cakes.Service;

import com.cakes.DTO.CommandeDto;
import com.cakes.Model.User;

import java.util.List;

public interface ICommandeService {

    CommandeDto saveCommende(CommandeDto commandeDto, User user);
    List<CommandeDto> getAllCommendes(Long userId);
    CommandeDto getCommendeById(Long id);
    void deleteCommendeById(Long id);
}
