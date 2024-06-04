package ca.georgiancollege.ice5

import ca.georgiancollege.ice5.databinding.ActivityMainBinding

class Calculator(dataBinding: ActivityMainBinding)
{
    private var binding: ActivityMainBinding = dataBinding
    private var result: String

    init {
        result = ""
        createButtonReferences()
    }

    private fun createButtonReferences()
    {
        val operandButtons = arrayOf(
            binding.oneButton, binding.twoButton, binding.threeButton, binding.fourButton,
            binding.fiveButton, binding.sixButton, binding.sevenButton, binding.eightButton,
            binding.nineButton, binding.zeroButton, binding.plusMinusButton, binding.decimalButton,
            binding.deleteButton
        )

        val operatorButtons = arrayOf(
            binding.minusButton, binding.plusButton, binding.mulitplyButton, binding.divideButton,
            binding.percentButton, binding.clearButton
        )

        operandButtons.forEach { it.setOnClickListener { operandHandler(it.tag as String) } }

        operatorButtons.forEach { it.setOnClickListener { operatorHandler(it.tag as String) } }
    }

    private fun operandHandler(tag: String) {
        when(tag)
        {
            "." -> {
                if(!binding.resultTextView.text.contains("."))
                {
                    result += if(result.isEmpty()) "0." else "."

                    binding.resultTextView.text = result
                }

            }
            "delete" -> {
                result = result.dropLast(1)

                binding.resultTextView.text = if(result.isEmpty()) "0" else result
            }
            "plus_minus" -> {}
            else -> {

                if(binding.resultTextView.text == "0")
                {
                    result = tag
                    binding.resultTextView.text = result
                }
                else
                {
                    result += tag
                    binding.resultTextView.text = result
                }
            }
        }
    }

    private fun operatorHandler(tag: String)
    {
        when (tag)
        {
            "clear" -> clear()
        }
    }

    private fun clear()
    {
        result = ""
        binding.resultTextView.text = "0"
    }
}