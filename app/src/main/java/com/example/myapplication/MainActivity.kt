package com.example.myapplication
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //global variables
        val button1: Button = findViewById(R.id.btResult)
        val button2: Button = findViewById(R.id.ResetButton)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag : String = "sum"

        val spinnerVal : Spinner = findViewById(R.id.spinnerV)
        var options = arrayOf("Sum","Sub","Multiplication","Division")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )

        button1.setOnClickListener{ view ->
            //Button code here
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();

                if (flag == "Sum")
                    resultTV.text = sum(x, y).toString();
                else if (flag == "Sub")
                    resultTV.text = sub(x, y).toString();
                else if (flag == "Multiplication")
                    resultTV.text = multiply(x, y).toString();
                else if (flag == "Division")
                    resultTV.text = div(x, y).toString();

        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        button2.setOnClickListener{ view ->
            //Button code here
            resultTV.text = "Result";
            edtxt1.text = null;
            edtxt2.text = null;
        }

    }
}
public fun sum(a: Int, b: Int): Int {
    return a+b;
}
public fun sub(a: Int, b: Int): Int {
    return a-b;
}
public fun multiply(a: Int, b: Int): Int {
    return a*b
}
public fun div(a: Int, b: Int): Int {
    if(b!=0){ return a/b;}
    else return 0;
}
