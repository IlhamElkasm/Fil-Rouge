package com.cakes.Service;

import com.cakes.DTO.CommandeDto;
import com.cakes.Model.Commande;
import com.cakes.Model.Gateau;
import com.cakes.Model.User;
import com.cakes.Repository.CommendeRepository;
import com.cakes.Repository.GateauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CommandeService implements ICommandeService {

    @Autowired
    private CommendeRepository commendeRepository;

    @Autowired
    private GateauRepository gateauRepository;

    public CommandeDto saveCommende(CommandeDto commandeDto, User user) {
        if (commandeDto.getGateauId() == null) {
            throw new IllegalArgumentException("Gateau ID must not be null");
        }

        Commande commande = new Commande();
        commande.setDateCommende(LocalDate.now());

        Optional<Gateau> gateau = gateauRepository.findById(commandeDto.getGateauId());
        if (gateau.isEmpty()) {
            throw new RuntimeException("Gateau not found");
        }
        commande.setGateau(gateau.get());
        commande.setUser(user);

        Commande savedCommande = commendeRepository.save(commande);

        return convertToDto(savedCommande);
    }

    public List<CommandeDto> getAllCommendes() {
        List<Commande> commandes = commendeRepository.findAll();
        return commandes.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public CommandeDto getCommendeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }

        Commande commande = commendeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commende not found"));
        return convertToDto(commande);
    }

    public void deleteCommendeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        commendeRepository.deleteById(id);
    }

    private CommandeDto convertToDto(Commande commande) {
        return new CommandeDto(
                commande.getIdCommende(),
                commande.getDateCommende(),
                commande.getGateau() != null ? commande.getGateau().getIdGateau() : null
        );
    }
}