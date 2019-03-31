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
            "/lawfirm/list",
            "/lawfirm/add",
            "/lawfirm/save",
            "/lawfirm/edit",
            "/lawfirm/update",
            "/lawfirm/delete",
            "/lawfirm/block",
            "/lawfirm/unblock",
            "/users/list",
            "/users/add",
            "/users/save",
            "/users/edit",
            "/users/update",
            "/users/delete",
            "/users/block",
            "/users/unblock"
    };
}
