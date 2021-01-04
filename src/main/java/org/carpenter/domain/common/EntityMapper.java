package org.carpenter.domain.common;

public interface EntityMapper <E, D> {
    E toEntity(D dto);
    D toDto(E entity);
}
