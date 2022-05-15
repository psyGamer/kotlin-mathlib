package dev.psygamer.mathlib.rotation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class QuaternionTest {
	
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
		
		assertEquals(
			1.0f,
			(Quaternion(2.0f, 3.5f, 1.2f, 4.2f) * Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate).r,
			0.001f
		)
		assertEquals(
			0.0f,
			(Quaternion(2.0f, 3.5f, 1.2f, 4.2f) * Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate).i,
			0.001f
		)
		assertEquals(
			0.0f,
			(Quaternion(2.0f, 3.5f, 1.2f, 4.2f) * Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate).j,
			0.001f
		)
		assertEquals(
			0.0f,
			(Quaternion(2.0f, 3.5f, 1.2f, 4.2f) * Quaternion(2.0f, 3.5f, 1.2f, 4.2f).conjugate).k,
			0.001f
		)
	}
	
	@Test
	fun normalize() {
		assertEquals(
			Quaternion(0.5f, 0.5f, 0.5f, 0.5f),
			Quaternion(1.0f, 1.0f, 1.0f, 1.0f).normalized
		)
		assertEquals(
			Quaternion(0.5f, 0.5f, 0.5f, 0.5f),
			Quaternion(2.0f, 2.0f, 2.0f, 2.0f).normalized
		)
	}
}