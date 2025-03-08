package solve.boj.boj22860

// 파일 이름이 같은 경우는 동일한 파일이다.
// 한 폴더 안에는 같은 이름의 파일이 두 개 이상 존재할 수 없다.
// main 하위 디렉토리에 같은 이름의 폴더가 두 개 이상 존재할 수 없다.

// 쿼리마다 main부터 폴더의 경로 정보가 들어온다.
// main 폴더 안에 FolderB에 대한 쿼리 : "main/FolderB"

// 쿼리마다 폴더 하위에 있는 파일의 종류의 개수와 파일의 총 개수를 출력
// 파일의 종류의 개수 : 같은 파일이 여러개 있을 경우 하나로 계산
// 파일의 총 개수 : 같은 파일이 있더라도 하나로 계산하지 않는다.
fun main() {
    System.`in`.bufferedReader()
    System.out.bufferedWriter()
    val (folderCounts, fileCounts) = readln().split(" ").map{it.toInt()}
    // map을 쓸까?
    val structure = mutableMapOf<String, MutableList<Pair<Int, String>>>().withDefault { mutableListOf() }
    repeat(folderCounts + fileCounts) {
        val (parentFolder, name, isFolder) = readln().split(" ")
        val key = structure[parentFolder]
        if (key == null) {
            structure[parentFolder] = mutableListOf<Pair<Int, String>>(isFolder.toInt() to name)
        } else {
            key.add(isFolder.toInt() to name)
        }
    }

    val queryCounts = readln().toInt()
    val queries = mutableListOf<String>()
    repeat(queryCounts) {
        val query = readln()
        queries.add(query)
    }

    queries.forEach { query ->
        val path = query.split("/").last()
        val innerFiles = mutableListOf<String>()
        val folderQueue = mutableListOf<String>(path)
        while(folderQueue.isNotEmpty()) {
            val folder = folderQueue.last()
            val folderItems = structure.getOrDefault(folder, mutableListOf<Pair<Int, String>>())
            folderItems.forEach {
                if(it.first == 0) innerFiles.add(it.second)
                else folderQueue.add(it.second)
            }
            folderQueue.remove(folder)
        }
        println("${innerFiles.toSet().size} ${innerFiles.size}")
    }
}
