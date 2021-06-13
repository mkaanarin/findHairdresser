package com.example.findhairdresser

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.findhairdresser.data.model.CitiesAPI
import com.example.findhairdresser.data.model.cities
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



//Spinner'ları ve Adapter'lerini tanımlıyoruz.
lateinit var spinnerIller : Spinner
lateinit var spinnerIlceler : Spinner
lateinit var dataAdapterForIller : android.widget.ArrayAdapter<String>
lateinit var dataAdapterForIlceler : ArrayAdapter<String>



class choosingLocation : AppCompatActivity() {
    val BASE_URL ="https://github.com/"
    var city : ArrayList<cities>? = null
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_location)


          //xml kısmında hazırladığımğız spinnerları burda tanımladıklarımızla eşleştiriyoruz.
        /*spinnerIller = findViewById(R.id.spinner1)
        spinnerIlceler = findViewById(R.id.spinner2)

      //Spinner'lar için adapterleri hazırlıyoruz.
        dataAdapterForIller = ArrayAdapter(this,android.R.layout.simple_spinner_item,iller)
        dataAdapterForIlceler = ArrayAdapter(this, android.R.layout.simple_spinner_item, ilceler0);


      //Listelenecek verilerin görünümünü belirliyoruz.
      dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

      //Hazırladğımız Adapter'leri Spinner'lara ekliyoruz.
      spinnerIller.setAdapter(dataAdapterForIller)
      spinnerIlceler.setAdapter(dataAdapterForIlceler)

      // Listelerden bir eleman seçildiğinde yapılacakları tanımlıyoruz.
      spinnerIller.setOnItemSelectedListener(new OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> parent, View view,
              int position, long id) {
              //Hangi il seçilmişse onun ilçeleri adapter'e ekleniyor.
              for(i==0; i<=80;i++){
              if(parent.getSelectedItem().toString().equals(iller[i]))
                  dataAdapterForIlceler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,ilceler"$i");
              }

              dataAdapterForIlceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
              spinnerIlceler.setAdapter(dataAdapterForIlceler);
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {
          }
      });

      spinnerIlceler.setOnItemSelectedListener(new OnItemSelectedListener() {

          @Override
          public void onItemSelected(AdapterView<?> parent, View view,
              int position, long id) {
              //Seçilen il ve ilçeyi ekranda gösteriyoruz.
              Toast.makeText(getBaseContext(), ""+spinnerIller.getSelectedItem().toString()+"n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
          }

          public void onNothingSelected(AdapterView<?> parent) {
          }
      });*/
        loadData()
}
    private fun loadData(){

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create((CitiesAPI::class.java))
        val call = service.getData()
        call.enqueue(object: Callback<List<cities>>{
            override fun onResponse(call: Call<List<cities>>?, response: Response<List<cities>>?) {
                if (response!!.isSuccessful){
                    response.body()?.let {

                        city = ArrayList(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<cities>>?, t: Throwable?) {
                t?.printStackTrace()
            }









        })
    }

}
