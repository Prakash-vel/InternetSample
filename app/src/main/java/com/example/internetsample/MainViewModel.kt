package com.example.internetsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel:ViewModel() {

    private val viewModelJob= Job()
    private val coroutineScope= CoroutineScope(Dispatchers.Main+viewModelJob)

    private val _properties=MutableLiveData<List<QuotesProperty>>()
    val properties: LiveData<List<QuotesProperty>>
      get()=_properties
    init{
        _properties.value=null
        getQouteProperties()
    }
    private fun getQouteProperties() {
        coroutineScope.launch{
            var getPropertyDeferred=QuotesApi.retrofitService.getProperties()

            try{
                var listResult=getPropertyDeferred.await()

                if(listResult.size > 0){
                    _properties.value=listResult
                    Log.i("hello","finished $listResult")
                }
            }catch(e: Exception){


                Log.i("hello","error while fetchin data$e")
            }
        }
    }



}