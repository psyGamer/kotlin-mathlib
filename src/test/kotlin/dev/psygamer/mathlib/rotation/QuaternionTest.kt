package dev.psygamer.mathlib.rotation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class QuaternionTest {
	
	@Test
	fun alternativeAccessors() {
		val q = Quaternion(1.0f, 2.0f, 1.25f, 0.2f)
		assertEquals(q.r, q.w)
		assertEquals(q.i, q.x)
		assertEquals(q.j, q.y)
		assertEquals(q.k, q.z)
		
		assertEquals(q.real, q.r)
	}
	
	@Test
	fun plus() {
		assertEquals(
			Quaternion(2.0f + 3.0f, 3.5f + 1.5f, 1.2f + 0.7f, 4.2f + 6.9f),
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f) + Quaternion(3.0f, 1.5f, 0.7f, 6.9f)
		)
	}
	
	@Test
	fun minus() {
		assertEquals(
			Quaternion(2.0f - 3.0f, 3.5f - 1.5f, 1.2f - 0.7f, 4.2f - 6.9f),
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f) - Quaternion(3.0f, 1.5f, 0.7f, 6.9f)
		)
	}
	
	@Test
	fun times() {
		assertEquals(
			Quaternion(
				+2.0f * 6.9f + 3.5f * 0.7f - 1.2f * 1.5f + 4.2f * 3.0f,
				-2.0f * 0.7f + 3.5f * 6.9f + 1.2f * 3.0f + 4.2f * 1.5f,
				+2.0f * 1.5f - 3.5f * 3.0f + 1.2f * 6.9f + 4.2f * 0.7f,
				-2.0f * 3.0f - 3.5f * 1.5f - 1.2f * 0.7f + 4.2f * 6.9f,
			),
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f) * Quaternion(3.0f, 1.5f, 0.7f, 6.9f)
		)
	}
	
	@Test
	fun div() {
		assertEquals(
			Quaternion(
				+2.0f * +6.9f + 3.5f * -0.7f - 1.2f * -1.5f + 4.2f * -3.0f,
				-2.0f * -0.7f + 3.5f * +6.9f + 1.2f * -3.0f + 4.2f * -1.5f,
				+2.0f * -1.5f - 3.5f * -3.0f + 1.2f * +6.9f + 4.2f * -0.7f,
				-2.0f * -3.0f - 3.5f * -1.5f - 1.2f * -0.7f + 4.2f * +6.9f,
			),
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f) / Quaternion(3.0f, 1.5f, 0.7f, 6.9f)
		)
	}
	
	@Test
	fun conjugate() {
		assertEquals(
			Quaternion(-2.0f, -3.5f, -1.2f, 4.2f),
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate
		)
		assertEquals(
			Quaternion(-2.0f, -3.5f, -1.2f, 4.2f),
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f).inverted
		)
		assertEquals(
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate,
			Quaternion(2.0f, 3.5f, 1.2f, 4.2f).inverted
		)
	}
	
	@Test
	fun qTimesConjEqualsOne() {
		val q = (Quaternion(2.0f, 3.5f, 1.2f, 4.2f) * Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate).normalized
		assertEquals(0.0f, q.x, 0.001f)
		assertEquals(0.0f, q.y, 0.001f)
		assertEquals(0.0f, q.z, 0.001f)
		assertEquals(1.0f, q.w, 0.001f)
	}
}