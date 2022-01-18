package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.searchview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user = arrayOf("ergegr","ergfwaaw","yujtrd","ethrdrd","wcfbygv","ytfgcsdc","bnbcwe",
        "erfeg","gbdfdv","afdsvd","dgvsv","sdgvdf")

        val userAdapter:ArrayAdapter<String> = ArrayAdapter(
            this,android.R.layout.simple_spinner_item,
            user
        )


        binding.userList.adapter = userAdapter;

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                if (user.contains(query)){

                    userAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                userAdapter.filter.filter(newText)

                return false
            }

        })
    }
}