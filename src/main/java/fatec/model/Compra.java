package fatec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Compra extends EntidadeDominio {
	
	
	private Date dataCompra;
	private double valorTotal;
	private boolean formaPagamento;
	@ManyToOne
	private Cliente cliente;
	
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public boolean isFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(boolean formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}
