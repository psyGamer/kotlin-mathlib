@file:JvmName("VectorConversions")

package dev.psygamer.mathlib.vector

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin
import dev.psygamer.mathlib.clamp
import dev.psygamer.mathlib.quaternion.QuaternionF

fun eulerToQuaternion(v: Vector3F) =
	eulerToQuaternion(v.x, v.y, v.z)

/** See: [EuclideanSpace - Conversion Euler to Quaternion](http://www.euclideanspace.com/maths/geometry/rotations/conversions/eulerToQuaternion/index.htm) */
fun eulerToQuaternion(x: Float, y: Float, z: Float): QuaternionF {
	val sinX = sin(x / 2.0f)
	val cosX = cos(x / 2.0f)
	val sinY = sin(y / 2.0f)
	val cosY = cos(y / 2.0f)
	val sinZ = sin(z / 2.0f)
	val cosZ = cos(z / 2.0f)
	
	return QuaternionF(
		x = sinZ * cosY * cosX - cosZ * sinY * sinX,
		y = cosZ * sinY * cosX + sinZ * cosY * sinX,
		z = cosZ * cosY * sinX - sinZ * sinY * cosX,
		w = cosZ * cosY * cosX + sinZ * sinY * sinX
	)
}

fun quaternionToEuler(q: QuaternionF): Vector3F {
	val x0 = 2.0f * (q.w * q.z + q.w * q.y)
	val x1 = 1.0f - 2.0f * (q.y * q.y + q.z * q.z)
	
	val z0 = 2.0f * (q.w * q.x + q.y * q.z)
	val z1 = 1.0f - 2.0f * (q.x * q.x + q.y * q.y)
	
	return Vector3F(
		x = atan2(x0, x1),
		z = atan2(z0, z1),
		y = (2.0f * (q.w * q.y - q.z * q.x)).clamp(min = -1.0f, max = 1.0f)
	)
}

fun Vector2I.asVector2f() = Vector2F(this.x.toFloat(), this.y.toFloat())
fun Vector2I.asVector2d() = Vector2D(this.x.toDouble(), this.y.toDouble())

fun Vector2F.asVector2d() = Vector2D(this.x.toDouble(), this.y.toDouble())
fun Vector2F.asVector2i() = Vector2I(this.x.roundToInt(), this.y.roundToInt())

fun Vector2D.asVector2f() = Vector2F(this.x.toFloat(), this.y.toFloat())
fun Vector2D.asVector2i() = Vector2I(this.x.roundToInt(), this.y.roundToInt())

fun Vector3I.asVector3f() = Vector3F(this.x.toFloat(), this.y.toFloat(), this.z.toFloat())
fun Vector3I.asVector3d() = Vector3D(this.x.toDouble(), this.y.toDouble(), this.z.toDouble())

fun Vector3F.asVector3d() = Vector3D(this.x.toDouble(), this.y.toDouble(), this.z.toDouble())
fun Vector3F.asVector3i() = Vector3I(this.x.roundToInt(), this.y.roundToInt(), this.z.roundToInt())

fun Vector3D.asVector3f() = Vector3F(this.x.toFloat(), this.y.toFloat(), this.z.toFloat())
fun Vector3D.asVector3i() = Vector3I(this.x.roundToInt(), this.y.roundToInt(), this.z.roundToInt())

fun Vector3I.asQuaternion(): QuaternionF = eulerToQuaternion(this.asVector3f())
fun Vector3F.asQuaternion(): QuaternionF = eulerToQuaternion(this)
fun Vector3D.asQuaternion(): QuaternionF = eulerToQuaternion(this.asVector3f())
fun QuaternionF.asEulerAngles(): Vector3F = quaternionToEuler(this)