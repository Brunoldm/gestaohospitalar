
package gestaohospitalar;

public class Atendimento {
    private Paciente paciente;
    private Medico medico;
    private EstadoAtendimento estadoAtual;

    public Atendimento(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
        this.estadoAtual = EstadoAtendimento.ENTRADA; 
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public EstadoAtendimento getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(EstadoAtendimento estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public void imprimir() {
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Estado Atual: " + estadoAtual);
    }
}
