package com.lm.lmcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.lm.lmcalculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    var mCalculatorBinding: ActivityCalculatorBinding? = null
    var calculateTv: TextView? = null
    var resultTv: TextView? = null
    var oneTv: TextView? = null
    var twoTv: TextView? = null
    var threeTv: TextView? = null
    var fourTv: TextView? = null
    var fiveTv: TextView? = null
    var sixTv: TextView? = null
    var sevenTv: TextView? = null
    var eightTv: TextView? = null
    var nineTv: TextView? = null
    var doubleZeroTv: TextView? = null
    var zeroTv: TextView? = null
    var dotTv: TextView? = null
    var clearAllTv: TextView? = null
    var clearTv: TextView? = null
    var divideTv: TextView? = null
    var intoTv: TextView? = null
    var minusTv: TextView? = null
    var plusTv: TextView? = null
    var equalsTv: TextView? = null
    var calculatorViewModel: CalculatorViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCalculatorBinding = DataBindingUtil.setContentView(this, R.layout.activity_calculator)
        calculatorViewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        mCalculatorBinding.let { binding ->
            calculateTv = binding?.calculateTv
            resultTv = binding?.resultTv
            oneTv = binding?.oneTv
            twoTv = binding?.twoTv
            threeTv = binding?.twoTv
            fourTv = binding?.twoTv
            fiveTv = binding?.twoTv
            sixTv = binding?.twoTv
            sevenTv = binding?.twoTv
            eightTv = binding?.twoTv
            nineTv = binding?.twoTv
            doubleZeroTv = binding?.twoTv
            zeroTv = binding?.twoTv
            dotTv = binding?.twoTv
            clearAllTv = binding?.twoTv
            clearTv = binding?.twoTv
            divideTv = binding?.twoTv
            intoTv = binding?.twoTv
            minusTv = binding?.twoTv
            plusTv = binding?.twoTv


            oneTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "1"
                }
            })

            twoTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "2"
                }
            })

            threeTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "3"
                }
            })

            fourTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "4"
                }
            })

            fiveTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "5"
                }
            })

            sixTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "6"
                }
            })

            sevenTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "7"
                }
            })

            eightTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "8"
                }
            })

            nineTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "9"
                }
            })

            zeroTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "0"
                }
            })

            doubleZeroTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel!!.currentText
                    calculatorViewModel!!.currentText = currentText + "00"
                }
            })

            clearTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val currentText: String? = calculatorViewModel?.currentText
                    if (currentText != null && currentText.isNotEmpty()) {
                        calculatorViewModel?.currentText =
                            currentText.substring(0, currentText.length - 1)
                    }
                }
            })

            clearAllTv?.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    calculatorViewModel?.currentText = ""
                }
            })


        }


    }
}