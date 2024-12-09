
package gestaohospitalar;

import java.util.Scanner;

public class GerenciaAtendimentos {
    private Atendimento atendimentos[];
    private Scanner ent;

    public GerenciaAtendimentos(Atendimento atds[]) {
        atendimentos = atds;
        ent = new Scanner(System.in);
    }

    public void cadastrarAtendimento(Paciente paciente, Medico medico) {
        int i = 0;
        while ((i < atendimentos.length) && (atendimentos[i] != null)) {
            i++;
        }
        if (i < atendimentos.length) {
            atendimentos[i] = new Atendimento(paciente, medico);
            System.out.println("Atendimento cadastrado com sucesso.");
        } else {
            System.out.println("Vetor cheio.");
        }
    }

    public void alterarEstado(String crmMedicoLogado) {
        int pos;
        System.out.println("--==[Alteração de Estado]==--");
        System.out.println("Qual posição deseja alterar? ");
        pos = ent.nextInt();
        ent.skip("");
        if (atendimentos[pos] != null) {
            Atendimento atendimento = atendimentos[pos];
            if (!atendimento.getMedico().getCrm().equals(crmMedicoLogado)) {
                System.out.println("Somente o médico responsável pode alterar o estado do atendimento.");
                return;
            }
            System.out.println("Estado atual: " + atendimento.getEstadoAtual());
            System.out.println("Escolha o novo estado: ");
            for (EstadoAtendimento estado : EstadoAtendimento.values()) {
                System.out.println("- " + estado);
            }
            String novoEstado = ent.nextLine();
            try {
                atendimento.setEstadoAtual(EstadoAtendimento.valueOf(novoEstado.toUpperCase()));
                System.out.println("Estado alterado com sucesso.");
            } catch (IllegalArgumentException e) {
                System.out.println("Estado inválido.");
            }
        } else {
            System.out.println("Atendimento não encontrado.");
        }
    }

    public void relatorioAtendimentos() {
        System.out.println("--==[Relatório de Atendimentos]==--");
        for (Atendimento atendimento : atendimentos) {
            if (atendimento != null) {
                atendimento.imprimir();
                System.out.println("-----------------------------------");
            }
        }
    }
}
