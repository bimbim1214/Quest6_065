package com.example.pertemuan8.ui.theme.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pertemuan8.model.Mahasiswa
import com.example.pertemuan8.model.RencanaStudi

@Composable
fun TampilView(
    modifier: Modifier = Modifier,
    mahasiswaStateUI: Mahasiswa,
    krsState: RencanaStudi,
    onBackButtonClicked : ( ) -> Unit
){

    val lisDataMhs = listOf(
        Pair("nim",mahasiswaStateUI.nim),
        Pair("nama",mahasiswaStateUI.nama),
        Pair("email",mahasiswaStateUI.email),
        Pair("mataKuliah", krsState.mataKuliah),
        Pair("kelas", krsState.kelas),
    )


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "DETAIL MAHASISWA")
        Spacer(modifier = Modifier.padding(5.dp))
        lisDataMhs.forEach{item ->
            CardSection(Judul =  item.first, isi = item.second)
        }
        Button(onClick = {onBackButtonClicked()})
        {
            Text("kembali")
        }
    }
}

@Composable
fun CardSection(Judul: String, isi : String) {
    Column{
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = Judul, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$isi", modifier = Modifier.weight(2f))
        }
    }
}