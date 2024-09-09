package com.cakes.Controller;


import com.cakes.DTO.CommendeDto;
import com.cakes.Model.User;
import com.cakes.Repository.UserRepository;
import com.cakes.Service.CommendeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/User/commende")
public class CommendeController {

    @Autowired
    private CommendeService commendeService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<CommendeDto> createCommende(@RequestBody CommendeDto commendeDto,@AuthenticationPrincipal User user) {

            User utilisateurVerifie = userRepository
                    .findById(user.getId())
                    .orElseThrow(()-> new RuntimeException("utilisateur not found"));

            CommendeDto savedCommende = commendeService.saveCommende(commendeDto,user);
            return ResponseEntity.ok(savedCommende);

    }


    @GetMapping
    public ResponseEntity<List<CommendeDto>> getAllCommendes() {
        List<CommendeDto> commendes = commendeService.getAllCommendes();
        return ResponseEntity.ok(commendes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommendeDto> getCommendeById(@PathVariable Long id) {
        CommendeDto commendeDto = commendeService.getCommendeById(id);
        return ResponseEntity.ok(commendeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommendeById(@PathVariable Long id) {
        commendeService.deleteCommendeById(id);
        return ResponseEntity.noContent().build();
    }
}
