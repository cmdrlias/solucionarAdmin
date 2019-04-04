package com.solucionar.admin.config;

public interface WebURIs {
    public static final String[] PUBLIC_URI = {
            "/",
            "/login",
            "/my-logout",
            "/expired",
            "/js/messages",
    };

    public static final String[] PRIVATE_URI_GENERAL = {
            "/dashboard",
    };

    public static final String[] PRIVATE_URI_SYSTEM_ADMIN = {
            "/dashboard/save-comment",
            "/users",
            "/users/list",
            "/users/add",
            "/users/save",
            "/companies",
            "/companies/list",
            "/companies/add",
            "/companies/save"
    };
}
