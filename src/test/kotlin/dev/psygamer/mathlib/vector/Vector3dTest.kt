package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector3dTest {
	
	@Test
	fun plus() {
		assertEquals(Vector3d.ONE + Vector3d.ZERO, Vector3d.ONE)
		assertEquals(Vector3d.ONE + Vector3d.ONE, Vector3d(2.0, 2.0, 2.0))
		assertEquals(
			Vector3d(1.0 + 3.23, 2.5 + 9.31, 3.68 + 39.0),
			Vector3d(1.0, 2.5, 3.68) + Vector3d(3.23, 9.31, 39.0)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector3d.ONE - Vector3d.ZERO, Vector3d.ONE)
		assertEquals(Vector3d.ONE - Vector3d.ONE, Vector3d.ZERO)
		assertEquals(
			Vector3d(3.23 - 1.0, 9.31 - 2.5, 39.0 - 3.68),
			Vector3d(3.23, 9.31, 39.0) - Vector3d(1.0, 2.5, 3.68)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector3d.ONE * Vector3d.ZERO, Vector3d.ZERO)
		assertEquals(Vector3d.ONE * Vector3d.ONE, Vector3d.ONE)
		assertEquals(
			Vector3d(3.23 * 1.0, 9.31 * 2.5, 39.0 * 3.68),
			Vector3d(3.23, 9.31, 39.0) * Vector3d(1.0, 2.5, 3.68)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3d.ONE / Vector3d.ZERO }
		assertEquals(Vector3d.ONE / Vector3d.ONE, Vector3d.ONE)
		assertEquals(
			Vector3d(3.23 / 1.0, 9.31 / 2.5, 39.0 / 3.68),
			Vector3d(3.23, 9.31, 39.0) / Vector3d(1.0, 2.5, 3.68)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(
			Vector3d(-3.0, 6.0, -3.0),
			Vector3d(2.0, 3.0, 4.0) cross Vector3d(5.0, 6.0, 7.0)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(122.0, Vector3d(9.0, 2.0, 7.0) dot Vector3d(4.0, 8.0, 10.0))
	}
	
	@Test
	fun getMagnitude() {
		assertEquals(sqrt(14.0), Vector3d(1.0, -2.0, 3.0).magnitude)
	}
	
	@Test
	fun getMagnitudeSquared() {
		assertEquals(14.0, Vector3d(1.0, -2.0, 3.0).magnitudeSquared)
	}
	
	@Test
	fun distance() {
		assertEquals(sqrt(24.0), Vector3d(3.0, 2.0, 1.0) distanceTo Vector3d(1.0, -2.0, 3.0))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(24.0, Vector3d(3.0, 2.0, 1.0) distanceToSquared Vector3d(1.0, -2.0, 3.0))
	}
	
	@Test
	fun getNormalized() {
		assertEquals(1.0, Vector3d(1.0, 2.0, 4.0).normalized.magnitude, 0.001)
	}
	
	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0), Vector3d(1.0, 1.0, 0.0).angle, 0.001)
	}
	
	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0), Vector3d(1.0, 1.0, 0.0).angleBetween(Vector3d(1.0, 0.0, 0.0)), 0.001)
		assertEquals(Math.toRadians(00.0), Vector3d(1.0, 0.0, 0.0).angleBetween(Vector3d(1.0, 0.0, 0.0)), 0.001)
	}
	
	@Test
	fun getInverted() {
		assertEquals(
			Vector3d(-3.0, -2.5, 1.25),
			Vector3d(3.0, 2.5, -1.25).inverted
		)
	}
}