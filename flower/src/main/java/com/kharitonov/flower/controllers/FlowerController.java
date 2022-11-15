package com.kharitonov.flower.controllers;

import com.kharitonov.flower.contracts.ApiRouter;
import com.kharitonov.flower.dtos.FlowerDTO;
import com.kharitonov.flower.entities.FlowerEntity;
import com.kharitonov.flower.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.FlowerRouter.BASE_URL)
public class FlowerController {

    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public ResponseEntity<List<FlowerDTO>> getAll() {
        List<FlowerDTO> flowerDTOS = flowerService.findAll();
        return ResponseEntity.ok(flowerDTOS);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(ApiRouter.FlowerRouter.FIND_BY_ID)
    public ResponseEntity<FlowerDTO> findById(@PathVariable("id") Long id) {
        FlowerDTO flowerDTO = flowerService.findById(id);
        return ResponseEntity.ok(flowerDTO);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    public ResponseEntity<FlowerDTO> create(@RequestBody Optional<FlowerEntity> flowerEntity) {
        FlowerDTO flowerDTO = flowerService.save(flowerEntity);
        return ResponseEntity.ok(flowerDTO);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping(ApiRouter.FlowerRouter.UPDATE)
    public ResponseEntity<FlowerDTO> update(@PathVariable("id") Optional<FlowerEntity> flowerEntityFromDB,
                            @RequestBody Optional<FlowerEntity> flowerEntity) {
        FlowerDTO flowerDTO = flowerService.update(flowerEntityFromDB, flowerEntity);
        return ResponseEntity.ok(flowerDTO);
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping(ApiRouter.FlowerRouter.DELETE_BY_ID)
    public void delete(@PathVariable("id") Optional<FlowerEntity> flowerEntity) {
        flowerService.delete(flowerEntity);
    }
}
