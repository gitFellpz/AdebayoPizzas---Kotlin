package com.example.adebayopizzas

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adebayopizzas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Recuperar o valor informado pela tela de Login
        val bundle = intent.extras
        val usuario = bundle?.getString("usuario")
        //Alterar o texto de boas vindas
        binding.tvUsuario.text = "Olá $usuario"
    }

    fun calcular(view: View) {
        val idSelecionado = binding.rgTamanhoPizza.checkedRadioButtonId
        var valorTamanhoPizza = 0
        var valor = 0.0
        when (idSelecionado) {
            R.id.rbPequena -> {
                valorTamanhoPizza = 10
                tamanhoSelecionado = binding.rbPequena.text.toString()
            }
            R.id.rbMedia -> {
                valorTamanhoPizza = 12
                tamanhoSelecionado = binding.rbMedia.text.toString()
            }
            R.id.rbGrande -> {
                valorTamanhoPizza = 15
                tamanhoSelecionado = binding.rbGrande.text.toString()
            }
        }
        if (binding.cbAtum.isChecked) {
            valor += (3 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(binding.cbAtum.text.toString())
        }
        if (binding.cbBacon.isChecked) {
            valor += (5 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(binding.cbBacon.text.toString())
        }
        if (binding.cbCalabresa.isChecked) {
            valor += (4 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(binding.cbCalabresa.text.toString())
        }
        if (binding.cbMussarela.isChecked) {
            valor += (2 + valorTamanhoPizza).toDouble()
            pizzasSelecionadas.add(binding.cbMussarela.text.toString())
        }

        val pagamento = binding.spPagamentos.selectedItem as String

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Confirmação")
        alert.setMessage("Valor: $valor\nPagamento: $pagamento")
        alert.setPositiveButton("SIM") { dialog, which ->
            val intentDetalhePedido = Intent(this,
                DetalheDoPedidoActivity::class.java)
            val pedido = Pedido(
                binding.etNomeCliente.text.toString(),
                pizzasSelecionadas,
                tamanhoSelecionado,
                pagamento
            )
            intentDetalhePedido.putExtra("pedido", pedido)
            startActivity(intentDetalhePedido)
        }
        alert.setNegativeButton("NÃO", null)
        alert.show()

    }


}