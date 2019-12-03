package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cal = findViewById<Button>(R.id.buttonCalculate)
        val reset = findViewById<Button>(R.id.buttonReset)
        val toast = Toast.makeText(applicationContext, "@+id/error_message", Toast.LENGTH_SHORT)

        cal.setOnClickListener{

            if(editTextCarPrice.text.isEmpty() || editTextDownPayment.text.isEmpty() || editTextInterestRate.text.isEmpty() || editTextLoanPeriod.text.isEmpty()){
                toast.show()
            }else{
                val carPrice = editTextCarPrice.text.toString().toDouble()
                val downPayment = editTextDownPayment.text.toString().toDouble()
                val loanPeriod = editTextLoanPeriod.text.toString().toDouble()
                val interestRate = editTextInterestRate.text.toString().toDouble()

                val carLoan = carPrice - downPayment
                val interest = carLoan * interestRate * loanPeriod
                val monthlyRepayment =(carLoan + interest) / loanPeriod / 12


                textViewLoan.text = "Loan : " + String.format("$%.2f", carLoan)
                textViewInterest.text = "Interest : " + String.format("$%.2f", interest)
                textViewMonthlyRepayment.text = "Monthly Repayment : " +String.format("$%.2f", monthlyRepayment)
            }

        }

        reset.setOnClickListener{
            editTextCarPrice.setText(" ")
            editTextCarPrice.hint = "@string/car_price"
            editTextDownPayment.setText(" ")
            editTextDownPayment.hint = "@string/down_payment"
            editTextInterestRate.setText(" ")
            editTextInterestRate.hint = "@string/interest_rate"
            editTextLoanPeriod.setText(" ")
            editTextLoanPeriod.hint = "@string/loan_period"

            textViewLoan.text = "Loan :"
            textViewInterest.text = "Interest :"
            textViewMonthlyRepayment.text = "Monthly Repayment :"

        }
    }



}
