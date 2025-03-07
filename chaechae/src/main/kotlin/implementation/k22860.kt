package implementation

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    val folderList = mutableMapOf<String, MutableList<String>>()
    val fileList = mutableMapOf<String, MutableList<String>>()

    repeat(N + M) {
        val (up, name, folderBoolean) = readln().split(" ")
        if (folderBoolean.toInt() == 1) {
            folderList.getOrPut(up) { mutableListOf() }.add(name)
        } else {
            fileList.getOrPut(up) { mutableListOf() }.add(name)
        }
    }

    val Q = readln().toInt()
    repeat(Q) {
        val path = readln().split("/")
        val target = path.last()

        val (uniqueFileSize, allFileSize) = findFiles(target, folderList, fileList)

        println("$uniqueFileSize $allFileSize")
    }
}

fun findFiles(
    target: String,
    folderList: MutableMap<String, MutableList<String>>,
    fileList: MutableMap<String, MutableList<String>>
): Pair<Int, Int> {
    val stack = mutableListOf(target)
    val uniqueFiles = mutableSetOf<String>()
    val allFiles = mutableListOf<String>()

    while (stack.isNotEmpty()){
        val currentFolder = stack.removeLast()

        fileList[currentFolder]?.forEach{
            uniqueFiles.add(it)
            allFiles.add(it)
        }

        folderList[currentFolder]?.let{
            stack.addAll(it)
        }
    }

    return uniqueFiles.size to allFiles.size
}