package com.example.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogs.databinding.ActivityMainBinding
import com.example.dialogs.databinding.ItemBottomsheepBinding
import com.example.dialogs.databinding.ItemRvBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.bottomSheepDialog.setOnClickListener {
            var bottomShet = BottomSheetDialog(this)
            var item = ItemBottomsheepBinding.inflate(layoutInflater)
            item.btnClose.setOnClickListener {
                Toast.makeText(this, "Saqlandi", Toast.LENGTH_SHORT).show()
                bottomShet.cancel()
            }
            bottomShet.setContentView(item.root)
            bottomShet.show()
        }

        binding.snackbar.setOnClickListener {

            val snackbar = Snackbar.make(it, "Ассалому Алайкум!!", Snackbar.LENGTH_LONG)
            snackbar.setAction("Click", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Ва алайкум ассалом!", Toast.LENGTH_SHORT).show()
                }
            })

            snackbar.show()

        }

        binding.timePickerDialog.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                this,
                object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                    }

                },
                24,
                60,
                true
            )
//            timePickerDialog.updateTime(LocalTime.now().hour, LocalTime.now().minute)
            timePickerDialog.updateTime(12, 50)
            timePickerDialog.show()

        }

        binding.datePickerDialog.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this)
            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this, "${dayOfMonth}.${month+1}.$year", Toast.LENGTH_SHORT).show()
            }

            datePickerDialog.show()

        }

        binding.fragmentDialog.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            myDialogFragment.show(supportFragmentManager.beginTransaction(),"keyDialog")
        }

        binding.customDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this).create()
            val itemDialogBinding = ItemRvBinding.inflate(layoutInflater)
            dialog.setView(itemDialogBinding.root)
            dialog.setCancelable(false)
            itemDialogBinding.btnYes.setOnClickListener {
                Toast.makeText(this, "Malades", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            itemDialogBinding.btnNo.setOnClickListener {
                Toast.makeText(this, "Malades", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
                dialog.show()

        }

        binding.alertDialog.setOnClickListener {

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Ogohlantirish")
            dialog.setMessage("Bu sayt yoshingizga tog'ri kelmaydi chiqib ketishga rozimisiz?")


            dialog.setPositiveButton("Ha", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Roziman", Toast.LENGTH_SHORT).show()
                }
            })
            dialog.setNegativeButton("Yo'q" , object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Rozi emasman", Toast.LENGTH_SHORT).show()
                }

            })

            dialog.setNeutralButton("Qaytish", object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Qaytdm", Toast.LENGTH_SHORT).show()
                }

            })
            dialog.show()

        }
    }
}