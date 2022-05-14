package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector2fTest {
	
	@Test
	fun plus() {
		assertEquals(Vector2f.ONE + Vector2f.ZERO, Vector2f.ONE)
		assertEquals(Vector2f.ONE + Vector2f.ONE, Vector2f(2.0f, 2.0f))
		
		assertEquals(
			Vector2f(3.23f + 1.0f, 9.31f + 2.5f),
			Vector2f(3.23f, 9.31f) + Vector2f(1.0f, 2.5f)
		)
		assertEquals(
			Vector2f(3.23f + 1, 9.31f + 2),
			Vector2f(3.23f, 9.31f) + Vector2i(1, 2)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector2f.ONE - Vector2f.ZERO, Vector2f.ONE)
		assertEquals(Vector2f.ONE - Vector2f.ONE, Vector2f.ZERO)
		
		assertEquals(
			Vector2f(3.23f - 1.0f, 9.31f - 2.5f),
			Vector2f(3.23f, 9.31f) - Vector2f(1.0f, 2.5f)
		)
		assertEquals(
			Vector2f(3.23f - 1, 9.31f - 2),
			Vector2f(3.23f, 9.31f) - Vector2i(1, 2)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector2f.ONE * Vector2f.ZERO, Vector2f.ZERO)
		assertEquals(Vector2f.ONE * Vector2f.ONE, Vector2f.ONE)
		
		assertEquals(
			Vector2f(3.23f * 1.0f, 9.31f * 2.5f),
			Vector2f(3.23f, 9.31f) * Vector2f(1.0f, 2.5f)
		)
		assertEquals(
			Vector2f(3.23f * 1, 9.31f * 2),
			Vector2f(3.23f, 9.31f) * Vector2i(1, 2)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector2f.ONE / Vector2f.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector2f.ONE / Vector2i.ZERO }
		assertEquals(Vector2f.ONE / Vector2f.ONE, Vector2f.ONE)
		
		assertEquals(
			Vector2f(3.23f * 1.0f, 9.31f * 2.5f),
			Vector2f(3.23f, 9.31f) * Vector2f(1.0f, 2.5f)
		)
		assertEquals(
			Vector2f(3.23f * 1, 9.31f * 2),
			Vector2f(3.23f, 9.31f) * Vector2i(1, 2)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(52.0f, Vector2f(9.0f, 2.0f) dot Vector2f(4.0f, 8.0f))
		assertEquals(52.0f, Vector2f(9.0f, 2.0f) dot Vector2i(4, 8))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(5.0f), Vector2f(1.0f, -2.0f).magnitude)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(5.0f, Vector2f(1.0f, -2.0f).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(20.0f), Vector2f(3.0f, 2.0f) distanceTo Vector2f(1.0f, -2.0f))
		assertEquals(sqrt(20.0f), Vector2f(3.0f, 2.0f) distanceTo Vector2i(1, -2))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(20.0f, Vector2f(3.0f, 2.0f) distanceToSquared (Vector2f(1.0f, -2.0f)))
		assertEquals(20.0f, Vector2f(3.0f, 2.0f) distanceToSquared (Vector2i(1, -2)))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector2f(1.0f, 2.0f).normalized.magnitude, 0.001f)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2f(1.0f, 1.0f).angle, 0.001f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2f(1.0f, 1.0f).angleBetween(Vector2f(1.0f, 0.0f)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector2f(1.0f, 0.0f).angleBetween(Vector2f(1.0f, 0.0f)), 0.001f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector2f(-3.0f, 2.5f),
			Vector2f(3.0f, -2.5f).inverted
		)
	}
}