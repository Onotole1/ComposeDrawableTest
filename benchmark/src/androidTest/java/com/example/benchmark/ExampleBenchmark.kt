package com.example.benchmark

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

/**
 * Benchmark, which will execute on an Android device.
 *
 * The body of [BenchmarkRule.measureRepeated] is measured in a loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 */
@RunWith(AndroidJUnit4::class)
class ExampleBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun compoundViewInflate() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val inflater = LayoutInflater.from(context)
        val root = FrameLayout(context)

        benchmarkRule.measureRepeated {
            inflater.inflate(R.layout.compound_layout, root, false)
        }
        // 2 564 231 ns
    }

    @Test
    fun notCompoundViewInflate() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val inflater = LayoutInflater.from(context)
        val root = FrameLayout(context)

        benchmarkRule.measureRepeated {
            inflater.inflate(R.layout.not_compound_layout, root, false)
        }

        // 3 670 384 ns
    }
}
