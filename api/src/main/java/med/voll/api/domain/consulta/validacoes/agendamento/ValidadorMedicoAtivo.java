package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com o médico excluido!");
        }
    }
}
