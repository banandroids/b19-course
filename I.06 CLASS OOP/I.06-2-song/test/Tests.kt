import junit.framework.Assert.assertEquals
import org.junit.*
import org.junit.Test
import org.junit.contrib.java.lang.system.SystemOutRule
import java.io.ByteArrayInputStream

class Test {
    @get:Rule
    val systemOutRule: SystemOutRule = SystemOutRule().enableLog()

    @Test
    fun testSolution() {
        test(arrayOf(Song("bad guy", "Billie Eilish", 2019), Song("Yesterday", "The Beatles", 1995)))
        test(emptyArray())
        test(arrayOf(Song("A", "B", 2017), Song("C", "D", 1987), Song("E", "F", 1999), Song("A", "F", 2000), Song("Z", "Z", 1941)))
        test(arrayOf(Song("bad guy", "Billie Eilish", 2019)))
    }

    private fun test(input: String) {
        systemOutRule.clearLog()
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        assertEquals("Неправильный ответ для входных данных:\n$input", "-", systemOutRule.log.trim())
    }

    private fun test(inputSongs: Array<Song>) {
        systemOutRule.clearLog()
        var input = inputSongs.size.toString()
        for (song in inputSongs) {
            input += "\n${song.name}\n${song.artist}\n${song.year}"
        }
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        Assert.assertEquals("Неправильный размер массива для входных данных:\n$input\n", inputSongs.size, songs.size)
        for (i in inputSongs.indices) {
            Assert.assertEquals("Неправильное название песни с индексом $i для входных данных:\n$input\n", inputSongs[i].name, songs[i]!!.name)
            Assert.assertEquals("Неправильное имя артиста для песни с индексом $i для входных данных:\n$input\n", inputSongs[i].artist, songs[i]!!.artist)
            Assert.assertEquals("Неправильный год выпуска песни с индексом $i для входных данных:\n$input\n", inputSongs[i].year, songs[i]!!.year)
        }
    }

}