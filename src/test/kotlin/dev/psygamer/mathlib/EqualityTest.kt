package dev.psygamer.mathlib

import org.junit.jupiter.api.Test
import kotlin.test.*

internal class EqualityTest {
	
	@Test
	fun floatAlmostEqualToFloat() {
		assertTrue(1.0f.almostEquals(1.0f))
		assertTrue(1.00001f.almostEquals(1.0f))
		assertTrue(1.0f.almostEquals(1.00001f))
		assertTrue(1.00001f.almostEquals(1.00001f))
		
		assertFalse(1.9f.almostEquals(2.0f))
	}
	
	@Test
	fun floatAlmostEqualToDouble() {
		assertTrue(1.0f.almostEquals(1.0))
		assertTrue(1.00001f.almostEquals(1.0))
		assertTrue(1.0f.almostEquals(1.00001))
		assertTrue(1.00001f.almostEquals(1.00001))
		
		assertFalse(1.9f.almostEquals(2.0))
	}
	
	@Test
	fun doubleAlmostEqualToFloat() {
		assertTrue(1.0.almostEquals(1.0f))
		assertTrue(1.00001.almostEquals(1.0f))
		assertTrue(1.0.almostEquals(1.00001f))
		assertTrue(1.00001.almostEquals(1.00001f))
		
		assertFalse(1.9.almostEquals(2.0f))
	}
	
	@Test
	fun doubleAlmostEqualToDouble() {
		assertTrue(1.0.almostEquals(1.0))
		assertTrue(1.00001.almostEquals(1.0))
		assertTrue(1.0.almostEquals(1.00001))
		assertTrue(1.00001.almostEquals(1.00001))
		
		assertFalse(1.9.almostEquals(2.0))
	}
}