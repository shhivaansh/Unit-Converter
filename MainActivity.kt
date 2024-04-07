package shivansh.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eu.tutorials.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnits(){
        val inputValueDouble=inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0/oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Unspecified
            )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue=it
                convertUnits()
        },
            label = { Text("Enter value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { iExpanded = true }) {
                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters(cm)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters(m)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Foot(ft") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Inches(in)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Inches"
                            conversionFactor.value = 0.0254
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Micrometers(μm)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Micrometers"
                            conversionFactor.value = 0.000001
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeters(mm)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Millimeters"
                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Kilometers(km)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Kilometers"
                            conversionFactor.value = 1000.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Nanometers(nm)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Nanometers"
                            conversionFactor.value = 1.0e-9
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Picometers(pm)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Picometers"
                            conversionFactor.value = 1.0e-12
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Yards(yd)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Yards"
                            conversionFactor.value = 0.9144
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Miles(mi)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Miles"
                            conversionFactor.value = 1609.344
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Nautical Miles(nmi)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Nautical Miles"
                            conversionFactor.value = 1852.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Astronomical Units(AU)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Astronomical Units"
                            conversionFactor.value = 149597870700.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Light-years(ly)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Light-years"
                            conversionFactor.value = 9460730472580800.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Parsecs(pc)") },
                        onClick = {
                            iExpanded = false
                            inputUnit = "Parsecs"
                            conversionFactor.value = 30856775814671900.0
                            convertUnits()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = { oExpanded = true }) {
                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Centimeters(cm)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Centimeters"
                                oConversionFactor.value = 0.01
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Meters(m)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Meters"
                                oConversionFactor.value = 1.00
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Foot(ft") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Feet"
                                oConversionFactor.value = 0.3048
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Inches(in)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Inches"
                                oConversionFactor.value = 0.0254
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Micrometers(μm)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Micrometers"
                                oConversionFactor.value = 0.000001
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Millimeters(mm)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Millimeters"
                                oConversionFactor.value = 0.001
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Kilometers(km)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Kilometers"
                                oConversionFactor.value = 1000.0
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Nanometers(nm)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Nanometers"
                                oConversionFactor.value = 1.0e-9
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Picometers(pm)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Picometers"
                                oConversionFactor.value = 1.0e-12
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Yards(yd)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Yards"
                                oConversionFactor.value = 0.9144
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Miles(mi)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Miles"
                                oConversionFactor.value = 1609.344
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Nautical Miles(nmi)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Nautical Miles"
                                oConversionFactor.value = 1852.0
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Astronomical Units(AU)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Astronomical Units"
                                oConversionFactor.value = 149597870700.0
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Light-years(ly)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Light-years"
                                oConversionFactor.value = 9460730472580800.0
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Parsecs(pc)") },
                            onClick = {
                                oExpanded = false
                                outputUnit = "Parsecs"
                                oConversionFactor.value = 30856775814671900.0
                                convertUnits()
                            }
                        )
                    }
                }
            }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputValue $outputUnit",
                //style = MaterialTheme.typography.headlineMedium
            )
    }
}

@Preview
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
