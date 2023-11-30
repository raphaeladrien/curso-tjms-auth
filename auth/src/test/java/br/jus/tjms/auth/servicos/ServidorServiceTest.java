package br.jus.tjms.auth.servicos;

import br.jus.tjms.auth.model.Servidor;
import br.jus.tjms.auth.repository.ServidorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServidorServiceTest {

    private final ServidorRepository servidorRepository =
        Mockito.mock(ServidorRepository.class);

    private final ServidorService subject =
        new ServidorService(servidorRepository);

    @Test
    @DisplayName("quando os dados do servidor for informado, salvar na bd")
    public void whenServidorIsProvided_savesInDatabase() {
        Servidor servidor = buildServidor();

        subject.criarUmNovoServidor(servidor);

        Mockito.verify(servidorRepository, Mockito.times(1)).save(servidor);
    }

    @Test
    @DisplayName("Quando a matricula já existir, deve retornar um erro")
    public void quandoMatriculaExister_deveRetornarUmErro() {
        Servidor servidor = buildServidor();

        Mockito.when(servidorRepository.existsByMatricula(servidor.getMatricula())).thenReturn(true);

        Assertions.assertThrows(RuntimeException.class, () -> {
            subject.criarUmNovoServidor(servidor);
        });
    }

    private static Servidor buildServidor() {
        Integer matricula = 12346;
        String nome = "Raphael Adrien";
        String cargo = "Juiz (membro)";

        Servidor servidor = new Servidor(matricula, nome, cargo);
        return servidor;
    }
}
