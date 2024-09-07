package com.cakes.Service;

import com.cakes.DTO.CommendeDto;
import com.cakes.Mapper.CommendeMapper;
import com.cakes.Model.Commende;
import com.cakes.Repository.CommendeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommendeService implements  ICommendeService{


    @Autowired
    private CommendeRepository commendeRepository;

    @Autowired
    private CommendeMapper commendeMapper;

    public CommendeDto saveCommende(CommendeDto commendeDto) {
        Commende commende = commendeMapper.toEntity(commendeDto);
        Commende savedCommende = commendeRepository.save(commende);
        return commendeMapper.toDTO(savedCommende);
    }

    public List<CommendeDto> getAllCommendes() {
        List<Commende> commendes = commendeRepository.findAll();
        return commendes.stream().map(commendeMapper::toDTO).collect(Collectors.toList());
    }

    public CommendeDto getCommendeById(Long id) {
        Commende commende = commendeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commende not found"));
        return commendeMapper.toDTO(commende);
    }

    public void deleteCommendeById(Long id) {
        commendeRepository.deleteById(id);
    }
}
