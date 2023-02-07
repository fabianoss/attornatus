package br.com.attornatus.builder;

import java.util.List;

public interface Builder<T,D>{
    T toDto(D domain);
    List<T> listToDto(List<D> domains);
    D toDomain(T dto);
    List<D> listToDomain(List<T> dtos);
    void toUpdated(T dto, D updated);
}
