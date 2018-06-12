package br.com.abutres.enums;

public enum EnumStatus {

	ATIVO("Ativo"),
	AFASTADO("Afastado"),
	EXPULSO("Expulso");
	
	private String descricao;
	
	EnumStatus(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
