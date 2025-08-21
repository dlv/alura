package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.constraints.NotBlank;

public record DadosAtualizacaoPaciente(
        @NotBlank
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco
) {
}
