package projectdb;

public class Produtos {
	private int id_fornecedorFK;
	private String produto;
	public int getId_fornecedorFK() {
		return id_fornecedorFK;
	}
	public void setId_fornecedorFK(int id_fornecedorFK) {
		this.id_fornecedorFK = id_fornecedorFK;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
}
