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
	public void testNormalYColerico() {
		v1.atacar(v2);
		assertEquals(90, v2.getHP());
		assertEquals(new Colerico(), v2.getEstado());
	}
	
	@Test
	public void testNormalYBerseker() {
		v1.atacar(v2);
		v1.atacar(v2);
		assertEquals(70, v2.getHP());
		assertEquals(new Berseker(), v2.getEstado());
	}
	
	@Test
	public void testNormalYBersekerx2() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		assertEquals(65, v2.getHP());
		assertEquals(new Berseker(), v2.getEstado());
	}
	
	@Test
	public void testNormalYNormal() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		v2.meditar();
		assertEquals(65, v2.getHP());
		assertEquals(new Normal(), v2.getEstado());
	}
	
	@Test
	public void testFueraDeCombateYBerseker() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		v2.atacar(v1);
		assertEquals(65, v2.getHP());
		assertEquals(-20, v1.getHP());
		assertEquals(new FueraDeCombate(), v1.getEstado());
	}

}
