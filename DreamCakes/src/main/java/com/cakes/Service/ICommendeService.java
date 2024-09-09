package com.cakes.Service;

import com.cakes.DTO.CommendeDto;
import com.cakes.Model.User;

import java.util.List;

public interface ICommendeService {

    CommendeDto saveCommende(CommendeDto commendeDto, User user);
    List<CommendeDto> getAllCommendes();
    CommendeDto getCommendeById(Long id);
    void deleteCommendeById(Long id);
}
