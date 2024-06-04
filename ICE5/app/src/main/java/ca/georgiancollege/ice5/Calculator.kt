package ca.georgiancollege.ice5

import ca.georgiancollege.ice5.databinding.ActivityMainBinding

class Calculator(dataBinding: ActivityMainBinding)
{
    private var binding: ActivityMainBinding = dataBinding

    init {
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

    private fun operandHandler(tag: String)
    {
        binding.resultTextView.text = tag
    }

    private fun operatorHandler(tag: String)
    {
        binding.resultTextView.text = tag
    }
}