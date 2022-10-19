package com.example.someMangaLib.controllers;

import com.example.someMangaLib.contracts.ApiRouter;
import com.example.someMangaLib.dtos.TranslateStatusDTO;
import com.example.someMangaLib.entities.TranslateStatusEntity;
import com.example.someMangaLib.servicies.TranslateStatusService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(ApiRouter.TranslateStatusRouter.BASE_URL)
public class TranslateStatusController {

    private final TranslateStatusService translateStatusService;

    @Autowired
    public TranslateStatusController(TranslateStatusService translateStatusService) {
        this.translateStatusService = translateStatusService;
    }

    @GetMapping
    public List<TranslateStatusDTO> getAll() {
        return translateStatusService.findAll();
    }

    @GetMapping(ApiRouter.TranslateStatusRouter.FIND_BY_ID)
    public TranslateStatusDTO findById(@PathVariable("id") Long id) {
        return translateStatusService.findById(id);
    }

    @PostMapping
    public TranslateStatusDTO save(@RequestBody TranslateStatusEntity translateStatus) {
        return translateStatusService.save(translateStatus);
    }

    @DeleteMapping(ApiRouter.TranslateStatusRouter.DELETE)
    public void delete(@PathVariable("id") TranslateStatusEntity translateStatus) {
        translateStatusService.delete(translateStatus);
    }
}
