package edu.qc.seclass.tipcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ComponentActivity

class TipCalculatorActivity : ComponentActivity() {
    lateinit var checkAmountInput: EditText
    lateinit var partySizeInput: EditText
    lateinit var buttonCompute: Button
    lateinit var fifteenPercentTipOutput: TextView
    lateinit var twentyPercentTipOutput: TextView
    lateinit var twentyfivePercentTipOutput: TextView
    lateinit var fifteenPercentTotalOutput: TextView
    lateinit var twentyPercentTotalOutput: TextView
    lateinit var twentyfivePercentTotalOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipcalculator)

        checkAmountInput = findViewById(R.id.checkAmountValue)
        partySizeInput = findViewById(R.id.partySizeValue)
        buttonCompute = findViewById(R.id.buttonCompute)
        fifteenPercentTipOutput = findViewById(R.id.fifteenPercentTipValue)
        twentyPercentTipOutput = findViewById(R.id.twentyPercentTipValue)
        twentyfivePercentTipOutput = findViewById(R.id.twentyfivePercentTipValue)
        fifteenPercentTotalOutput = findViewById(R.id.fifteenPercentTotalValue)
        twentyPercentTotalOutput = findViewById(R.id.twentyPercentTotalValue)
        twentyfivePercentTotalOutput = findViewById(R.id.twentyfivePercentTotalValue)

    }
    fun buttonClick(view: View?){
        val checkAmountInputText = checkAmountInput.text.toString()
        val partySizeInputText = partySizeInput.text.toString()
        try {
            val checkAmountInt = checkAmountInputText.toInt()
            val partySizeInt = partySizeInputText.toInt()
            if (checkAmountInt < 0 || partySizeInt <= 0){
                Toast.makeText(this, "Number has to be greater than 0", Toast.LENGTH_SHORT).show()
            } else {
                val checkAmountFifteenResult = Math.round((checkAmountInt*.15) / partySizeInt)
                val checkAmountTwentyResult = Math.round((checkAmountInt*.20) / partySizeInt)
                val checkAmountTwentyFiveResult = Math.round((checkAmountInt*.25) / partySizeInt)
                val checkAmountFifteenTotalResult = ((checkAmountFifteenResult * partySizeInt) + checkAmountInt).toInt()
                val checkAmountTwentyTotalResult = ((checkAmountTwentyResult * partySizeInt) + checkAmountInt).toInt()
                val checkAmountTwentyFiveTotalResult = ((checkAmountTwentyFiveResult * partySizeInt) + checkAmountInt).toInt()


                Toast.makeText(this, "Successful Number", Toast.LENGTH_SHORT).show()
                fifteenPercentTipOutput.text = "$checkAmountFifteenResult"
                twentyPercentTipOutput.text = "$checkAmountTwentyResult"
                twentyfivePercentTipOutput.text = "$checkAmountTwentyFiveResult"
                fifteenPercentTotalOutput.text = "$checkAmountFifteenTotalResult"
                twentyPercentTotalOutput.text = "$checkAmountTwentyTotalResult"
                twentyfivePercentTotalOutput.text = "$checkAmountTwentyFiveTotalResult"

            }
        } catch (e: NumberFormatException){
            Toast.makeText(this, "Invalid. Enter a Number", Toast.LENGTH_SHORT).show()
        }
    }
}