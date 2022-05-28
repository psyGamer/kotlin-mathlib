package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector2ITest {

	@Test
	fun plus() {
		assertEquals(Vector2I.ONE + Vector2I.ZERO, Vector2I.ONE)
		assertEquals(Vector2I.ONE + Vector2I.ONE, Vector2I(2, 2))
		assertEquals(
			Vector2I(1 + 3, 2 + 9),
			Vector2I(1, 2) + Vector2I(3, 9)
		)
	}

	@Test
	fun minus() {
		assertEquals(Vector2I.ONE - Vector2I.ZERO, Vector2I.ONE)
		assertEquals(Vector2I.ONE - Vector2I.ONE, Vector2I.ZERO)
		assertEquals(
			Vector2I(3 - 1, 9 - 2),
			Vector2I(3, 9) - Vector2I(1, 2)
		)
	}

	@Test
	fun times() {
		assertEquals(Vector2I.ONE * Vector2I.ZERO, Vector2I.ZERO)
		assertEquals(Vector2I.ONE * Vector2I.ONE, Vector2I.ONE)
		assertEquals(
			Vector2I(3 * 1, 9 * 2),
			Vector2I(3, 9) * Vector2I(1, 2)
		)
	}

	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector2I.ONE / Vector2I.ZERO }
		assertEquals(Vector2I.ONE / Vector2I.ONE, Vector2I.ONE)
		assertEquals(
			Vector2I(3 / 1, 9 / 2),
			Vector2I(3, 9) / Vector2I(1, 2)
		)
	}

	@Test
	fun dot() {
		assertEquals(52, Vector2I(9, 2) dot Vector2I(4, 8))
	}

	@Test
	fun getMagnitude() {
		assertEquals(sqrt(5.0).toFloat(), Vector2I(1, -2).magnitude, 0.001f)
	}

	@Test
	fun getMagnitudeSquared() {
		assertEquals(5, Vector2I(1, -2).magnitudeSquared)
	}

	@Test
	fun distance() {
		assertEquals(sqrt(20.0).toFloat(), Vector2I(3, 2) distanceTo Vector2I(1, -2), 0.001f)
	}

	@Test
	fun distanceSquared() {
		assertEquals(20, Vector2I(3, 2) distanceToSquared Vector2I(1, -2))
	}

	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector2I(1, 2).normalized.magnitude, 0.001f)
	}

	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2I(1, 1).angle, 0.001f)
	}

	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2I(1, 1).angleBetween(Vector2I(1, 0)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector2I(1, 0).angleBetween(Vector2I(1, 0)), 0.001f)
	}

	@Test
	fun getInverted() {
		assertEquals(
			Vector2I(-3, 2),
			Vector2I(3, -2).inverted
		)
	}
}