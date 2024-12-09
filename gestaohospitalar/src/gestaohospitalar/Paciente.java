package gestaohospitalar;

public class Paciente extends Pessoa {
    private String nomeConvenio;
    private String numeroConvenio;
    
    public Paciente(String nome, String id, String cpf, String end, String tel,
            String nomeConv, String numConv){
        super(nome, id, cpf, end, tel);
        nomeConvenio = nomeConv;
        numeroConvenio = numConv;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    @Override
    public void imprimir(){
        super.imprimir();
        System.out.println("Nome Convênio  : " + nomeConvenio);
        System.out.println("Número Convênio: " + numeroConvenio);
    }
}
