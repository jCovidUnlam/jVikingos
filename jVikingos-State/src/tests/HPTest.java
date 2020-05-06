package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.Vikingo;

public class HPTest {
	
	Vikingo v1, v2;

	@Before
	public void setUp() throws Exception {
		v1 = new Vikingo(100);
		v2 = new Vikingo(100);
	}

	@Test
	public void testAtaqueNormal() {
		v1.atacar(v2);
		assertEquals(90, v2.getHP());
	}
	
	@Test
	public void testAtaqueColerico() {
		v1.atacar(v2);
		v2.atacar(v1);
		assertEquals(80, v1.getHP());
	}
	
	@Test
	public void testAtaqueBerseker() {
		v1.atacar(v2);
		v1.atacar(v2);
		v2.atacar(v1);
		assertEquals(70, v1.getHP());
	}
	
	@Test
	public void testDefensaCalmado() {
		v1.atacar(v2);
		v2.meditar();
		v2.meditar();
		v1.atacar(v2);
		assertEquals(90, v2.getHP());
	}
	
	@Test
	public void testDefensaNormal() {
		v1.atacar(v2);
		assertEquals(90, v2.getHP());
	}
	
	@Test
	public void testDefensaColerico() {
		v1.atacar(v2);
		v1.atacar(v2);
		assertEquals(70, v2.getHP());
	}
	
	@Test
	public void testDefensaBerseker() {
		v1.atacar(v2);
		v1.atacar(v2);
		v1.atacar(v2);
		assertEquals(65, v2.getHP());
	}
	
	@Test
	public void testDefensaFueraDeCombate() {
		Vikingo v3 = new Vikingo(5);
		v1.atacar(v3);
		v1.atacar(v3);
		assertEquals(-5, v3.getHP());
	}
}
