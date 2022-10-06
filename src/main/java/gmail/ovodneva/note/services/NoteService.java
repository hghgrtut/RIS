package gmail.ovodneva.note.services;

import gmail.ovodneva.note.entities.NoteEntity;
import gmail.ovodneva.note.repositories.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteEntity> findAll() {
        return noteRepository.findAll();
    }

    public NoteEntity findById(int id) throws ClassNotFoundException {
        return noteRepository.findById(id);
    }

    public NoteEntity save(NoteEntity noteEntity) {
        return noteRepository.save(noteEntity);
    }

    public NoteEntity update(int id, NoteEntity noteEntity) throws ClassNotFoundException {
        NoteEntity noteEntityFromDB = findById(id);
        BeanUtils.copyProperties(noteEntity, noteEntityFromDB, "id");
        return noteEntityFromDB;
    }

    public void delete(int id) {
        noteRepository.delete(id);
    }

}
