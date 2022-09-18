package com.wildweststores.util

import kotlin.math.ceil

fun Double.roundToDecimalPoint(n : Int) = "%.${n}f".format(this).toDouble()

fun Double.roundUpTo(roundupFactor: Double) = ceil(this / roundupFactor) * roundupFactor;