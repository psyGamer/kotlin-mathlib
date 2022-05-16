package dev.psygamer.mathlib.complex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class ComplexITest {
	
	@Test
	fun plusComplexI() {
		assertEquals(
			ComplexI(2, 2),
			ComplexI(1, 1) + ComplexI(1, 1)
		)
		assertEquals(
			ComplexI(3, 2),
			ComplexI(1, 2) + ComplexI(2, 0)
		)
		assertEquals(
			ComplexI(4, 5),
			ComplexI(4, 5) + ComplexI(0, 0)
		)
	}
	
	@Test
	fun plusIsCommutative() {
		assertEquals(
			ComplexI(1, 2) + ComplexI(3, 4),
			ComplexI(3, 4) + ComplexI(1, 2)
		)
	}
	
	@Test
	fun minusComplexI() {
		assertEquals(
			ComplexI(0, 0),
			ComplexI(1, 1) - ComplexI(1, 1)
		)
		assertEquals(
			ComplexI(-1, 2),
			ComplexI(1, 2) - ComplexI(2, 0)
		)
		assertEquals(
			ComplexI(4, 5),
			ComplexI(4, 5) - ComplexI(0, 0)
		)
	}
	
	@Test
	fun timesScalar() {
		assertEquals(
			ComplexI(2, 4),
			ComplexI(1, 2) * 2
		)
		assertEquals(
			ComplexI(0, 0),
			ComplexI(1, 2) * 0
		)
	}
	
	@Test
	fun timesComplexI() {
		assertEquals(
			ComplexI(-5, 10),
			ComplexI(1, 2) * ComplexI(3, 4)
		)
	}
	
	@Test
	fun timesConjugate() {
		assertEquals(
			ComplexI(13, 0),
			ComplexI(2, 3) * ComplexI(2, 3).conjugate
		)
	}
	
	@Test
	fun div() {
		assertEquals(
			ComplexF(
				(10 * 1 + 20 * 2).toFloat() / (1 * 1 + 2 * 2),
				(20 * 1 - 10 * 2).toFloat() / (1 * 1 + 2 * 2)
			),
			ComplexI(10, 20) / ComplexI(1, 2)
		)
	}
	
	@Test
	fun iSquaredIsNegativeOne() {
		assertEquals(ComplexI(-1, 0), ComplexI(0, 1) * ComplexI(0, 1))
	}
	
	@Test
	fun conjugate() {
		assertEquals(ComplexI(2, -3), ComplexI(2, 3).conjugate)
	}
	
	@Test
	fun absoluteValue() {
		assertEquals(
			sqrt(3.0f * 3.0f + 4.0f * 4.0f), ComplexI(3, 4).abs
		)
	}
	
	@Test
	fun sqrtOfTimesConjugateIsAbsoluteValue() {
		assertEquals(
			ComplexI(2, 3).abs,
			sqrt((ComplexI(2, 3) * ComplexI(2, 3).conjugate).r.toFloat())
		)
	}
	
	@Test
	fun angle() {
		assertEquals(Math.toRadians(45.0).toFloat(), ComplexI(1, 1).angle, 0.001f)
	}
}