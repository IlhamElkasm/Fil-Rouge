package com.cakes.Service;

import com.cakes.DTO.CommendeDto;

import java.util.List;

public interface ICommendeService {

    CommendeDto saveCommende(CommendeDto commendeDto);
    List<CommendeDto> getAllCommendes();
    CommendeDto getCommendeById(Long id);
    void deleteCommendeById(Long id);
}
