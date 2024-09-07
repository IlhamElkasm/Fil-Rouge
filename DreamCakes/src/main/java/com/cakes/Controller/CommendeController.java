package com.cakes.Controller;


import com.cakes.DTO.CommendeDto;
import com.cakes.Service.CommendeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/User/commende")
public class CommendeController {

    @Autowired
    private CommendeService commendeService;

    @PostMapping
    public ResponseEntity<CommendeDto> createCommende(@RequestBody CommendeDto commendeDto) {
        CommendeDto savedCommende = commendeService.saveCommende(commendeDto);
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
