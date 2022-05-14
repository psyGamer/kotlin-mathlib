package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector3fTest {
	
	@Test
	fun plus() {
		assertEquals(Vector3f.ONE + Vector3f.ZERO, Vector3f.ONE)
		assertEquals(Vector3f.ONE + Vector3f.ONE, Vector3f(2.0f, 2.0f, 2.0f))
		
		assertEquals(
			Vector3f(1.0f + 3.23f, 2.5f + 9.31f, 3.68f + 39.0f),
			Vector3f(1.0f, 2.5f, 3.68f) + Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3f(1.0f + 3, 2.5f + 9, 3.68f + 39),
			Vector3f(1.0f, 2.5f, 3.68f) + Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector3f.ONE - Vector3f.ZERO, Vector3f.ONE)
		assertEquals(Vector3f.ONE - Vector3f.ONE, Vector3f.ZERO)
		
		assertEquals(
			Vector3f(1.0f - 3.23f, 2.5f - 9.31f, 3.68f - 39.0f),
			Vector3f(1.0f, 2.5f, 3.68f) - Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3f(1.0f - 3, 2.5f - 9, 3.68f - 39),
			Vector3f(1.0f, 2.5f, 3.68f) - Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector3f.ONE * Vector3f.ZERO, Vector3f.ZERO)
		assertEquals(Vector3f.ONE * Vector3f.ONE, Vector3f.ONE)
		
		assertEquals(
			Vector3f(1.0f * 3.23f, 2.5f * 9.31f, 3.68f * 39.0f),
			Vector3f(1.0f, 2.5f, 3.68f) * Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3f(1.0f * 3, 2.5f * 9, 3.68f * 39),
			Vector3f(1.0f, 2.5f, 3.68f) * Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3f.ONE / Vector3f.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector3f.ONE / Vector3i.ZERO }
		assertEquals(Vector3f.ONE / Vector3f.ONE, Vector3f.ONE)
		
		assertEquals(
			Vector3f(1.0f / 3.23f, 2.5f / 9.31f, 3.68f / 39.0f),
			Vector3f(1.0f, 2.5f, 3.68f) / Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3f(1.0f / 3, 2.5f / 9, 3.68f / 39),
			Vector3f(1.0f, 2.5f, 3.68f) / Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(
			Vector3f(-3.0f, 6.0f, -3.0f),
			Vector3f(2.0f, 3.0f, 4.0f) cross Vector3f(5.0f, 6.0f, 7.0f)
		)
		assertEquals(
			Vector3f(-3.0f, 6.0f, -3.0f),
			Vector3f(2.0f, 3.0f, 4.0f) cross Vector3i(5, 6, 7)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(122.0f, Vector3f(9.0f, 2.0f, 7.0f) dot Vector3f(4.0f, 8.0f, 10.0f))
		assertEquals(122.0f, Vector3f(9.0f, 2.0f, 7.0f) dot Vector3i(4, 8, 10))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(14.0f), Vector3f(1.0f, -2.0f, 3.0f).magnitude)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(14.0f, Vector3f(1.0f, -2.0f, 3.0f).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(24.0).toFloat(), Vector3f(3.0f, 2.0f, 1.0f) distanceTo Vector3f(1.0f, -2.0f, 3.0f))
		assertEquals(sqrt(24.0).toFloat(), Vector3f(3.0f, 2.0f, 1.0f) distanceTo Vector3i(1, -2, 3))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(24.0f, Vector3f(3.0f, 2.0f, 1.0f) distanceToSquared Vector3f(1.0f, -2.0f, 3.0f))
		assertEquals(24.0f, Vector3f(3.0f, 2.0f, 1.0f) distanceToSquared Vector3i(1, -2, 3))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0f, Vector3f(1.0f, 2.0f, 4.0f).normalized.magnitude, 0.001f)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector3f(1.0f, 1.0f, 0.0f).angle, 0.001f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0).toFloat(), Vector3f(1.0f, 1.0f, 0.0f).angleBetween(Vector3f(1.0f, 0.0f, 0.0f)), 0.001f)
		assertEquals(Math.toRadians(00.0).toFloat(), Vector3f(1.0f, 0.0f, 0.0f).angleBetween(Vector3f(1.0f, 0.0f, 0.0f)), 0.001f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector3f(-3.0f, -2.5f, 1.25f),
			Vector3f(3.0f, 2.5f, -1.25f).inverted
		)
	}
}