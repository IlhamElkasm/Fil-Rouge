package com.cakes.Controller;


import com.cakes.DTO.CommandeDto;
import com.cakes.Model.User;
import com.cakes.Repository.UserRepository;
import com.cakes.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commande")
@CrossOrigin(origins = "http://localhost:4200/")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<CommandeDto> createCommende(@RequestBody CommandeDto commandeDto, @AuthenticationPrincipal User user) {

            User utilisateurVerifie = userRepository
                    .findById(user.getId())
                    .orElseThrow(()-> new RuntimeException("utilisateur not found"));

            CommandeDto savedCommende = commandeService.saveCommende(commandeDto,user);
            return ResponseEntity.ok(savedCommende);

    }


    @GetMapping("/show")
    public ResponseEntity<List<CommandeDto>> getAllCommendes(@AuthenticationPrincipal User user) {
        List<CommandeDto> commendes = commandeService.getAllCommendes(user.getId());
        return ResponseEntity.ok(commendes);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommandeDto>> getAllCommende() {
        List<CommandeDto> commendes = commandeService.getAllCommende();
        return ResponseEntity.ok(commendes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDto> getCommendeById(@PathVariable Long id) {
        CommandeDto commandeDto = commandeService.getCommendeById(id);
        return ResponseEntity.ok(commandeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommendeById(@PathVariable Long id) {
        commandeService.deleteCommendeById(id);
        return ResponseEntity.noContent().build();
    }
}
