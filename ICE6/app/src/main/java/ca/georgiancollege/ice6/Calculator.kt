package ca.georgiancollege.ice6

import ca.georgiancollege.ice6.databinding.ActivityMainBinding

class Calculator(dataBinding: ActivityMainBinding)
{
    private var binding: ActivityMainBinding = dataBinding
    private var result: String
    private var currentOperand: String
    private var currentOperator: String

    init {
        result = ""
        currentOperand = ""
        currentOperator = ""
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

    /**
     * This function gets input from the Calculator to create an operand
     *
     * @param {tag} [String]
     * */
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

                binding.resultTextView.text = if(result.isEmpty() || result=="-") "0" else result
            }
            "plus_minus" -> {
                if(result.startsWith("-"))
                {
                    result = result.substring(1)
                }
                else
                {
                    if(result.isNotEmpty())
                    {
                        result = "-".plus(result)
                    }
                }
                binding.resultTextView.text = result
            }
            else -> {

                if(binding.resultTextView.text == "0")
                {
                    result = tag
                }
                else
                {
                    result += tag
                }
                binding.resultTextView.text = result
            }
        }
    }

    /**
     * This function performs all the computation for the Calculator
     *
     * @param {tag} [String]
     * */
    private fun operatorHandler(tag: String)
    {
        if(tag != "clear")
        {

            if(currentOperand.isNotEmpty())
            {
                when (currentOperator)
                {
                    "plus" -> {
                        add()
                    }
                }
            }
            else
            {
                currentOperand = binding.resultTextView.text.toString()
                result = ""
                binding.resultTextView.text = ""
            }
            currentOperator = tag
        }
       else
        {
            clear()
        }
    }

    private fun add()
    {
        if(currentOperand.contains(".") || result.contains("."))
        {
            result = (currentOperand.toFloat() + result.toFloat()).toString()
        }
        else
        {
            result = (currentOperand.toInt() + result.toInt()).toString()
        }
        // TODO: Remove .0 if the result should be an Int
        binding.resultTextView.text = result
    }

    private fun clear()
    {
        result = ""
        binding.resultTextView.text = "0"
        currentOperand = ""
        currentOperator = ""
    }
}