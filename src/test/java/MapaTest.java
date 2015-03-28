import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MapaTest {

	private Mapa mapa;

	@Before
	public void init() {
		this.mapa = new Mapa();
	}

	@Test
	public void testeDimensaoMapa8x8() {

		Assert.assertEquals(8, this.mapa.getAltura());
		Assert.assertEquals(8, this.mapa.getLargura());
	}

	@Test
	public void testeMapaVazio() {
		boolean[][] mapaZerado = new boolean[8][8];

		boolean[][] matriz_mapa = this.mapa.getCampoBatalha();
		Assert.assertArrayEquals(mapaZerado, matriz_mapa);
	}

	@Test
	public void testeSeÉQuadrado() {
		int altura = this.mapa.getAltura();
		int largura = this.mapa.getLargura();
		Assert.assertEquals(altura, largura);

	}

	@Test
	public void testePosicionaNavio() throws ForaDoCampoDeBatalhaException, PosicaoJaOcupadaException{
		this.mapa.posicionaNavio(3, 6);
		boolean[][] matriz = this.mapa.getCampoBatalha();
		Assert.assertTrue(matriz[3][6]);

		this.mapa.posicionaNavio(2, 3);
		Assert.assertTrue(matriz[2][3]);

		this.mapa.posicionaNavio(1, 7);
		Assert.assertTrue(matriz[1][7]);

		this.mapa.posicionaNavio(1, 0);
		Assert.assertTrue(matriz[1][0]);
	}

	@Test
	public void testPosicionaFora() throws ForaDoCampoDeBatalhaException, PosicaoJaOcupadaException {
		this.mapa.posicionaNavio(1, 8);
	}

	@Test (expected=PosicaoJaOcupadaException.class)
	public void testSeExisteNavioPosição () throws ForaDoCampoDeBatalhaException, PosicaoJaOcupadaException{

		this.mapa.posicionaNavio(4,6);
		this.mapa.posicionaNavio(4,6);

	}

}
