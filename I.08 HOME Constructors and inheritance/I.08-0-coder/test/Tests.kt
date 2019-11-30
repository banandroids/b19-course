import org.junit.Assert
import org.junit.Test
import kotlin.reflect.full.memberFunctions

class Test {
    @Test fun testSolution() {
        val members = Coder::class.members
        val sleepFunction = members.find { it.name == "sleep" }
        Assert.assertTrue("В классе не объявлен метод с именем sleep", sleepFunction != null)
        val sleepParameters = sleepFunction!!.parameters
        Assert.assertEquals("У метода sleep число неправильное число параметров", 1, sleepParameters.size - 1)
        val hoursParameter = sleepParameters.find { it.name == "hours" }
        Assert.assertTrue("У метода sleep нет параметра hours", hoursParameter != null)
        Assert.assertEquals("У параметра hours метода sleep неправильный тип", "kotlin.Int", hoursParameter!!.type.toString())
        Assert.assertEquals("У метода sleep неправильный результат", "kotlin.Unit", sleepFunction.returnType.toString())
        val writeCodeFunction = members.find { it.name == "writeCode" }
        Assert.assertTrue("В классе не объявлен метод с именем writeCode", writeCodeFunction != null)
        Assert.assertEquals("У метода writeCode число неправильное число параметров", 0, writeCodeFunction!!.parameters.size - 1)
        Assert.assertEquals("У метода writeCode неправильный результат", "kotlin.String", writeCodeFunction.returnType.toString())

        val coder = Coder()
        testWriteCode(coder)
        testSkill(coder, 2)
        testFatigue(coder, 0.2f, "один раз написал код")
        callSleep(coder, 1)
        testFatigue(coder, 0.1f, "один раз написал код и потом поспал часок")
        repeat(4) { testWriteCode(coder) }
        testFatigue(coder, 0.9f, "пять раз писал код и поспал часок")
        testWriteCode(coder)
        testSkill(coder, 7)
        testFatigue(coder, 1.0f, "шесть раз писал код и поспал часок")
        testWriteCode(coder)
        testSkill(coder, 7)
        testFatigue(coder, 1.0f, "шесть раз писал код и поспал часок, потом пытался ещё раз покодить, но не получилось, потому что устал")
        callSleep(coder, 20)
        testFatigue(coder, 0.0f, "перед этим поспал 20 часов!!")
        testWriteCode(coder)
        testSkill(coder, 8)
        testFatigue(coder, 0.2f, "поспал двадцать часов и один раз покодил")

    }

    private fun testWriteCode(coder: Coder) {
        val skill = coder.skill
        val fatigue = coder.fatigue
        val writeCodeFunction = coder::class.members.find { it.name == "writeCode" }
        val code = writeCodeFunction!!.call(coder) as String
        if (fatigue >= 1) {
            Assert.assertEquals("Кодер устал (усталость была $fatigue), поэтому шраг должен быть", "¯\\_(ツ)_/¯", code)
        } else {
            val parts = code.trim().split(" ")
            Assert.assertEquals("В коде неправильное количество слов (скилл у героя был равен $skill)", skill, parts.size)
            for (p in parts) {
                Assert.assertTrue("В коде присутствует слово $p (должно использовать только fun!)", p == "fun")
            }
        }
    }

    private fun testSkill(coder: Coder, skill: Int) {
        Assert.assertEquals("Неправильный скилл (writeCode был вызван ${skill - 1} раз)", skill, coder.skill)
    }

    private fun testFatigue(coder: Coder, fatigue: Float, hint: String) {
        Assert.assertEquals("Неправильная усталость ($hint)", fatigue, coder.fatigue)
    }

    private fun callSleep(coder: Coder, hours: Int) {
        val sleepFunction = coder::class.members.find { it.name == "sleep" }
        sleepFunction!!.call(coder, hours)
    }

}