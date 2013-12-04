package edu.uniasselvi.ads24.bob.enumeradores;

public enum ETipoGeracao {
	
	NENHUM (0),
	CRIACAO (1),
	EXCLUSAO (2);
	
	private final int index;
	
	public int getIndex() {
		return index;
	}

	private ETipoGeracao(int index) {
		this.index = index;
	}	
	
	public static ETipoGeracao fromInteger(int x) {
        switch(x) {
        case 0:
            return NENHUM;
        case 1:
            return CRIACAO;
        case 2:
            return EXCLUSAO;
        }
        return null;
    }
}
