package gmail.ovodneva.note.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gmail.ovodneva.note.contracts.ApiRouter;
import gmail.ovodneva.note.entities.NoteEntity;
import gmail.ovodneva.note.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(ApiRouter.NoteRouter.BASE_URL)
public class NoteController {

    private final NoteService noteService;
    private final ObjectMapper objectMapper;

    @Autowired
    public NoteController(NoteService noteService, ObjectMapper objectMapper) {
        this.noteService = noteService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String getAll() throws JsonProcessingException {
        return objectMapper.writeValueAsString(noteService.findAll());
    }

    @GetMapping(ApiRouter.NoteRouter.FIND_BY_ID)
    public String getById(@PathVariable("id") int id) throws ClassNotFoundException, JsonProcessingException {
        return objectMapper.writeValueAsString(noteService.findById(id));
    }

    @PutMapping(ApiRouter.NoteRouter.UPDATE)
    public String update(@PathVariable("id") int id, HashMap<String, String> params) throws ClassNotFoundException, JsonProcessingException {
        NoteEntity noteEntity = new NoteEntity(params.get("name"), params.get("description"));
        return objectMapper.writeValueAsString(noteService.update(id, noteEntity));
    }

    @PostMapping
    public String save(@RequestBody HashMap<String, String> params) throws JsonProcessingException {
        NoteEntity noteEntity = new NoteEntity(params.get("name"), params.get("description"));
        return objectMapper.writeValueAsString(noteService.save(noteEntity));
    }

    @DeleteMapping(ApiRouter.NoteRouter.DELETE)
    public void delete(@PathVariable("id") int id) {
        noteService.delete(id);
    }
}
