package com.example.someMangaLib.contracts;

public class ApiRouter {

    public static class BookRouter {
        public static final String BASE_URL = "api/v1/books";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String DELETE = "/{id}";
    }

    public static class TitleStatusRouter {
        public static final String BASE_URL = "api/v1/titleStatues";
        public static final String FIND_BY_ID = "/{id}";
        public static final String DELETE = "/{id}";
    }

    public static class TranslateStatusRouter {
        public static final String BASE_URL = "api/v1/translateStatues";
        public static final String FIND_BY_ID = "/{id}";
        public static final String DELETE = "/{id}";
    }
}
