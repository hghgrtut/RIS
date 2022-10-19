package com.example.someMangaLib.servicies;

import com.example.someMangaLib.dtos.BookDTO;
import com.example.someMangaLib.dtos.TitleStatusDTO;
import com.example.someMangaLib.dtos.factories.TitleStatusDTOFactory;
import com.example.someMangaLib.entities.BookEntity;
import com.example.someMangaLib.entities.TitleStatusEntity;
import com.example.someMangaLib.repositories.TitleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleStatusService {

    private final TitleStatusRepository titleStatusRepository;

    @Autowired
    public TitleStatusService(TitleStatusRepository titleStatusRepository) {
        this.titleStatusRepository = titleStatusRepository;
    }

    public List<TitleStatusDTO> findAll() {
        return titleStatusRepository.findAll()
                .stream()
                .map(titleStatus -> new TitleStatusDTOFactory()
                        .toTitleStatusDTO(titleStatus))
                .collect(Collectors.toList());
    }

    public TitleStatusDTO findById(Long id) {
        return new TitleStatusDTOFactory().toTitleStatusDTO(titleStatusRepository.findById(id).get());
    }

    public TitleStatusDTO save(TitleStatusEntity titleStatus) {
        return new TitleStatusDTOFactory().toTitleStatusDTO(titleStatusRepository.save(titleStatus));
    }

    public void delete(TitleStatusEntity titleStatus) {
        titleStatusRepository.delete(titleStatus);
    }
}
