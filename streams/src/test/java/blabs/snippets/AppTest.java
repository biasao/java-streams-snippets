package blabs.snippets;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void filterNamesStartingWithM() {
		String[] names = { "mateus", "miguel", "mirian", "beto" };

		List<String> filteredNames = Arrays.stream(names)
				.filter(n -> n.startsWith("m"))
				.collect(Collectors.toList());

		assertTrue(filteredNames.size() == 3);
	}
	
	@Test
	public void makeAllNamesToCapitalLetters() {
		String[] names = { "mateus", "miguel", "mirian", "beto" };

		List<String> capitalNames = Arrays.stream(names)
				.map(n -> n.toUpperCase())
				.collect(Collectors.toList());

		assertTrue(capitalNames.size() == 4);
		assertTrue("MATEUS".equals(capitalNames.get(0)));
		assertTrue("MIGUEL".equals(capitalNames.get(1)));
		assertTrue("MIRIAN".equals(capitalNames.get(2)));
		assertTrue("BETO".equals(capitalNames.get(3)));
	}
}
