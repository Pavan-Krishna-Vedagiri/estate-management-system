package com.pavan.github.estatemanagementsystem.constants;

public final class UrlConstants {

    private UrlConstants() {}

    // Base paths
    public static final String API_BASE = "estate-management-portal/api/v1";
    public static final String PROPERTIES = API_BASE + "/properties";
    public static final String USERS = API_BASE + "/users";
    public static final String ROOMS = API_BASE + "/rooms";
    public static final String OWNERS = API_BASE + "/owners";

    // User endpoints
    public static final String CREATE_USER = "";
    public static final String GET_USERS_BY_ID = "/{id}";
    public static final String UPDATE_USERS = "/{id}";
    public static final String DELETE_USERS = "/{id}";

    // Property endpoints
    public static final String CREATE_PROPERTY = "";
    public static final String GET_PROPERTY_BY_ID = "/{id}";
    public static final String UPDATE_PROPERTY = "/{id}";
    public static final String DELETE_PROPERTY = "/{id}";

    // Room endpoints
    public static final String GET_ROOM_BY_ID = "/{id}";
    public static final String CREATE_ROOM = "";
    public static final String UPDATE_ROOM = "/{id}";
    public static final String DELETE_ROOM = "/{id}";

    // Nested endpoints (rooms inside properties)
    public static final String PROPERTY_ROOMS = "/{propertyId}/rooms";

}
