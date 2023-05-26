package projectdb;

import java.util.Date;


public class FornecedorSede {
	private Date data_compra;
	private Date data_entrega;
	private double valor;
	private int id_sedeFK;
	
	
	public Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}
	public Date getData_entrega() {
		return data_entrega;
	}
	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId_sedeFK() {
		return id_sedeFK;
	}
	public void setId_sedeFK(int id_sedeFK) {
		this.id_sedeFK = id_sedeFK;
	}
}
