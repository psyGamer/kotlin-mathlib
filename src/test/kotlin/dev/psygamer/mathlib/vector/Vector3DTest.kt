package dev.psygamer.mathlib.vector

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.sqrt

internal class Vector3DTest {

	@Test
	fun plus() {
		assertEquals(Vector3D.ONE + Vector3D.ZERO, Vector3D.ONE)
		assertEquals(Vector3D.ONE + Vector3D.ONE, Vector3D(2.0, 2.0, 2.0))

		assertEquals(
			Vector3D(1.0 + 3.23, 2.5 + 9.31, 3.68 + 39.0),
			Vector3D(1.0, 2.5, 3.68) + Vector3D(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3D(1.0 + 3.23f, 2.5 + 9.31f, 3.68 + 39.0f),
			Vector3D(1.0, 2.5, 3.68) + Vector3F(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3D(1.0 + 3, 2.5 + 9, 3.68 + 39),
			Vector3D(1.0, 2.5, 3.68) + Vector3I(3, 9, 39)
		)
	}

	@Test
	fun minus() {
		assertEquals(Vector3D.ONE - Vector3D.ZERO, Vector3D.ONE)
		assertEquals(Vector3D.ONE - Vector3D.ONE, Vector3D.ZERO)

		assertEquals(
			Vector3D(1.0 - 3.23, 2.5 - 9.31, 3.68 - 39.0),
			Vector3D(1.0, 2.5, 3.68) - Vector3D(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3D(1.0 - 3.23f, 2.5 - 9.31f, 3.68 - 39.0f),
			Vector3D(1.0, 2.5, 3.68) - Vector3F(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3D(1.0 - 3, 2.5 - 9, 3.68 - 39),
			Vector3D(1.0, 2.5, 3.68) - Vector3I(3, 9, 39)
		)
	}

	@Test
	fun times() {
		assertEquals(Vector3D.ONE * Vector3D.ZERO, Vector3D.ZERO)
		assertEquals(Vector3D.ONE * Vector3D.ONE, Vector3D.ONE)

		assertEquals(
			Vector3D(1.0 * 3.23, 2.5 * 9.31, 3.68 * 39.0),
			Vector3D(1.0, 2.5, 3.68) * Vector3D(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3D(1.0 * 3.23f, 2.5 * 9.31f, 3.68 * 39.0f),
			Vector3D(1.0, 2.5, 3.68) * Vector3F(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3D(1.0 * 3, 2.5 * 9, 3.68 * 39),
			Vector3D(1.0, 2.5, 3.68) * Vector3I(3, 9, 39)
		)
	}

	@Test
	fun div() {
		assertThrows(ArithmeticException::class.java) { Vector3D.ONE / Vector3D.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector3D.ONE / Vector3F.ZERO }
		assertThrows(ArithmeticException::class.java) { Vector3D.ONE / Vector3I.ZERO }
		assertEquals(Vector3D.ONE / Vector3D.ONE, Vector3D.ONE)

		assertEquals(
			Vector3D(1.0 / 3.23, 2.5 / 9.31, 3.68 / 39.0),
			Vector3D(1.0, 2.5, 3.68) / Vector3D(3.23, 9.31, 39.0)
		)
		assertEquals(
			Vector3D(1.0 / 3.23f, 2.5 / 9.31f, 3.68 / 39.0f),
			Vector3D(1.0, 2.5, 3.68) / Vector3F(3.23f, 9.31f, 39.0f)
		)
		assertEquals(
			Vector3D(1.0 / 3, 2.5 / 9, 3.68 / 39),
			Vector3D(1.0, 2.5, 3.68) / Vector3I(3, 9, 39)
		)
	}

	@Test
	fun cross() {
		assertEquals(
			Vector3D(-3.0, 6.0, -3.0),
			Vector3D(2.0, 3.0, 4.0) cross Vector3D(5.0, 6.0, 7.0)
		)
		assertEquals(
			Vector3D(-3.0, 6.0, -3.0),
			Vector3D(2.0, 3.0, 4.0) cross Vector3F(5.0f, 6.0f, 7.0f)
		)
		assertEquals(
			Vector3D(-3.0, 6.0, -3.0),
			Vector3D(2.0, 3.0, 4.0) cross Vector3I(5, 6, 7)
		)
	}

	@Test
	fun dot() {
		assertEquals(122.0, Vector3D(9.0, 2.0, 7.0) dot Vector3D(4.0, 8.0, 10.0))
		assertEquals(122.0, Vector3D(9.0, 2.0, 7.0) dot Vector3F(4.0f, 8.0f, 10.0f))
		assertEquals(122.0, Vector3D(9.0, 2.0, 7.0) dot Vector3I(4, 8, 10))
	}

	@Test
	fun getMagnitude() {
		assertEquals(sqrt(14.0), Vector3D(1.0, -2.0, 3.0).magnitude)
	}

	@Test
	fun getMagnitudeSquared() {
		assertEquals(14.0, Vector3D(1.0, -2.0, 3.0).magnitudeSquared)
	}

	@Test
	fun distance() {
		assertEquals(sqrt(24.0), Vector3D(3.0, 2.0, 1.0) distanceTo Vector3D(1.0, -2.0, 3.0))
		assertEquals(sqrt(24.0), Vector3D(3.0, 2.0, 1.0) distanceTo Vector3F(1.0f, -2.0f, 3.0f))
		assertEquals(sqrt(24.0), Vector3D(3.0, 2.0, 1.0) distanceTo Vector3I(1, -2, 3))
	}

	@Test
	fun distanceSquared() {
		assertEquals(24.0, Vector3D(3.0, 2.0, 1.0) distanceToSquared Vector3D(1.0, -2.0, 3.0))
		assertEquals(24.0, Vector3D(3.0, 2.0, 1.0) distanceToSquared Vector3F(1.0f, -2.0f, 3.0f))
		assertEquals(24.0, Vector3D(3.0, 2.0, 1.0) distanceToSquared Vector3I(1, -2, 3))
	}

	@Test
	fun getNormalized() {
		assertEquals(1.0, Vector3D(1.0, 2.0, 4.0).normalized.magnitude, 0.001)
	}

	@Test
	fun getAngle() {
		assertEquals(Math.toRadians(45.0), Vector3D(1.0, 1.0, 0.0).angle, 0.001)
	}

	@Test
	fun angleBetween() {
		assertEquals(Math.toRadians(45.0), Vector3D(1.0, 1.0, 0.0).angleBetween(Vector3D(1.0, 0.0, 0.0)), 0.001)
		assertEquals(Math.toRadians(00.0), Vector3D(1.0, 0.0, 0.0).angleBetween(Vector3D(1.0, 0.0, 0.0)), 0.001)
	}

	@Test
	fun getInverted() {
		assertEquals(
			Vector3D(-3.0, -2.5, 1.25),
			Vector3D(3.0, 2.5, -1.25).inverted
		)
	}
}