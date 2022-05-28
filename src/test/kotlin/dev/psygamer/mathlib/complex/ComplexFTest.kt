package dev.psygamer.mathlib.complex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class ComplexFTest {

	@Test
	fun plusComplexF() {
		assertEquals(
			ComplexF(2.0f, 2.0f),
			ComplexF(1.0f, 1.0f) + ComplexF(1.0f, 1.0f)
		)
		assertEquals(
			ComplexF(3.0f, 2.0f),
			ComplexF(1.0f, 2.0f) + ComplexF(2.0f, 0.0f)
		)
		assertEquals(
			ComplexF(4.0f, 5.0f),
			ComplexF(4.0f, 5.0f) + ComplexF(0.0f, 0.0f)
		)
	}

	@Test
	fun plusIsCommutative() {
		assertEquals(
			ComplexF(1.0f, 2.0f) + ComplexF(3.0f, 4.0f),
			ComplexF(3.0f, 4.0f) + ComplexF(1.0f, 2.0f)
		)
	}

	@Test
	fun minusComplexF() {
		assertEquals(
			ComplexF(0.0f, 0.0f),
			ComplexF(1.0f, 1.0f) - ComplexF(1.0f, 1.0f)
		)
		assertEquals(
			ComplexF(-1.0f, 2.0f),
			ComplexF(1.0f, 2.0f) - ComplexF(2.0f, 0.0f)
		)
		assertEquals(
			ComplexF(4.0f, 5.0f),
			ComplexF(4.0f, 5.0f) - ComplexF(0.0f, 0.0f)
		)
	}

	@Test
	fun timesScalar() {
		assertEquals(
			ComplexF(2.0f, 4.0f),
			ComplexF(1.0f, 2.0f) * 2.0f
		)
		assertEquals(
			ComplexF(0.0f, 0.0f),
			ComplexF(1.0f, 2.0f) * 0.0f
		)
	}

	@Test
	fun timesComplexF() {
		assertEquals(
			ComplexF(-5.0f, 10.0f),
			ComplexF(1.0f, 2.0f) * ComplexF(3.0f, 4.0f)
		)
	}

	@Test
	fun timesConjugate() {
		assertEquals(
			ComplexF(13.0f, 0.0f),
			ComplexF(2.0f, 3.0f) * ComplexF(2.0f, 3.0f).conjugate
		)
	}

	@Test
	fun div() {
		assertEquals(
			ComplexF(
				(10.0f * 1.0f + 20.0f * 2.0f) / (1.0f * 1.0f + 2.0f * 2.0f),
				(20.0f * 1.0f - 10.0f * 2.0f) / (1.0f * 1.0f + 2.0f * 2.0f)
			),
			ComplexF(10.0f, 20.0f) / ComplexF(1.0f, 2.0f)
		)
	}

	@Test
	fun iSquaredIsNegativeOne() {
		assertEquals(ComplexF(-1.0f, 0.0f), ComplexF(0.0f, 1.0f) * ComplexF(0.0f, 1.0f))
	}

	@Test
	fun conjugate() {
		assertEquals(ComplexF(2.0f, -3.0f), ComplexF(2.0f, 3.0f).conjugate)
	}

	@Test
	fun absoluteValue() {
		assertEquals(
			sqrt(3.0f * 3.0f + 4.0f * 4.0f), ComplexF(3.0f, 4.0f).abs
		)
	}

	@Test
	fun sqrtOfTimesConjugateIsAbsoluteValue() {
		assertEquals(
			ComplexF(2.0f, 3.0f).abs,
			sqrt((ComplexF(2.0f, 3.0f) * ComplexF(2.0f, 3.0f).conjugate).r)
		)
	}

	@Test
	fun angle() {
		assertEquals(Math.toRadians(45.0).toFloat(), ComplexF(1.0f, 1.0f).angle, 0.001f)
	}

	@Test
	fun rotors() {
		assertEquals(ComplexF(0.0f, 1.0f), ComplexF(1.0f, 0.0f).rotate(90.0f))
		assertEquals(ComplexF(0.0f, -1.0f), ComplexF(1.0f, 0.0f).rotate(-90.0f))
		assertEquals(ComplexF(-1.0f, 0.0f), ComplexF(1.0f, 0.0f).rotate(180.0f))
		assertEquals(ComplexF(1.0f, 0.0f).rotate(180.0f), ComplexF(1.0f, 0.0f).rotate(-180.0f))
		assertEquals(ComplexF(sqrt(0.5f), sqrt(0.5f)), ComplexF(1.0f, 0.0f).rotate(45.0f))
	}
}