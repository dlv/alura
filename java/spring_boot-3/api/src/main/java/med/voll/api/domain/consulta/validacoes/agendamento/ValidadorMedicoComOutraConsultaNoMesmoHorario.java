package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorAgendamentoDeConsulta;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada neste mesmo horário.");
        }

    }
}
