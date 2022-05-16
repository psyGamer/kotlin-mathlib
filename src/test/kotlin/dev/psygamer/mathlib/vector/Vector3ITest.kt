package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector3ITest {
	
	@Test
	fun plus() {
		assertEquals(Vector3I.ONE + Vector3I.ZERO, Vector3I.ONE)
		assertEquals(Vector3I.ONE + Vector3I.ONE, Vector3I(2, 2, 2))
		assertEquals(
			Vector3I(1 + 3, 2 + 9, 3 + 39),
			Vector3I(1, 2, 3) + Vector3I(3, 9, 39)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector3I.ONE - Vector3I.ZERO, Vector3I.ONE)
		assertEquals(Vector3I.ONE - Vector3I.ONE, Vector3I.ZERO)
		assertEquals(
			Vector3I(3 - 1, 9 - 2, 39 - 3),
			Vector3I(3, 9, 39) - Vector3I(1, 2, 3)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector3I.ONE * Vector3I.ZERO, Vector3I.ZERO)
		assertEquals(Vector3I.ONE * Vector3I.ONE, Vector3I.ONE)
		assertEquals(
			Vector3I(3 * 1, 9 * 2, 39 * 3),
			Vector3I(3, 9, 39) * Vector3I(1, 2, 3)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3I.ONE / Vector3I.ZERO }
		assertEquals(Vector3I.ONE / Vector3I.ONE, Vector3I.ONE)
		assertEquals(
			Vector3I(3 / 1, 9 / 2, 39 / 3),
			Vector3I(3, 9, 39) / Vector3I(1, 2, 3)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(
			Vector3I(-3, 6, -3),
			Vector3I(2, 3, 4) cross Vector3I(5, 6, 7)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(122, Vector3I(9, 2, 7) dot Vector3I(4, 8, 10))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(14.0).toFloat(), Vector3I(1, -2, 3).magnitude, 0.001f)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(14, Vector3I(1, -2, 3).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(24.0).toFloat(), Vector3I(3, 2, 1) distanceTo Vector3I(1, -2, 3), 0.001f)
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(24, Vector3I(3, 2, 1) distanceToSquared Vector3I(1, -2, 3))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector3I(1, 2, 4).normalized.magnitude, 0.001f)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector3I(1, 1, 0).angle, 0.001f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector3I(1, 1, 0).angleBetween(Vector3I(1, 0, 0)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector3I(1, 0, 0).angleBetween(Vector3I(1, 0, 0)), 0.001f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector3I(-3, -2, 1),
			Vector3I(3, 2, -1).inverted
		)
	}
}