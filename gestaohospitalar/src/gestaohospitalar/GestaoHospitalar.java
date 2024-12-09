package gestaohospitalar;

import java.util.Scanner;

public class GestaoHospitalar {

    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);

        Paciente pacientes[] = new Paciente[100];
        Medico medicos[] = new Medico[100];
        Atendimento atendimentos[] = new Atendimento[100]; 

        GerenciaMedicos gm = new GerenciaMedicos(medicos);
        GerenciaPacientes gp = new GerenciaPacientes(pacientes);
        GerenciaAtendimentos ga = new GerenciaAtendimentos(atendimentos); 

        int op1, op2;

        do {
            System.out.println("--==[Gestão Hospitalar]==--");
            System.out.println("1 - Médicos");
            System.out.println("2 - Pacientes");
            System.out.println("3 - Atendimentos");
            System.out.println("4 - Sair");
            System.out.println("Opção: ");
            op1 = e.nextInt();
            e.skip("\n");

            switch (op1) {
                case 1:
                    do {
                        System.out.println("--==[Médicos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = e.nextInt();
                        e.skip("\n");

                        switch (op2) {
                            case 1:
                                gm.cadastrar();
                                break;
                            case 2:
                                gm.alterar();
                                break;
                            case 3:
                                gm.excluir();
                                break;
                            case 4:
                                gm.consultar();
                                break;
                            case 5:
                                gm.relatorio();
                                break;
                        }
                    } while (op2 != 6);
                    break;

                case 2:
                    do {
                        System.out.println("--==[Pacientes]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = e.nextInt();
                        e.skip("\n");

                        switch (op2) {
                            case 1:
                                gp.cadastrar();
                                break;
                            case 2:
                                gp.alterar();
                                break;
                            case 3:
                                gp.excluir();
                                break;
                            case 4:
                                gp.consultar();
                                break;
                            case 5:
                                gp.relatorio();
                                break;
                        }
                    } while (op2 != 6);
                    break;

                case 3: 
                    do {
                        System.out.println("--==[Atendimentos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar Estado");
                        System.out.println("3 - Relatório");
                        System.out.println("4 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = e.nextInt();
                        e.skip("\n");

                        switch (op2) {
                            case 1:
                                System.out.println("Informe a posição do paciente:");
                                int posPaciente = e.nextInt();
                                e.skip("\n");

                                System.out.println("Informe a posição do médico:");
                                int posMedico = e.nextInt();
                                e.skip("\n");

                                if (pacientes[posPaciente] != null && medicos[posMedico] != null) {
                                    ga.cadastrarAtendimento(pacientes[posPaciente], medicos[posMedico]);
                                } else {
                                    System.out.println("Paciente ou médico inválido.");
                                }
                                break;

                            case 2:
                                System.out.println("Informe o CRM do médico logado:");
                                String crm = e.nextLine();
                                ga.alterarEstado(crm);
                                break;

                            case 3:
                                ga.relatorioAtendimentos();
                                break;
                        }
                    } while (op2 != 4);
                    break;
            }
        } while (op1 != 4);
    }
}
