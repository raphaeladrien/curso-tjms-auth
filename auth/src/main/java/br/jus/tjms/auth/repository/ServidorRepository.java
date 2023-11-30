package br.jus.tjms.auth.repository;

import br.jus.tjms.auth.model.Servidor;

public interface ServidorRepository {
    Servidor save(Servidor servidor);

    Boolean findByMatricula(Integer matricula);

    Boolean existsByMatricula(Integer matricula);
}
