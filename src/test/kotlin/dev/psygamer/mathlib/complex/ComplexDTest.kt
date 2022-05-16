package dev.psygamer.mathlib.complex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class ComplexDTest {
	
	@Test
	fun plusComplexD() {
		assertEquals(
			ComplexD(2.0, 2.0),
			ComplexD(1.0, 1.0) + ComplexD(1.0, 1.0)
		)
		assertEquals(
			ComplexD(3.0, 2.0),
			ComplexD(1.0, 2.0) + ComplexD(2.0, 0.0)
		)
		assertEquals(
			ComplexD(4.0, 5.0),
			ComplexD(4.0, 5.0) + ComplexD(0.0, 0.0)
		)
	}
	
	@Test
	fun plusIsCommutative() {
		assertEquals(
			ComplexD(1.0, 2.0) + ComplexD(3.0, 4.0),
			ComplexD(3.0, 4.0) + ComplexD(1.0, 2.0)
		)
	}
	
	@Test
	fun minusComplexD() {
		assertEquals(
			ComplexD(0.0, 0.0),
			ComplexD(1.0, 1.0) - ComplexD(1.0, 1.0)
		)
		assertEquals(
			ComplexD(-1.0, 2.0),
			ComplexD(1.0, 2.0) - ComplexD(2.0, 0.0)
		)
		assertEquals(
			ComplexD(4.0, 5.0),
			ComplexD(4.0, 5.0) - ComplexD(0.0, 0.0)
		)
	}
	
	@Test
	fun timesScalar() {
		assertEquals(
			ComplexD(2.0, 4.0),
			ComplexD(1.0, 2.0) * 2.0
		)
		assertEquals(
			ComplexD(0.0, 0.0),
			ComplexD(1.0, 2.0) * 0.0
		)
	}
	
	@Test
	fun timesComplexD() {
		assertEquals(
			ComplexD(-5.0, 10.0),
			ComplexD(1.0, 2.0) * ComplexD(3.0, 4.0)
		)
	}
	
	@Test
	fun timesConjugate() {
		assertEquals(
			ComplexD(13.0, 0.0),
			ComplexD(2.0, 3.0) * ComplexD(2.0, 3.0).conjugate
		)
	}
	
	@Test
	fun div() {
		assertEquals(
			ComplexD(
				(10.0 * 1.0 + 20.0 * 2.0) / (1.0 * 1.0 + 2.0 * 2.0),
				(20.0 * 1.0 - 10.0 * 2.0) / (1.0 * 1.0 + 2.0 * 2.0)
			),
			ComplexD(10.0, 20.0) / ComplexD(1.0, 2.0)
		)
	}
	
	@Test
	fun iSquaredIsNegativeOne() {
		assertEquals(ComplexD(-1.0, 0.0), ComplexD(0.0, 1.0) * ComplexD(0.0, 1.0))
	}
	
	@Test
	fun conjugate() {
		assertEquals(ComplexD(2.0, -3.0), ComplexD(2.0, 3.0).conjugate)
	}
	
	@Test
	fun absoluteValue() {
		assertEquals(
			sqrt(3.0 * 3.0 + 4.0 * 4.0), ComplexD(3.0, 4.0).abs
		)
	}
	
	@Test
	fun sqrtOfTimesConjugateIsAbsoluteValue() {
		assertEquals(
			ComplexD(2.0, 3.0).abs,
			sqrt((ComplexD(2.0, 3.0) * ComplexD(2.0, 3.0).conjugate).r),
		)
	}
	
	@Test
	fun angle() {
		assertEquals(Math.toRadians(45.0), ComplexD(1.0, 1.0).angle, 0.001)
	}
}