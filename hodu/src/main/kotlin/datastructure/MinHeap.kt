package datastructure

// 최소 힙
class MinHeap(private val maxSize: Int) : Heap {
    override var endNodeIndex: Int = DEFAULT_INDEX
        private set
    val size: Int get() = endNodeIndex
    val heap: Array<Long> = Array(maxSize + 1) {0L}

    init {
        require(maxSize > 0) { "힙의 크기는 0보다 커야합니다." }
    }

    override fun insert(item: Long) {
        if (isFull()) {
            println("힙이 꽉 찼습니다. 현재 크기: $size, 최대 크기: $maxSize")
            return
        }
        // item이 삽입될 인덱스
        var insertingIndex = ++endNodeIndex
        // 부모 노드와 item을 비교하며 삽입할 위치를 찾는다.
        // 만약 item이 부모 노드보다 작다면, 부모 노드는 현재 삽입 위치로 이동해야한다.
        while (insertingIndex != ROOT_NODE_INDEX && heap[insertingIndex/2] > item) {
            heap[insertingIndex] = heap[insertingIndex/2]
            insertingIndex /= 2
        }
        heap[insertingIndex] = item
    }

    // 루트 노드의 아이템을 삭제하고 반환
    // 힙을 순서에 맞게 재구성한다: 맨 끝 노드를 루트로 설정하여, 자식과 비교를 수행한다.
    override fun delete(): Long {
        if (isEmpty()) {
            println("힙이 비어있습니다.")
            return 0L
        }
        val rootItem = heap[ROOT_NODE_INDEX]  // 반환할 루트 노드 아이템
        val endNode = heap[endNodeIndex--]  // 맨 끝 노드, 루트에 삽입될 예정
        var parentIndex = ROOT_NODE_INDEX  // 부모 노드 인덱스, 루트부터 시작
        var childIndex = ROOT_NODE_INDEX + 1  // 자식 노드 인덱스
        while (childIndex <= endNodeIndex) {
            // 왼쪽 자식노드와 오른쪽 자식노드 중 작은 쪽 선택
            if (childIndex < endNodeIndex && heap[childIndex] > heap[childIndex+1]) childIndex++
            // 더 큰 자식노드보다 마지막 노드가 작다면 비교 중지
            if (endNode < heap[childIndex]) break
            // 큰 자식 노드를 부모 노드 위치로 변경
            heap[parentIndex] = heap[childIndex]
            // 자식 노드로 이동(부모, 자식 노드 인덱스 업데이트)
            parentIndex = childIndex
            childIndex *= 2
        }
        // 마지막 노드를 재구성된 힙에 삽입
        heap[parentIndex] = endNode
        // 루트 노드 아이템 반환
        return rootItem
    }

    override fun isFull(): Boolean = endNodeIndex == maxSize

    override fun isEmpty(): Boolean = endNodeIndex == 0

    companion object {
        const val ROOT_NODE_INDEX = 1
        const val DEFAULT_INDEX = 0
    }
}

private operator fun Int?.compareTo(item: Int?): Int {
    return when {
        this == null && item == null -> 0
        this == null -> -1
        item == null -> 1
        else -> this.compareTo(item)
    }
}

class MinHeap2() {
    val heap = Array<Int>(100_000 + 1) { 0 }
    var n = 0
        private set

    fun insert(item: Int) {
        if(n + 1 >= heap.size) return
        var insertIndex = ++n
        while(insertIndex != 1 && heap[insertIndex/2] > item) {
            heap[insertIndex] = heap[insertIndex/2]
            insertIndex /= 2
        }
        heap[insertIndex] = item
    }

    fun delete(): Int {
        if(n == 0) return 0
        if(n == 1) return heap[n--]
        val root = heap[1]
        val last = heap[n--]
        var parent = 1
        var child = 2
        while(child <= n) {
            if (child < n && heap[child] > heap[child+1]) child++
            if (heap[child] >= last) break
            heap[parent] = heap[child]
            parent = child
            child *= 2
        }
        heap[parent] = last
        return root
    }
}
