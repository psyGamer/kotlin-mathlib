package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector2iTest {
	
	@Test
	fun plus() {
		assertEquals(Vector2i.ONE + Vector2i.ZERO, Vector2i.ONE)
		assertEquals(Vector2i.ONE + Vector2i.ONE, Vector2i(2, 2))
		assertEquals(
			Vector2i(1 + 3, 2 + 9),
			Vector2i(1, 2) + Vector2i(3, 9)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector2i.ONE - Vector2i.ZERO, Vector2i.ONE)
		assertEquals(Vector2i.ONE - Vector2i.ONE, Vector2i.ZERO)
		assertEquals(
			Vector2i(3 - 1, 9 - 2),
			Vector2i(3, 9) - Vector2i(1, 2)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector2i.ONE * Vector2i.ZERO, Vector2i.ZERO)
		assertEquals(Vector2i.ONE * Vector2i.ONE, Vector2i.ONE)
		assertEquals(
			Vector2i(3 * 1, 9 * 2),
			Vector2i(3, 9) * Vector2i(1, 2)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector2i.ONE / Vector2i.ZERO }
		assertEquals(Vector2i.ONE / Vector2i.ONE, Vector2i.ONE)
		assertEquals(
			Vector2i(3 / 1, 9 / 2),
			Vector2i(3, 9) / Vector2i(1, 2)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(
			Vector2i(-3, 6),
			Vector2i(2, 3) cross Vector2i(5, 6)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(122, Vector2i(9, 2) dot Vector2i(4, 8))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(5.0).toFloat(), Vector2i(1, -2).magnitude, 0.001f)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(5, Vector2i(1, -2).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(20.0).toFloat(), Vector2i(3, 2).distance(Vector2i(1, -2)), 0.001f)
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(20, Vector2i(3, 2).distanceSquared(Vector2i(1, -2)))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector2i(1, 2).normalized.magnitude, 0.001f)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2i(1, 1).angle, 0.001f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2i(1, 1).angleBetween(Vector2i(1, 0)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector2i(1, 0).angleBetween(Vector2i(1, 0)), 0.001f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector2i(-3, 2),
			Vector2i(3, -2).inverted
		)
	}
}