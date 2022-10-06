package gmail.ovodneva.note.contracts;

public class ApiRouter {

    public static class NoteRouter {
        public static final String BASE_URL = "api/v1/notes";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String DELETE = "/{id}";
    }
}
