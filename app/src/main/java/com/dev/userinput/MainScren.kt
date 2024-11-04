package com.dev.userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun MainScren(
    modifier: Modifier = Modifier
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf(" ") }
    var alamat by remember { mutableStateOf(" ") }
    var noHp by remember { mutableStateOf(" ") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-laki", "Perempuan")

    var confirmName by rememberSaveable { mutableStateOf("") }
    var confirmEmail by remember { mutableStateOf(" ") }
    var confirmAlamat by remember { mutableStateOf(" ") }
    var confirmNoHp by remember { mutableStateOf(" ") }
    var confirmSelectedGender by remember { mutableStateOf("") }


    Column(Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = nama, onValueChange = { nama = it },
            placeholder = { Text("Masukan Nama :") },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        Row() {
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedGender == item,
                        onClick = { selectedGender = item }
                    )
                    Text(item)

                }
            }
        }


        OutlinedTextField(
            value = email, onValueChange = { email = it },
            placeholder = { Text("Masukan Email :") },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )


        OutlinedTextField(
            value = alamat, onValueChange = { alamat = it },
            placeholder = { Text("Masukan Alamat :") },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noHp, onValueChange = { noHp = it },
            placeholder = { Text("Masukan Nomor HP :") },
            label = { Text("No Hp") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick = {
            confirmName = nama
            confirmSelectedGender = selectedGender
            confirmEmail = email
            confirmNoHp = noHp
            confirmAlamat = alamat


        }) {
            Text("Simpan")
        }
        Card (modifier.size(height = 300.dp, width =500.dp )){

            CardSection(judulParem = "Nama", isiParem = confirmName)
            CardSection(judulParem = "Jenis kelamin", isiParem = confirmSelectedGender)
            CardSection(judulParem = "Alamat", isiParem = confirmAlamat)
            CardSection(judulParem = "No Hp", isiParem = confirmNoHp)

        }

    }
}


@Composable
fun CardSection(judulParem:String, isiParem:String) {
    Column(modifier = Modifier.padding(16.dp)) {


        //Spacer(modifier = Modifier.padding(10.dp).fillMaxWidth().padding(1.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParem, modifier = Modifier.weight(0.8f))
            Text(text = ": ", modifier = Modifier.weight(0.2f))
            Text(text = isiParem, modifier = Modifier.weight(2f))


        }

    }
}

