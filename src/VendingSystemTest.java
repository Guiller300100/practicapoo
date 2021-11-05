import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class VendingSystemTest {
	
	private Map<Integer, VendingMachine> m = new HashMap<>();
	private VendingSystem vs = new VendingSystem(m);

	@Test
	public void testVendingSystem() {
		VendingSystem t = new VendingSystem(m);
		assertNotNull(t);
	}

	@Test
	public void testNuevaMaquina() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNuevaMaquinaIdNegativo() {
		vs.nuevaMaquina(-1, 5, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNuevaMaquinaNumLineasNegativo() {
		vs.nuevaMaquina(1, -5, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNuevaMaquinaProfundidadNegativo() {
		vs.nuevaMaquina(1, 5, -10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNuevaMaquinaIdExiste() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.nuevaMaquina(1, 4, 3);
	}
	
	@Test
	public void testgetMaquina() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testgetMaquinaNoExiste() {
		assertNotNull(vs.getMaquina(1));
	}
	
	@Test
	public void testBorrarMaquina() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.borrarMaquina(1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBorrarMaquinaNoExisteId() {
		vs.borrarMaquina(2);
	}
	
	@Test
	public void testListaMaquinas() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.listaMaquinas();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testListaMaquinasNoHayMaquinas() {
		vs.listaMaquinas();
	}
	
	@Test
	public void testMaquinasOperativas() {
		vs.nuevaMaquina(1, 5, 10);
		assertNotNull(vs.getMaquina(1));
		vs.nuevaMaquina(2, 5, 10);
		assertNotNull(vs.getMaquina(2));
		vs.modificarEstado(2, false);
		vs.maquinasOperativas();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMaquinasOperativasNoHayMaquinas() {
		vs.maquinasOperativas();
	}

	@Test
	public void testListaMaquinasLineaVacia() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarEstado() {
		fail("Not yet implemented");
	}

}
