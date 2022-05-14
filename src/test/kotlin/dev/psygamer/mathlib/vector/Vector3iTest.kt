package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector3iTest {
	
	@Test
	fun plus() {
		assertEquals(Vector3i.ONE + Vector3i.ZERO, Vector3i.ONE)
		assertEquals(Vector3i.ONE + Vector3i.ONE, Vector3i(2, 2, 2))
		assertEquals(
			Vector3i(1 + 3, 2 + 9, 3 + 39),
			Vector3i(1, 2, 3) + Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector3i.ONE - Vector3i.ZERO, Vector3i.ONE)
		assertEquals(Vector3i.ONE - Vector3i.ONE, Vector3i.ZERO)
		assertEquals(
			Vector3i(3 - 1, 9 - 2, 39 - 3),
			Vector3i(3, 9, 39) - Vector3i(1, 2, 3)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector3i.ONE * Vector3i.ZERO, Vector3i.ZERO)
		assertEquals(Vector3i.ONE * Vector3i.ONE, Vector3i.ONE)
		assertEquals(
			Vector3i(3 * 1, 9 * 2, 39 * 3),
			Vector3i(3, 9, 39) * Vector3i(1, 2, 3)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3i.ONE / Vector3i.ZERO }
		assertEquals(Vector3i.ONE / Vector3i.ONE, Vector3i.ONE)
		assertEquals(
			Vector3i(3 / 1, 9 / 2, 39 / 3),
			Vector3i(3, 9, 39) / Vector3i(1, 2, 3)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(
			Vector3i(-3, 6, -3),
			Vector3i(2, 3, 4) cross Vector3i(5, 6, 7)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(122, Vector3i(9, 2, 7) dot Vector3i(4, 8, 10))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(14.0).toFloat(), Vector3i(1, -2, 3).magnitude, 0.001f)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(14, Vector3i(1, -2, 3).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(24.0).toFloat(), Vector3i(3, 2, 1) distanceTo Vector3i(1, -2, 3), 0.001f)
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(24, Vector3i(3, 2, 1) distanceToSquared Vector3i(1, -2, 3))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector3i(1, 2, 4).normalized.magnitude, 0.001f)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector3i(1, 1, 0).angle, 0.001f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector3i(1, 1, 0).angleBetween(Vector3i(1, 0, 0)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector3i(1, 0, 0).angleBetween(Vector3i(1, 0, 0)), 0.001f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector3i(-3, -2, 1),
			Vector3i(3, 2, -1).inverted
		)
	}
}