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
			Vector3f(1.0f, 2.5f, 3.68f) + Vector3f(3.23f, 9.31f, 39.0f), Vector3f(1.0f + 3.23f, 2.5f + 9.31f, 3.68f + 39.0f)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector3f.ONE - Vector3f.ZERO, Vector3f.ONE)
		assertEquals(Vector3f.ONE - Vector3f.ONE, Vector3f.ZERO)
		assertEquals(
			Vector3f(3.23f, 9.31f, 39.0f) - Vector3f(1.0f, 2.5f, 3.68f), Vector3f(3.23f - 1.0f, 9.31f - 2.5f, 39.0f - 3.68f)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector3f.ONE * Vector3f.ZERO, Vector3f.ZERO)
		assertEquals(Vector3f.ONE * Vector3f.ONE, Vector3f.ONE)
		assertEquals(
			Vector3f(3.23f, 9.31f, 39.0f) * Vector3f(1.0f, 2.5f, 3.68f), Vector3f(3.23f * 1.0f, 9.31f * 2.5f, 39.0f * 3.68f)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3f.ONE / Vector3f.ZERO }
		assertEquals(Vector3f.ONE / Vector3f.ONE, Vector3f.ONE)
		assertEquals(
			Vector3f(3.23f, 9.31f, 39.0f) / Vector3f(1.0f, 2.5f, 3.68f), Vector3f(3.23f / 1.0f, 9.31f / 2.5f, 39.0f / 3.68f)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(Vector3f(2.0f, 3.0f, 4.0f) cross Vector3f(5.0f, 6.0f, 7.0f), Vector3f(-3.0f, 6.0f, -3.0f))
	}
	
	@Test
	fun dot() {
		assertEquals(Vector3f(9.0f, 2.0f, 7.0f) dot Vector3f(4.0f, 8.0f, 10.0f), 122)
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(Vector3f(1.0f, -2.0f, 3.0f).magnitude, sqrt(14.0f))
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(Vector3f(1.0f, -2.0f, 3.0f).magnitudeSquared, 14.0f)
	}
	
	@Test
	fun distance() {
		assertEquals(Vector3f(3.0f, 2.0f, 1.0f).distance(Vector3f(1.0f, -2.0f, 3.0f)), sqrt(24.0f))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(Vector3f(3.0f, 2.0f, 1.0f).distance(Vector3f(1.0f, -2.0f, 3.0f)), 24.0f)
	}
	
	@Test
	fun getNormalized() {
		assertEquals(Vector3f(1.0f, 2.0f, 4.0f).normalized, Vector3f(0.25f, 0.5f, 1.0f))
	}
	
	@Test
	fun getAngle() {
		assertEquals(Vector3f(1.0f, 1.0f, 0.0f).angle, 45.0f)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Vector3f(1.0f, 1.0f, 0.0f).angleBetween(Vector3f(1.0f, 0.0f, 0.0f)), 45.0f)
		assertEquals(Vector3f(1.0f, 0.0f, 0.0f).angleBetween(Vector3f(1.0f, 0.0f, 0.0f)), 45.0f)
	}
	
	@Test
	fun getInverted() {
		assertEquals(Vector3f(3.0f, 2.5f, -1.25f).inverted, Vector3f(-3.0f, -2.5f, 1.25f))
	}
}