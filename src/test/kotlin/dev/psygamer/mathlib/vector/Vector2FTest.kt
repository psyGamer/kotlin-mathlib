package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector2FTest {
	
	@Test
	fun plus() {
		assertEquals(Vector2F.ONE + Vector2F.ZERO, Vector2F.ONE)
		assertEquals(Vector2F.ONE + Vector2F.ONE, Vector2F(2.0f, 2.0f))
		
		assertEquals(
			Vector2F(3.23f + 1.0f, 9.31f + 2.5f),
			Vector2F(3.23f, 9.31f) + Vector2F(1.0f, 2.5f)
		)
		assertEquals(
			Vector2F(3.23f + 1, 9.31f + 2),
			Vector2F(3.23f, 9.31f) + Vector2I(1, 2)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector2F.ONE - Vector2F.ZERO, Vector2F.ONE)
		assertEquals(Vector2F.ONE - Vector2F.ONE, Vector2F.ZERO)
		
		assertEquals(
			Vector2F(3.23f - 1.0f, 9.31f - 2.5f),
			Vector2F(3.23f, 9.31f) - Vector2F(1.0f, 2.5f)
		)
		assertEquals(
			Vector2F(3.23f - 1, 9.31f - 2),
			Vector2F(3.23f, 9.31f) - Vector2I(1, 2)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector2F.ONE * Vector2F.ZERO, Vector2F.ZERO)
		assertEquals(Vector2F.ONE * Vector2F.ONE, Vector2F.ONE)
		
		assertEquals(
			Vector2F(3.23f * 1.0f, 9.31f * 2.5f),
			Vector2F(3.23f, 9.31f) * Vector2F(1.0f, 2.5f)
		)
		assertEquals(
			Vector2F(3.23f * 1, 9.31f * 2),
			Vector2F(3.23f, 9.31f) * Vector2I(1, 2)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector2F.ONE / Vector2F.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector2F.ONE / Vector2I.ZERO }
		assertEquals(Vector2F.ONE / Vector2F.ONE, Vector2F.ONE)
		
		assertEquals(
			Vector2F(3.23f * 1.0f, 9.31f * 2.5f),
			Vector2F(3.23f, 9.31f) * Vector2F(1.0f, 2.5f)
		)
		assertEquals(
			Vector2F(3.23f * 1, 9.31f * 2),
			Vector2F(3.23f, 9.31f) * Vector2I(1, 2)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(52.0f, Vector2F(9.0f, 2.0f) dot Vector2F(4.0f, 8.0f))
		assertEquals(52.0f, Vector2F(9.0f, 2.0f) dot Vector2I(4, 8))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(5.0f), Vector2F(1.0f, -2.0f).magnitude)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(5.0f, Vector2F(1.0f, -2.0f).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(20.0f), Vector2F(3.0f, 2.0f) distanceTo Vector2F(1.0f, -2.0f))
		assertEquals(sqrt(20.0f), Vector2F(3.0f, 2.0f) distanceTo Vector2I(1, -2))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(20.0f, Vector2F(3.0f, 2.0f) distanceToSquared (Vector2F(1.0f, -2.0f)))
		assertEquals(20.0f, Vector2F(3.0f, 2.0f) distanceToSquared (Vector2I(1, -2)))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector2F(1.0f, 2.0f).normalized.magnitude, 0.001f)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2F(1.0f, 1.0f).angle, 0.001f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector2F(1.0f, 1.0f).angleBetween(Vector2F(1.0f, 0.0f)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector2F(1.0f, 0.0f).angleBetween(Vector2F(1.0f, 0.0f)), 0.001f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector2F(-3.0f, 2.5f),
			Vector2F(3.0f, -2.5f).inverted
		)
	}
}