package ru.basanov.se.api.service;

import ru.basanov.se.entity.Domain;

public interface IDomainService {

    void load(Domain domain);

    void export(Domain domain);
}
