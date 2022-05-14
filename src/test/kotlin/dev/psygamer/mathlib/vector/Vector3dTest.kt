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
		assertEquals(
			Vector3d(1.0 + 3.23f, 2.5 + 9.31f, 3.68 + 39.0f),
			Vector3d(1.0, 2.5, 3.68) + Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3d(1.0 + 3, 2.5 + 9, 3.68 + 39),
			Vector3d(1.0, 2.5, 3.68) + Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(Vector3d.ONE - Vector3d.ZERO, Vector3d.ONE)
		assertEquals(Vector3d.ONE - Vector3d.ONE, Vector3d.ZERO)
		
		assertEquals(
			Vector3d(1.0 - 3.23, 2.5 - 9.31, 3.68 - 39.0),
			Vector3d(1.0, 2.5, 3.68) - Vector3d(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3d(1.0 - 3.23f, 2.5 - 9.31f, 3.68 - 39.0f),
			Vector3d(1.0, 2.5, 3.68) - Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3d(1.0 - 3, 2.5 - 9, 3.68 - 39),
			Vector3d(1.0, 2.5, 3.68) - Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun times() {
		assertEquals(Vector3d.ONE * Vector3d.ZERO, Vector3d.ZERO)
		assertEquals(Vector3d.ONE * Vector3d.ONE, Vector3d.ONE)
		
		assertEquals(
			Vector3d(1.0 * 3.23, 2.5 * 9.31, 3.68 * 39.0),
			Vector3d(1.0, 2.5, 3.68) * Vector3d(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3d(1.0 * 3.23f, 2.5 * 9.31f, 3.68 * 39.0f),
			Vector3d(1.0, 2.5, 3.68) * Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3d(1.0 * 3, 2.5 * 9, 3.68 * 39),
			Vector3d(1.0, 2.5, 3.68) * Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3d.ONE / Vector3d.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector3d.ONE / Vector3f.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector3d.ONE / Vector3i.ZERO }
		assertEquals(Vector3d.ONE / Vector3d.ONE, Vector3d.ONE)
		
		assertEquals(
			Vector3d(1.0 / 3.23, 2.5 / 9.31, 3.68 / 39.0),
			Vector3d(1.0, 2.5, 3.68) / Vector3d(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3d(1.0 / 3.23f, 2.5 / 9.31f, 3.68 / 39.0f),
			Vector3d(1.0, 2.5, 3.68) / Vector3f(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3d(1.0 / 3, 2.5 / 9, 3.68 / 39),
			Vector3d(1.0, 2.5, 3.68) / Vector3i(3, 9, 39)
		)
	}
	
	@Test
	fun cross() {
		assertEquals(
			Vector3d(-3.0, 6.0, -3.0),
			Vector3d(2.0, 3.0, 4.0) cross Vector3d(5.0, 6.0, 7.0)
		)
		assertEquals(
			Vector3d(-3.0, 6.0, -3.0),
			Vector3d(2.0, 3.0, 4.0) cross Vector3f(5.0f, 6.0f, 7.0f)
		)
		assertEquals(
			Vector3d(-3.0, 6.0, -3.0),
			Vector3d(2.0, 3.0, 4.0) cross Vector3i(5, 6, 7)
		)
	}
	
	@Test
	fun dot() {
		assertEquals(122.0, Vector3d(9.0, 2.0, 7.0) dot Vector3d(4.0, 8.0, 10.0))
		assertEquals(122.0, Vector3d(9.0, 2.0, 7.0) dot Vector3f(4.0f, 8.0f, 10.0f))
		assertEquals(122.0, Vector3d(9.0, 2.0, 7.0) dot Vector3i(4, 8, 10))
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
		assertEquals(sqrt(24.0), Vector3d(3.0, 2.0, 1.0) distanceTo Vector3f(1.0f, -2.0f, 3.0f))
		assertEquals(sqrt(24.0), Vector3d(3.0, 2.0, 1.0) distanceTo Vector3i(1, -2, 3))
	}
	
	@Test
	fun distanceSquared() {
		assertEquals(24.0, Vector3d(3.0, 2.0, 1.0) distanceToSquared Vector3d(1.0, -2.0, 3.0))
		assertEquals(24.0, Vector3d(3.0, 2.0, 1.0) distanceToSquared Vector3f(1.0f, -2.0f, 3.0f))
		assertEquals(24.0, Vector3d(3.0, 2.0, 1.0) distanceToSquared Vector3i(1, -2, 3))
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