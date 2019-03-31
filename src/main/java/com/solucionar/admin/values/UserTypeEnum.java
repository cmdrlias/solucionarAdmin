package com.solucionar.admin.values;

public enum UserTypeEnum {
    SYSTEM_ADMIN(1, "ROLE_SYSTEM_ADMIN");

    private final int code;
    private final String role;

    private UserTypeEnum(int code, String role) {
        this.code = code;
        this.role = role;
    }

    public int getCode() {
        return code;
    }

    public String getRole() {
        return role;
    }

    public String getRoleName() {
        return role.replaceFirst("ROLE_", "");
    }

    /*public UserType getUserType() {
        return new UserType(code);
    }*/

    public static UserTypeEnum getByCode(int code) throws IllegalArgumentException {
        for (UserTypeEnum type : UserTypeEnum.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }

        throw new IllegalArgumentException("User type not found for code '" + code + "'.");
    }
}
