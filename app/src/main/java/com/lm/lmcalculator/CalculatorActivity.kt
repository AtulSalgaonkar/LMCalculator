package com.lm.lmcalculator

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    var calculatorViewModel: CalculatorViewModel? = null
    private var currentTextLiveData: MutableLiveData<String>? = null
    private val TAG = "CalculatorActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        currentTextLiveData = calculatorViewModel?.getCurrentTextLiveData()
        currentTextLiveData?.observe(this) {
            calculatorViewModel?.currentText = it
            calculate_tv.text = it
        }

        calculatorViewModel?.getAnswerTextLiveData()?.observe(this) {
            result_tv.text = it
        }

        one_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "1")
        }

        two_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "2")
        }

        three_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "3")
        }

        four_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "4")
        }

        five_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "5")
        }

        six_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "6")
        }

        seven_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "7")
        }

        eight_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "8")
        }

        nine_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "9")
        }

        zero_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "0")
        }

        double_zero_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentTextLiveData?.postValue(currentText + "00")
        }

        clear_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel?.currentText
            if (currentText != null && currentText.isNotEmpty()) {
                currentTextLiveData?.postValue(currentText.substring(0, currentText.length - 1))
            }
        }

        into_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentText?.let {
                when {
                    !(currentText.endsWith("x") ||
                            currentText.endsWith("÷") ||
                            currentText.endsWith("+") ||
                            currentText.endsWith("-")) -> {
                        currentTextLiveData?.postValue(currentText + "x")
                    }
                }
            }
        }

        divide_all_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentText?.let {
                when {
                    !(currentText.endsWith("x") ||
                            currentText.endsWith("÷") ||
                            currentText.endsWith("+") ||
                            currentText.endsWith("-")) -> {
                        currentTextLiveData?.postValue("$currentText÷")
                    }
                }
            }
        }

        add_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentText?.let {
                when {
                    !(currentText.endsWith("x") ||
                            currentText.endsWith("÷") ||
                            currentText.endsWith("+") ||
                            currentText.endsWith("-")) -> {
                        currentTextLiveData?.postValue("$currentText+")
                    }
                }
            }
        }

        minus_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText
            currentText?.let {
                when {
                    !(currentText.endsWith("x") ||
                            currentText.endsWith("÷") ||
                            currentText.endsWith("+") ||
                            currentText.endsWith("-")) -> {
                        currentTextLiveData?.postValue("$currentText-")
                    }
                }
            }
        }

        switch_tv.setOnClickListener {
            val value: String = result_tv.text as String
            var isDouble = false
            try {
                value.toDouble()
                isDouble = true
            } catch (e: Exception) {
            }

            if (isDouble)
                currentTextLiveData?.postValue(result_tv.text as String?)
            else
                currentTextLiveData?.postValue("0")
        }

        dot_tv.setOnClickListener {
            val currentText: String? = calculatorViewModel!!.currentText

            currentText?.let {
                when {
                    !it.endsWith(".") -> {
                        if (it.contains("x") ||
                            it.contains("÷") ||
                            it.contains("+") ||
                            it.contains("-")
                        ) {
                            val newCurrentTextMultiply: String =
                                it.substring(it.lastIndexOf("x") + 1)
                            val newCurrentTextDivide: String = it.substring(it.lastIndexOf("÷") + 1)
                            val newCurrentTextAdd: String = it.substring(it.lastIndexOf("+") + 1)
                            val newCurrentTextMinus: String = it.substring(it.lastIndexOf("-") + 1)

                            var hasCorrectValue = ""

                            try {
                                newCurrentTextMultiply.toDouble();
                                hasCorrectValue = "x"
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                            try {
                                newCurrentTextDivide.toDouble();
                                hasCorrectValue = "/"
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                            try {
                                newCurrentTextAdd.toDouble();
                                hasCorrectValue = "+"
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                            try {
                                newCurrentTextMinus.toDouble();
                                hasCorrectValue = "-"
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            Log.d(TAG, "onCreate hasCorrectValue: $hasCorrectValue")
                            if (TextUtils.isEmpty(hasCorrectValue)) {
                                currentTextLiveData?.postValue("$it.")
                            } else {
                                when (hasCorrectValue) {
                                    "x" -> {
                                        if (newCurrentTextMultiply.contains(".0") || TextUtils.isDigitsOnly(
                                                newCurrentTextMultiply
                                            )
                                        ) {
                                            currentTextLiveData?.postValue("$it.")
                                        }
                                    }
                                    "/" -> {
                                        if (newCurrentTextDivide.contains(".0") || TextUtils.isDigitsOnly(
                                                newCurrentTextDivide
                                            )
                                        ) {
                                            currentTextLiveData?.postValue("$it.")
                                        }
                                    }
                                    "+" -> {
                                        if (newCurrentTextAdd.contains(".0") || TextUtils.isDigitsOnly(
                                                newCurrentTextAdd
                                            )
                                        ) {
                                            currentTextLiveData?.postValue("$it.")
                                        }
                                    }
                                    "-" -> {
                                        if (newCurrentTextMinus.contains(".0") || TextUtils.isDigitsOnly(
                                                newCurrentTextMinus
                                            )
                                        ) {
                                            currentTextLiveData?.postValue("$it.")
                                        }
                                    }
                                }
                            }

                            Log.d(TAG, "onCreate newCurrentTextMultiply: $newCurrentTextMultiply")
                            Log.d(TAG, "onCreate newCurrentTextDivide: $newCurrentTextDivide")
                            Log.d(TAG, "onCreate newCurrentTextAdd: $newCurrentTextAdd")
                            Log.d(TAG, "onCreate newCurrentTextMinus: $newCurrentTextMinus")
                        } else {
                            currentTextLiveData?.postValue("$it.")
                        }
                    }
                }
            }
        }

        equals_tv.setOnClickListener {
            calculatorViewModel!!.currentText?.let {
                if (it.endsWith("x") ||
                    it.endsWith("÷") ||
                    it.endsWith("+") ||
                    it.endsWith("-") ||
                    it.endsWith(".")
                ) {
                    currentTextLiveData?.postValue(it + "0")
                    calculatorViewModel!!.currentText = it + "0"
                }
            }
            val currentText: String? = calculatorViewModel!!.currentText
            currentText?.let { it1 -> calculatorViewModel?.eval(it1) }
        }

        clear_all_tv.setOnClickListener() {
            currentTextLiveData?.postValue("")
            result_tv.text = "Ans"
        }


    }
}