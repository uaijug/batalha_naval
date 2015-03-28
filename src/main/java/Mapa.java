public class Mapa {

	private static final int TAMANHO_MAPA = 8;
	private boolean[][] campoBatalha = new boolean[TAMANHO_MAPA][TAMANHO_MAPA];

	public int getAltura() {
		return TAMANHO_MAPA;
	}

	public int getLargura() {
		return TAMANHO_MAPA;
	}

	public boolean[][] getCampoBatalha() {
		return this.campoBatalha;
	}

	public void posicionaNavio(int i, int j) throws ForaDoCampoDeBatalhaException, PosicaoJaOcupadaException {
		try {

			if (this.campoBatalha[i][j]) {
				throw new PosicaoJaOcupadaException();

			} else {
				this.campoBatalha[i][j] = true;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ForaDoCampoDeBatalhaException(e);
		}
	}
}
