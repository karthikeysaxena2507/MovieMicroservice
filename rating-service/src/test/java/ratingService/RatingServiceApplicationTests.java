package ratingService;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ratingService.services.RatingService;

@SpringBootTest
class RatingServiceApplicationTests {

	Logger logger = LoggerFactory.getLogger(RatingServiceApplicationTests.class);

	private final RatingService ratingService;

	private static int a;

	private static int b;

	private static int r;

	@BeforeAll
	static void init() {
		a = 5;
		b = 5;
		r = 10;
	}

	@AfterEach
	void end() {
		logger.info("clean");
	}

	@Autowired
	public RatingServiceApplicationTests(RatingService ratingService) {
		this.ratingService = ratingService;
	}


	@Test
	@DisplayName("testing add method")
	void testAdd() {
		int actual = ratingService.add(a, b);
		int expected = 10;
		Assertions.assertEquals(expected, actual, () -> "The method should add 2 numbers");
	}

	@Test
	@DisplayName("testing area method")
	void testArea() {
		Assertions.assertEquals(314.00, ratingService.area(r), () -> "The method should return area of circle");
	}

	@Test
	@Disabled
	void testDivide() {
		Assertions.assertThrows(ArithmeticException.class, () -> ratingService.divide(a, 0), "The denominator cannot be 0");
	}

}
