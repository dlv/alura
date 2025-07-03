package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

import javax.validation.constraints.Email;
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
