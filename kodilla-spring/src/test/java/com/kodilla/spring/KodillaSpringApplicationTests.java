package com.kodilla.spring;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class KodillaSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testCircleLoadedIntoContainer() {
        //Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = context.getBean(Circle.class);
		//When
		String result = shape.getShapeName();
		//Then
		Assertions.assertEquals("This is a circle.", result);
	}

	@Test
	void testTriangleLoadedIntoContainer() {
		// Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape) context.getBean("triangle");
		// When
		String result = shape.getShapeName();
		// Then
		Assertions.assertEquals("This is a triangle.", result);
	}

	@Test
	void testSquareLoadedIntoContainer() {
		// Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape) context.getBean("createSquare");
		// When
		String result = shape.getShapeName();
		//Then
		Assertions.assertEquals("This is a square.", result);
	}

	@Test
	void testShapeLoadedIntoContainer() {
		// Given
		ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape) context.getBean("chosenShape");
		// When
		String result = shape.getShapeName();
		// Then
		System.out.println("Chosen shape is: " + result);
	}
}
