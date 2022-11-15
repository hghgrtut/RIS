package com.kharitonov.flower.controllers;

import com.kharitonov.flower.contracts.ApiRouter;
import com.kharitonov.flower.dtos.BasketDTO;
import com.kharitonov.flower.entities.BasketEntity;
import com.kharitonov.flower.entities.FlowerEntity;
import com.kharitonov.flower.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.BasketFlower.BASE_URL)
public class BasketController {

    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public ResponseEntity<List<BasketDTO>> findAll() {
        List<BasketDTO> basketDTOS = basketService.findAll();
        return ResponseEntity.ok(basketDTOS);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(ApiRouter.BasketFlower.FIND_BY_ID)
    public BasketDTO findById(@PathVariable("id") Long id) {
        return basketService.findById(id);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    public ResponseEntity<BasketDTO> create(@RequestBody Optional<BasketEntity> basketEntity) {
        BasketDTO basketDTO = basketService.save(basketEntity);
        return ResponseEntity.ok(basketDTO);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping(ApiRouter.BasketFlower.UPDATE)
    public ResponseEntity<BasketDTO> update(@PathVariable("id") Optional<BasketEntity> basketEntityFromDB,
                            @RequestBody Optional<BasketEntity> basketEntity) {
        BasketDTO basketDTO = basketService.update(basketEntityFromDB, basketEntity);
        return ResponseEntity.ok(basketDTO);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping(ApiRouter.BasketFlower.ADD_FLOWER)
    public ResponseEntity<BasketDTO> addFlower(@PathVariable("toBasketId") Optional<BasketEntity> basketEntity,
                               @PathVariable("flowerId")Optional<FlowerEntity> flowerEntity) {
        BasketDTO basketDTO = basketService.addFlower(basketEntity, flowerEntity);
        return ResponseEntity.ok(basketDTO);
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping(ApiRouter.BasketFlower.DELETE_BY_ID)
    public void delete(@PathVariable("id") Optional<BasketEntity> basketEntity) {
        basketService.delete(basketEntity);
    }


}
