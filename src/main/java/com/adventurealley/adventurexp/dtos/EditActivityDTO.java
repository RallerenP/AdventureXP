package com.adventurealley.adventurexp.dtos;

public class EditActivityDTO extends CreateActivityDTO {

    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
