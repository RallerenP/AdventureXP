package com.adventurealley.adventurexp.entities;

public enum Role {
    EMPLOYEE {
        @Override
        public String toString() {
            return "Employee";
        }
    },
    CUSTOMER {
        @Override
        public String toString() {
            return "Customer";
        }
    };

    public static int getID(Role role) {
        switch (role) {
            case CUSTOMER: return 1;
            case EMPLOYEE: return 0;
            default: return -1;
        }
    }

    public static Role parse(String role) {
        switch (role) {
            case "EMPLOYEE": return EMPLOYEE;
            case "CUSTOMER": return CUSTOMER;
            default: return null;
        }


    }
}
