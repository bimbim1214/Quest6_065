package com.example.pertemuan8.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8.model.Mahasiswa
import com.example.pertemuan8.model.RencanaStudi
import com.example.pertemuan8.ui.theme.view.screen.MahasiswaFormView
import com.example.pertemuan8.ui.theme.view.screen.RencanaStudiView
import com.example.pertemuan8.ui.theme.view.screen.SplashView
import com.example.pertemuan8.ui.theme.view.screen.TampilView
import com.example.pertemuan8.ui.theme.view.viewmodel.MahasiswaViewModel
import com.example.pertemuan8.ui.theme.view.viewmodel.RencanaStudiViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaStateUI.collectAsState().value
    val krsStateUi = krsViewModel.krsStateUi.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = Halaman.Splash.name){
            SplashView(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }

    }
}
