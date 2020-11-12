package aoc

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class Day2Test {

    @Test
    fun testBigList(){
        val checksum = countOccurrences(bigList.lines())
        println("Checksum = $checksum")
    }

    @Test
    fun testChecksum12() {
        val checksum = countOccurrences(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))
        assertEquals(12, checksum)
    }

    @Test
    fun testZeroChecksum() {
        val checksum = countOccurrences(listOf("acbde", "asf", "haser", "liusg", "mvuw9sa"))
        assertEquals(0, checksum)
    }

    @Test
    fun testOneChecksum() {
        val checksum = countOccurrences(listOf("aabbb"))
        assertEquals(1, checksum)
    }

    @Test
    fun testCorrectBoxes() {
        val input = listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")

        val (fst, snd) = findCorrectBoxes(input)
        assertEquals(fst, "fghij")
        assertEquals(snd, "fguij")
    }

    @Test
    fun testBigListOfIDs() {
        val pair = findCorrectBoxes(bigList.lines())

        // zip the two IDs (creating pairs of chars) and remove
        // the chars that are not equal. Then join in back to a
        // String of common chars
        val common = pair.first
            .zip(pair.second)
            .filter { it.first == it.second }
            .map { it.first }
            .joinToString("")

        println("Common letters: $common")
    }
}

