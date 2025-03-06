import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ").map { it.toInt() }
    val N = input[0] // folderNumber
    val M = input[1] // fileNumber
    val folderMap: MutableMap<String, MutableList<String>> = mutableMapOf() // 상위 폴더 - 하위 폴더 쌍
    val fileMap: MutableMap<String, MutableList<String>> = mutableMapOf() // 상위 폴더 - 하위 파일 쌍
    repeat(N + M) {
        val info = br.readLine().split(" ")
        val parent = info[0]
        val me = info[1]
        val isFolder = (info[2].toInt() == 1)

        if (isFolder) { // 폴더면
            if (folderMap[parent] != null) {
                folderMap[parent]!!.add(me)
            } else {
                folderMap[parent] = mutableListOf(me)
            }
        } else { // 파일이면
            if (fileMap[parent] != null) {
                fileMap[parent]!!.add(me)
            } else {
                fileMap[parent] = mutableListOf(me)
            }
        }
    }
    val answerMap: MutableMap<String, List<String>> = mutableMapOf()
    search("main", folderMap, fileMap, answerMap)

    val commandNumber = br.readLine().toInt()
    repeat(commandNumber) {
        val target = br.readLine().split("/").last()
        val answer = answerMap[target]!!
        println("${answer.toSet().size} ${answer.size}")
    }
}

fun search(
    folderName: String,
    folderMap: MutableMap<String, MutableList<String>>,
    fileMap: MutableMap<String, MutableList<String>>,
    answerMap: MutableMap<String, List<String>>,
) : List<String> {
    val childrenFolders: MutableList<String> = folderMap[folderName] ?: mutableListOf()
    val myFiles: MutableList<String> = fileMap[folderName] ?: mutableListOf()
    val childrenFiles = mutableListOf<String>()
    for (children in childrenFolders) {
        childrenFiles.addAll(search(children, folderMap, fileMap, answerMap)) // addAll
    }
    answerMap[folderName] = myFiles + childrenFiles
    return myFiles + childrenFiles
}
