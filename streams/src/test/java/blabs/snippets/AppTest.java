package blabs.snippets;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
	
	@Test
	public void printForEachWithStreams() {
		IntStream
			.range(1, 9)
			.skip(5)
			.forEach(x -> System.out.println(x));
	}
	
	@Test
	public void findFirstName() {
		Optional<String> firstName = Stream.of("Mirian", "Mateus", "Miguel", "Beto")
									.sorted()
									.findFirst();
		
		assertTrue("Beto".equals(firstName.get()));
	}
	
	@Test
	public void findAnyNameStartingWithAnM() {
		Optional<String> anyName = Stream.of("Mirian", "Mateus", "Miguel", "Beto")
									.findAny();
		
		assertTrue("Mirian".equals(anyName.get()));
	}
	
	@Test
	public void sumOfDoubles() {
		double total = Stream.of(1.5, 1.5, 1.5)
								.reduce(0.0, (a,b) -> a + b);
		
		assertTrue(total == 4.5);
	}
	
	@Test
	public void sumOfInts() {
		final int total = IntStream.range(1, 3)
									.sum();
		
		assertTrue(total == 3);
	}
	
	@Test
	public void summaryStatsOfInts() {
		IntSummaryStatistics summary = IntStream.range(0, 100).summaryStatistics();
		
		System.out.println(summary);
	}
	
	@Test
	public void countNamesStartingWithM() {
		String[] names = {"Beto", "Mi", "Mateus", "Miguel"};
		
		final long count = Arrays.stream(names)
									.filter(n -> n.startsWith("M"))
									.count();
		
		assertTrue(count == 3);
	}
}
