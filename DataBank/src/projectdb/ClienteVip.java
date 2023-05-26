package projectdb;

public class ClienteVip extends Cliente {
	private int id_clienteFK;
	private int cpf;
	private String endereco;
	private String tempo_contribuicao;
	public int getId_clienteFK() {
		return id_clienteFK;
	}
	public void setId_clienteFK(int id_clienteFK) {
		this.id_clienteFK = id_clienteFK;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(Object string) {
		this.cpf = (int) string;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTempo_contribuicao() {
		return tempo_contribuicao;
	}
	public void setTempo_contribuicao(String tempo_contribuicao) {
		this.tempo_contribuicao = tempo_contribuicao;
	}
	
}
