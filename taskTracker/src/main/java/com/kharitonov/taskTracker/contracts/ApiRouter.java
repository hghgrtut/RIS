package com.kharitonov.taskTracker.contracts;

public class ApiRouter {

    public static class ProjectRouter {
        public static final String BASE_URL = "api/v1/projects";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String ADD_TASK_STATE = "/{projectId}/" + TaskStateRouter.BASE_URL + "/{taskStateId}";
        public static final String SWAP_TASK_STATE = "/{projectId}/{taskStateTargetId}/{taskStateSourceId}";
        public static final String DELETE = "/{id}";
    }

    public static class TaskStateRouter {
        public static final String BASE_URL = "api/v1/taskStates";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String ADD_TASK = "/{taskStateId}/" + TaskRouter.BASE_URL + "/{taskId}";
        public static final String DELETE = "/{id}";
    }

    public static class TaskRouter{
        public static final String BASE_URL = "api/v1/tasks";
        public static final String FIND_BY_ID = "/{id}";
        public static final String UPDATE = "/{id}";
        public static final String DELETE = "/{id}";
    }
}
