package fatec.model;

import javax.persistence.Entity;

@Entity
public class Estado extends EntidadeDominio {

	private String sigla;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