val bigList = """rmyxgdlihczskunpfwbgqoeybv
rmyxgdlksczskunpfwbjqkeatv
rmybgdxibczskunpfwbjqoeatv
rmyxgdlirczskuopfwbjqzeatv
rmyxedlrhczskunpfwbyqoeatv
rmyxfdlicczskunpfwbxqoeatv
rmyxgvlihkzskunpfwbsqoeatv
rmyxgdaihczvkunpfwblqoeatv
nmyxgolihczskunpfwbjqieatv
rhyxgdcihczskunifwbjqoeatv
rmfxgdlihczskunpfwbvqgeatv
smyxgdlihczskunsiwbjqoeatv
rmyxgdcihcxskunpfwbrqoeatv
rmyxgdlihczckuiqfwbjqoeatv
rmyxxdwihczskunifwbjqoeatv
rkzxgdlihczskunpfwhjqoeatv
rmypgdlihczskunpfwbrqoeafv
rmyxgplihczvkunpkwbjqoeatv
rqyxgdlihdzskjnpfwbjqoeatv
rmyxgdlihczskqnpswbjqoeaov
mcyxgdlihczmkunpfwbjqoeatv
rmyxgdlohczspunpowbjqoeatv
tmyxgdlihczskunpfwbeqoeltv
rmyxgdlibccskunpfwbjqoegtv
rmyxgdlehczsaunpfwboqoeatv
rmaxgdlihczseunpfwbjqojatv
rmyxgdlijczskynpfwbjboeatv
kmlxgdlilczskunpfwbjqoeatv
rmsxgdlshczskenpfwbjqoeatv
rmbxgdlihcmskgnpfwbjqoeatv
rayxgdlihczskunpfwbjqoeaef
umyxgdlisczskunpfdbjqoeatv
rmyxgdlihczskunsfwbjqieatg
rmbxgdlihczhkunpfwbjqoeamv
rmyxgdlihczskeypfwbjqxeatv
rmyxgkrihczskunptwbjqoeatv
rmyxgdlihczskunpawbjqoexiv
rmyxgdlihcrskqnpfwbjqceatv
rmyxgblihczskjnpfwbjqieatv
rmyggdlidczskunofwbjqoeatv
rmyxgdlghczskunphwbjqomatv
rmqxgdbihczskunpfnbjqoeatv
rvyxgdlihczsgunpfwbjqoeanv
royxgdlnhczskqnpfwbjqoeatv
rmyxgdlihczskugpfwbkqreatv
rmyxfdlihczskunppwejqoeatv
rqyxgdlipczskunpfwbjqoeqtv
rmyxgdlicczskunpnwbjqotatv
rmyxodlihczskxnpfwijqoeatv
rmyxrdyihczskunpftbjqoeatv
rmtxgdyihwzskunpfwbjqoeatv
tmyxcdliiczskunpfwbjqoeatv
rmyxgdlihczskmnpfwbjjoeadv
rmyxgdnihczskunpqwbjqojatv
bmyxgdlihczskcnpfwboqoeatv
rmysgdlihcyskudpfwbjqoeatv
rmyxgdtihczsmuupfwbjqoeatv
rmyxgdlihczssunpffbjqolatv
rmyogdlihczsklnpfwbjqoxatv
rmyxgjlihczskunpfwsjqoyatv
rmyxgalshczskunpfwbuqoeatv
rmyfgdlihczskunqfwbiqoeatv
tmyxgdlihczskunotwbjqoeatv
rmyxpdzihczskuopfwbjqoeatv
rmyfgdlihczskunpfrbgqoeatv
rmyxgdlwhczskhnofwbjqoeatv
rmyxgdlihczsmudpfrbjqoeatv
rmyxgdlihczokanpfwbjqooatv
rmyxrdlihczskunppwjjqoeatv
rmyxgdjihczskwnpowbjqoeatv
mmyxgdlihczikunpfwbjqoeamv
rmyxgflihczshunpwwbjqoeatv
rmytghlihczskunpfwbjqoeatk
rmyxgdlipczmbunpfwbjqoeatv
rmyxgdlihczkkonpfwbjqomatv
rmfxgslihczskunpfwujqoeatv
dmyxgdlihczykunqfwbjqoeatv
rmyxgalihcbskunpgwbjqoeatv
rmyxgdlinczqkunpfwbjqopatv
rmyxgdlihwzslunplwbjqoeatv
rmypgdlihczskdtpfwbjqoeatv
rmsxgdxieczskunpfwbjqoeatv
rmyxgdlihczskwnpfxrjqoeatv
rmyxgdlihzzskunpflbjpoeatv
rslxgdlihczsnunpfwbjqoeatv
rmyxgdlmcczskunpfwbjqoealv
fmkxgdbihczskunpfwbjqoeatv
rmyxgdiigczxkunpfwbjqoeatv
rjyxgnlqhczskunpfwbjqoeatv
ymyxgolihczskunpfmbjqoeatv
hmyxgdlihczskuncfwbjqoejtv
rmyxgqlihczzkunpfwbjqojatv
rmgfgdlihczskunpfwbjgoeatv
rmyxgdlfhczskunpfwbjqweaxv
rmoxtdlihczskunpfwdjqoeatv
ruyxgdlihczskunpfmbjnoeatv
rmnxgflehczskunpfwbjqoeatv
rmyugdlihczskunpfwfjroeatv
rmyxddbihczskunpfwbjqoeutv
rmyxgdlipczskunofbbjqoeatv
gmyxgdlihczskunpfkbjroeatv
rmyxgdllhcpskunpfwbjqqeatv
rmyxgdlihchskunpfwbjqoelcv
mmyxldlihczskuncfwbjqoeatv
ryyxgdlxhczskcnpfwbjqoeatv
rmyxpdlihczskyntfwbjqoeatv
rmhxgdlibczskwnpfwbjqoeatv
rmyxgdlihczskunpfwojbkeatv
qmyxgdlihczskunpfwbjqoyatm
rmyxgdlzhczskunpfwbjqoealr
rmyegdliqczskunpfgbjqoeatv
umyxgdlihczsvunpfwbfqoeatv
rmyxgdoihfzskunpfmbjqoeatv
rmyxgdlihcdskanpmwbjqoeatv
rmyxgdyihczskunpfrbjqoeaov
rcyxgdlihczskuegfwbjqoeatv
rmyxgdlihgwskunpfwbjkoeatv
rpyxgdlihmzskunpfwbjqoeatp
rmyxgdlihhzskunpfwbjaoeapv
rmyxgdsrhczskunpflbjqoeatv
rmrxgdlihczskunpvwbjqoeabv
rmcxgylihczskunpfwbjyoeatv
rmkxgdlyhczsounpfwbjqoeatv
rmyxgdqihczskunmfwbjqoratv
rmyxgdlihczskunpfibjqofath
rmyxgdliqczskunpqwbjqoeaev
rmhxgdlizcjskunpfwbjqoeatv
rmyxgdlfhcwskunpfwbjqoeaqv
rmyxgdlchclskunpfwbdqoeatv
rmyxgdluhczswunpfwbjqoeatt
rmyxgdlzqczskunpfwbjqoeatq
rmdxgdlihszskunpfwbwqoeatv
rmyxgdlihszsvunpfwbjqueatv
rmyxgdlhhczskunpffbjaoeatv
rmrxgdlphczskunpfwbjqreatv
hmyngdxihczskunpfwbjqoeatv
rmyxgdlizczpkunpfwbyqoeatv
rmyxbdlihyzskunlfwbjqoeatv
rmyxgdlipczsqunnfwbjqoeatv
rmyxgdlihcsskunpfxbjqoaatv
rmyxgdljhcznkunpfwbjqfeatv
rmaxgdlihczspunpfwbjqoqatv
rsyxgdlihczskunpfwbjqoehcv
rmyxgjlicczskunpfwbjqoeitv
rwymgvlihczskunpfwbjqoeatv
rmyxgdlipfzskunpfwbjqweatv
rmyxgglihczskunpgwbjqoealv
royxgdlihczskhnpfwbyqoeatv
rmyxgdlihczskvnpfabkqoeatv
rmyxgdlihczskunpfwhjwzeatv
jlyxgdlihczskunpfwbjqzeatv
rmyxgdlihccskunpfwwjqopatv
rmyxgxlihczskuupfwbjqoeahv
rmyxgdcihcbskungfwbjqoeatv
tmyxgdlihczskunpfwbjmoeftv
rkyxgdlioczskmnpfwbjqoeatv
rmyxgdlrhczskulpfwbjaoeatv
rmysgdlihczikunphwbjqoeatv
rmyxgdlihczskuvpfwbjqoeyty
fmyxgdlihczscunpfqbjqoeatv
rfyxgdlihzzrkunpfwbjqoeatv
rmyxgdlikczskunpfwbjqolath
rmyxqdlihjzskunpfwbjqoeamv
rmuxodiihczskunpfwbjqoeatv
rmyygdliucuskunpfwbjqoeatv
rmyxgdliwczskuppawbjqoeatv
rmyxgdlihczskunprwbjqgehtv
imyvgdlihczskunpfwbjqouatv
rgyxgdluhczskunpflbjqoeatv
rmgxgdlihczsdunpfwwjqoeatv
gdyxgdlihczskunpfwbjqoeavv
rmyxgdlihczskunpfwljjoektv
rmexgdlihczskunpfwxjqoeytv
rmyxqdlihcyskuwpfwbjqoeatv
rmyxgdlihczskunpfiyjqcebtv
amyngdlihczskunpfwbjqseatv
rmzxgdlihczykubpfwbjqoeatv
rmyxgdlihczhkuopfwbjsoeatv
rmyxgdlihczskunpfwbaqowztv
rmgxgdlihczslunpfwbjeoeatv
rmytgdlzhczskunrfwbjqoeatv
rmyxgdtihczskunafobjqoeatv
rmyxgdlihczskuflfbbjqoeatv
rmdxgdlihczskunpfwbjqoealj
rbyxgdlihczskuppdwbjqoeatv
rmyxhdiihcwskunpfwbjqoeatv
rmmggdlfhczskunpfwbjqoeatv
rmbxgblihczskuypfwbjqoeatv
rmyxgslihczsjunpjwbjqoeatv
rmyxgdlohczsaunpfwbjboeatv
rmaxgdhihczskunpfwbjooeatv
rmyxidlihczskunpfgbuqoeatv
rmyxgdlihfzckznpfwbjqoeatv
rmaqgdpihczskunpfwbjqoeatv
rmyvgdlirczskunpfobjqoeatv
rmdxgdlihczlkunpxwbjqoeatv
rmyxgdlihczseunpfwbjvdeatv
rmyxgdlihczskuhpfwbjqneath
rmyxrdlihciskunpfwbjqoratv
rmyxgdmihczsqunpftbjqoeatv
rmyxgdlbhczskulpfbbjqoeatv
rmoxgdlihczskunpfwbjqoeesv
rmyxgdlihczskuijfwejqoeatv
rmyxgdlihczskunpfwnkqoxatv
rmyxgdvihmzskuupfwbjqoeatv
rkyxedlihczskunpfcbjqoeatv
rmyxgdjihczskunprwbjqieatv
omyxgqgihczskunpfwbjqoeatv
rmyxydlihczskunpfwkjqoentv
rmbxgdlicczskunpfwbjqteatv
emyxgdlihczskugpfwbjqneatv
dmyxgflihczskunpfwbjqjeatv
umyxgdlihczskunpfwbjloextv
rmyxgdlihczsbunpfwbyqpeatv
rmyxgdrihczsvunpcwbjqoeatv
qmyxgdlihcwsknnpfwbjqoeatv
ymyxgdlihczskunpfsbjqowatv
rmyxgdlbhczskunpnvbjqoeatv
rmyxfdlixczskunpfwbjqoertv
rmyygdlihszrkunpfwbjqoeatv
rmyxgxlihcpskunpfwbjqoeanv
rmyxgdlihczskjnpfwbjqoprtv
rmyxgdlisczfkunpfwbjqoeath
rmyxgdlihczskunpfkbjqoeaji
rmyxgylihczskunpfwbfqoeatl
rmsxgdbihczskunpfwtjqoeatv
smyxgdlihczskunpfwbjqcwatv
rmyxgdlihczskunppjljqoeatv
rmyxgdlihczskulpfdbjooeatv
rmyxgdlihczskunpfibjqcebtv
rmyxadlihczskunpgwbjyoeatv
rmyxgdlihczdkunpvwbjqoeytv
rmyxgdlihcvskunpfwbjxohatv
rmyxgplihczskunpfgbjqoeauv
rmyxgdlihcysrunmfwbjqoeatv
rmyygdlihczskunpfwbjqvewtv
rmyxgdlihczsmunpfwdjnoeatv
rmyxgdbibczskunpfwbjuoeatv
rmyfgdlihczskubpfwbjqoeatp
rmyxgdlihczskuopfzijqoeatv
rmyqgdlihczskunpwwbjqoeanv
imyxgdlihczskunpfwbjqoqytv
rmyxgdlixcoskbnpfwbjqoeatv
rmyxgrlihccskunpfwbjqteatv
rdyxgdlihcpskunpfwbjqoratv
rmyxgdlihkzskunpfwbjmoeatj
rmyxgslihczskcnpfjbjqoeatv
rmyxgdlihczsqunqfwdjqoeatv
rjyxgdlyhczbkunpfwbjqoeatv
rmyxudlihczjkunpfwbjqzeatv
"""