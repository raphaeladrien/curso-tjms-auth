package br.jus.tjms.auth.servicos;

import br.jus.tjms.auth.model.Servidor;
import br.jus.tjms.auth.repository.ServidorRepository;
import org.springframework.stereotype.Service;

@Service
public class ServidorService {

    private ServidorRepository servidorRepository;
    public ServidorService(ServidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    public void criarUmNovoServidor(Servidor servidor) {
        if(exists(servidor.getMatricula())) {
            throw new RuntimeException("Erro");
        }

        servidorRepository.save(servidor);
    }

    public void exonerarServidor() {

    }

    private Boolean exists(Integer matricula) {
        return servidorRepository.existsByMatricula(matricula);
    }
}
