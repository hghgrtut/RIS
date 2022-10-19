package com.example.someMangaLib.servicies;

import com.example.someMangaLib.dtos.TranslateStatusDTO;
import com.example.someMangaLib.dtos.factories.TranslateStatusDTOFactory;
import com.example.someMangaLib.entities.TranslateStatusEntity;
import com.example.someMangaLib.repositories.TranslateStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslateStatusService {

    private final TranslateStatusRepository translateStatusRepository;

    @Autowired
    public TranslateStatusService(TranslateStatusRepository translateStatusRepository) {
        this.translateStatusRepository = translateStatusRepository;
    }

    public List<TranslateStatusDTO> findAll() {
        return translateStatusRepository.findAll()
                .stream()
                .map(translateStatus -> new TranslateStatusDTOFactory()
                        .toTranslateStatusDTO(translateStatus))
                .collect(Collectors.toList());
    }

    public TranslateStatusDTO findById(Long id) {
        return new TranslateStatusDTOFactory().toTranslateStatusDTO(translateStatusRepository.findById(id).get());
    }

    public TranslateStatusDTO save(TranslateStatusEntity translateStatus) {
        return new TranslateStatusDTOFactory().toTranslateStatusDTO(translateStatusRepository.save(translateStatus));
    }

    public void delete(TranslateStatusEntity translateStatus) {
        translateStatusRepository.delete(translateStatus);
    }

}
