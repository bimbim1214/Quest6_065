package com.example.pertemuan8.ui.theme.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan8.R
import com.example.pertemuan8.data.MataKuliah
import com.example.pertemuan8.data.RuangKelas
import com.example.pertemuan8.model.Mahasiswa
import com.example.pertemuan8.ui.theme.widget.DynamicSelectTextField

@Composable
fun RencanaStudiView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
    var chosenDropdown by remember {
        mutableStateOf("")
    }

    var cheked by remember {
        mutableStateOf(false)
    }
    var pilihankelas by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihankelas)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Box{
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize(),
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Pilih Mata Kuliah Peminatan", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silahkan pilih mata kuliah yang ada anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(
                    modifier = Modifier.padding(8.dp)
                )
                DynamicSelectTextField(
                    selectedValue = chosenDropdown,
                    options = MataKuliah.options,
                    label = "Mata Kuliah",
                    onValueChangeEvent = {
                        chosenDropdown = it
                    }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                //HorizontalDivider()
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Pilih Kelas Belajar", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silahkan pilih kelas dari mata kuliiah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RuangKelas.listKelas.forEach{ data ->
                        Row(verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = pilihankelas == data,
                                onClick = {pilihankelas = data}
                            )
                            Text(data)
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                //HorizontalDivider()
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Klausul Persetujuan Mahasiswa", fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = cheked,
                        onCheckedChange = { cheked = it },
                        enabled = chosenDropdown.isNotBlank() && pilihankelas.isNotBlank()
                    )
                    Text(
                        text = "Saya menyetujui setiap pernyataan yang ada tanpa ada paksaan dari pihak manapun.",
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { onBackButtonClicked() }) {
                        Text(text = "Kembali")
                    }
                    Button(onClick = { onSubmitButtonClicked(listData) }, enabled = cheked) {
                        Text(text = "Lanjut")
                    }
                }
            }
        }

    }

}