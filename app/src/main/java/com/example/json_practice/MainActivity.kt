package com.example.json_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var number:EditText
    lateinit var btnget:Button
    lateinit var tvname:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number=findViewById(R.id.ed_name)
        btnget=findViewById(R.id.button)
        tvname=findViewById(R.id.textView)

        btnget.setOnClickListener {
            if(number.text.isNotEmpty()){
                val name_input=number.text.toString().toInt()
                 if(name_input>13 || name_input<1){
                   Toast.makeText(applicationContext,"please enter correct number",Toast.LENGTH_SHORT).show()
                }else {
                    getname()

                }
            }else{
                Toast.makeText(applicationContext,"Number felid is empty",Toast.LENGTH_SHORT).show()
                }
        }

        }


    private fun getname() {
        val apiInterface = APIClient().getClient()?.create(APIinterface::class.java)

        if (apiInterface != null) {
            apiInterface.getUser().enqueue(object : Callback<Array<Users>> {
                override fun onResponse(
                    call: Call<Array<Users>>,
                    response: Response<Array<Users>>
                ) {

                     var counter=1
                    for(name in response.body()!!){

                        if(counter==number.text.toString().toInt()) {
                            tvname.text = name.name


                        }
                        counter++

                    }



                }
                override fun onFailure(call: Call<Array<Users>>, t: Throwable) {

                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show();


                }
            })
        }
    }
}