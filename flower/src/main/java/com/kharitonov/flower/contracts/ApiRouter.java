package com.kharitonov.flower.contracts;

public class ApiRouter {

    public static class AuthRouter {
        public static final String BASE_URL = "api/v1/auth";
        public static final String LOGIN = "/login";
        public static final String TOKEN = "/token";
        public static final String REFRESH = "/refresh";
    }

    public static class UserRouter {
        public static final String BASE_URL = "api/v1/user";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String DELETE_BY_ID = "/{id}";
    }

    public static class FlowerRouter {
        public static final String BASE_URL = "api/v1/flower";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String DELETE_BY_ID = "/{id}";
    }

    public static class BasketFlower {
        public static final String BASE_URL = "api/v1/flower";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String ADD_FLOWER = "/toBasketId/flowerId";
        public static final String DELETE_BY_ID = "/{id}";
    }

}
