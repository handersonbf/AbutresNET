package br.com.abutres.enuns;

public enum Status {

	ATIVO("Ativo"),
	INATIVO("Inativo"),
	AFASTADO("Afastado");
	
	final String label;
	
	private Status(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
