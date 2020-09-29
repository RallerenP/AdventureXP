package com.adventurealley.adventurexp.repositories;

import java.util.List;

public interface IRepository<E, DTO> {

    E create(DTO dto);
    E read(int id);
    List<E> readAll();
    E update(DTO dto);
    boolean delete(DTO dto);

}
