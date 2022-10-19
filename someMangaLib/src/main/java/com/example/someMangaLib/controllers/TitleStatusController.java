package com.example.someMangaLib.controllers;

import com.example.someMangaLib.contracts.ApiRouter;
import com.example.someMangaLib.dtos.TitleStatusDTO;
import com.example.someMangaLib.entities.TitleStatusEntity;
import com.example.someMangaLib.servicies.TitleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(ApiRouter.TitleStatusRouter.BASE_URL)
public class TitleStatusController {

    private final TitleStatusService titleStatusService;

    @Autowired
    public TitleStatusController(TitleStatusService titleStatusService) {
        this.titleStatusService = titleStatusService;
    }

    @GetMapping
    public List<TitleStatusDTO> getAll() {
        return titleStatusService.findAll();
    }

    @GetMapping(ApiRouter.TitleStatusRouter.FIND_BY_ID)
    public TitleStatusDTO findById(@PathVariable("id") Long id) {
        return titleStatusService.findById(id);
    }

    @PostMapping
    public TitleStatusDTO save(@RequestBody TitleStatusEntity titleStatus) {
        return titleStatusService.save(titleStatus);
    }

    @DeleteMapping(ApiRouter.TitleStatusRouter.DELETE)
    public void delete(@PathVariable("id")TitleStatusEntity titleStatus) {
        titleStatusService.delete(titleStatus);
    }
}