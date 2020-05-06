package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import estados.*;
import src.Vikingo;

public class EstadosTest {
	
	Vikingo v1, v2;

	@Before
	public void setUp() throws Exception {
		v1 = new Vikingo(10);
		v2 = new Vikingo(100);
	}

	@Test
	public void testNormalAColerico() {
		v1.atacar(v2);
		assertEquals(90, v2.getHP());
		assertEquals(new Colerico(), v2.getEstado());
	}
	
	@Test
	public void testNormalABerseker() {
		v1.atacar(v2);
		v1.atacar(v2);
		assertEquals(70, v2.getHP());
		assertEquals(new Berseker(), v2.getEstado());
	}
	
	@Test
	public void testPermaneceEnBerseker() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		assertEquals(65, v2.getHP());
		assertEquals(new Berseker(), v2.getEstado());
	}
	
	@Test
	public void testNormalANormal() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		v2.meditar();
		assertEquals(65, v2.getHP());
		assertEquals(new Normal(), v2.getEstado());
	}
	
	@Test
	public void testNormalAFueraDeCombate() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		v2.atacar(v1);
		assertEquals(65, v2.getHP());
		assertEquals(-20, v1.getHP());
		assertEquals(new FueraDeCombate(), v1.getEstado());
	}
	
	
	@Test
	public void testColericoANormal() {
		v1.atacar(v2);
		v2.meditar();
		assertEquals(90, v2.getHP());
		assertEquals(new Normal(), v2.getEstado());
	}
	
	@Test
	public void testCalmadoANormal() {
		v2.meditar();
		v2.atacar(v1);
		assertEquals(new Normal(), v2.getEstado());
	}
	
	@Test
	public void testPermanecerCalmado() {
		v2.meditar();
		v2.meditar();
		assertEquals(new Calmado(), v2.getEstado());
	}
	
	@Test
	public void testPermanecerCalmadoEnAtaque() {
		v2.meditar();
		v1.atacar(v2);
		assertEquals(new Calmado(), v2.getEstado());
	}
	
	@Test
	public void testNormalACalmado() {
		v1.meditar();
		assertEquals(new Calmado(), v1.getEstado());
	}
	
	@Test
	public void testPrimerEstadoNormal() {
		assertEquals(new Normal(), v1.getEstado());
		assertEquals(new Normal(), v2.getEstado());
	}
	
	@Test
	public void testColericoAFueraDeComabte() {
		Vikingo v3 = new Vikingo(20);
		v1.atacar(v3);
		v1.atacar(v3);
		assertEquals(new FueraDeCombate(), v3.getEstado());
	}
	
	@Test
	public void testBersekerAFueraDeComabte() {
		Vikingo v3 = new Vikingo(30);
		v1.atacar(v3);
		v1.atacar(v3);
		v1.atacar(v3);
		assertEquals(new FueraDeCombate(), v3.getEstado());
	}

}
