package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if(!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluido.");
        }

    }
}
