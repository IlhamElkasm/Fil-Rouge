package com.cakes.Service;

import com.cakes.DTO.CommendeDto;
import com.cakes.Model.Commende;
import com.cakes.Model.Gateau;
import com.cakes.Repository.CommendeRepository;
import com.cakes.Repository.GateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CommendeService implements ICommendeService {

    @Autowired
    private CommendeRepository commendeRepository;

    @Autowired
    private GateauRepository gateauRepository;

    public CommendeDto saveCommende(CommendeDto commendeDto) {
        if (commendeDto.getGateauId() == null) {
            throw new IllegalArgumentException("Gateau ID must not be null");
        }

        Commende commende = new Commende();
        commende.setDateCommende(LocalDate.now());

        Optional<Gateau> gateau = gateauRepository.findById(commendeDto.getGateauId());
        if (gateau.isEmpty()) {
            throw new RuntimeException("Gateau not found");
        }
        commende.setGateau(gateau.get());

        Commende savedCommende = commendeRepository.save(commende);

        return convertToDto(savedCommende);
    }

    public List<CommendeDto> getAllCommendes() {
        List<Commende> commendes = commendeRepository.findAll();
        return commendes.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public CommendeDto getCommendeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }

        Commende commende = commendeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commende not found"));
        return convertToDto(commende);
    }

    public void deleteCommendeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        commendeRepository.deleteById(id);
    }

    private CommendeDto convertToDto(Commende commende) {
        return new CommendeDto(
                commende.getIdCommende(),
                commende.getDateCommende(),
                commende.getGateau() != null ? commende.getGateau().getIdGateau() : null
        );
    }
}