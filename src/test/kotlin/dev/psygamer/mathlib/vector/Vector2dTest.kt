package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector2dTest {
	
	@Test
	fun plus() {
		assertEquals(Vector2d.ONE + Vector2d.ZERO, Vector2d.ONE)
		assertEquals(Vector2d.ONE + Vector2d.ONE, Vector2d(2.0, 2.0))
		assertEquals(
			Vector2d(1.0 + 3.23, 2.5 + 9.31),
			Vector2d(1.0, 2.5) + Vector2d(3.23, 9.31)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector2d.ONE - Vector2d.ZERO, Vector2d.ONE)
		assertEquals(Vector2d.ONE - Vector2d.ONE, Vector2d.ZERO)
		assertEquals(
			Vector2d(3.23 - 1.0, 9.31 - 2.5),
			Vector2d(3.23, 9.31) - Vector2d(1.0, 2.5)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector2d.ONE * Vector2d.ZERO, Vector2d.ZERO)
		assertEquals(Vector2d.ONE * Vector2d.ONE, Vector2d.ONE)
		assertEquals(
			Vector2d(3.23 * 1.0, 9.31 * 2.5),
			Vector2d(3.23, 9.31) * Vector2d(1.0, 2.5)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector2d.ONE / Vector2d.ZERO }
		assertEquals(Vector2d.ONE / Vector2d.ONE, Vector2d.ONE)
		assertEquals(
			Vector2d(3.23 / 1.0, 9.31 / 2.5),
			Vector2d(3.23, 9.31) / Vector2d(1.0, 2.5)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(52.0, Vector2d(9.0, 2.0) dot Vector2d(4.0, 8.0))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(5.0), Vector2d(1.0, -2.0).magnitude)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(5.0, Vector2d(1.0, -2.0).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(20.0), Vector2d(3.0, 2.0).distance(Vector2d(1.0, -2.0)))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(20.0, Vector2d(3.0, 2.0).distanceSquared(Vector2d(1.0, -2.0)))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0, Vector2d(1.0, 2.0).normalized.magnitude, 0.001)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0), Vector2d(1.0, 1.0).angle, 0.001)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0), Vector2d(1.0, 1.0).angleBetween(Vector2d(1.0, 0.0)), 0.001)
		assertEquals(Math.toRadians(00.0), Vector2d(1.0, 0.0).angleBetween(Vector2d(1.0, 0.0)), 0.001)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector2d(-3.0, 2.5),
			Vector2d(3.0, -2.5).inverted
		)
	}
}