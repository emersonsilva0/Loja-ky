package projectdb;
import java.util.List;

public class Fornecedor {
	private int id_fornecedor;
	private String nome;
	private String telefone;
	private List<Produtos> produto;
	
	public int getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Produtos> getProduto() {
		return produto;
	}
	public void setProduto(List<Produtos> produto) {
		this.produto = produto;
	}
	
}
