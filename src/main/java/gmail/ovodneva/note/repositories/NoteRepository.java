package gmail.ovodneva.note.repositories;

import gmail.ovodneva.note.entities.NoteEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepository {

    private int COUNT = 0;
    private List<NoteEntity> notes = new ArrayList<>();

    public List<NoteEntity> findAll() {
        return this.notes;
    }

    public NoteEntity save(NoteEntity note) {
        note.setId(++COUNT);
        notes.add(note);
        return note;
    }

    public NoteEntity findById(int id) throws ClassNotFoundException {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(ClassNotFoundException::new);
    }

    public void delete(int id) {
        NoteEntity noteEntity = notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(ClassCastException::new);
        notes.remove(noteEntity);
    }
}
