package fatec.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends EntidadeDominio {
	
	private String cpf;
	private String nome;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
