package datastructure

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StackTest {
    private lateinit var stack: Stack<Int>

    @BeforeEach
    fun setUp() {
        stack = StackUsingTop(5)
    }

    @Test
    fun `top의 초기 값은 -1이다`() {
        assertThat(stack.top).isEqualTo(-1)
    }

    @Test
    fun `push로 아이템을 삽입한다`() {
        // when
        stack.push(3)
        // then
        assertThat(stack.size).isEqualTo(1)

        // when
        stack.push(4)
        // then
        assertThat(stack.size).isEqualTo(2)
    }

    @Test
    fun `꽉 찬 스택에 아이템을 push하면 삽입되지 않는다`() {
        // given
        repeat(5) { stack.push(1) }
        assertThat(stack.size).isEqualTo(5)

        // when
        stack.push(4)

        // then
        assertThat(stack.size).isEqualTo(5)
    }

    @Test
    fun `peek로 top 위치의 아이템을 확인한다`() {
        // given
        val item = 3
        stack.push(item)

        // when
        val peekedItem = stack.peek()

        // then
        assertThat(peekedItem).isEqualTo(item)
    }

    @Test
    fun `top은 스택의 가장 위에 쌓인 아이템의 인덱스를 나타낸다`() {
        // when
        stack.push(3)
        stack.push(4)
        stack.push(5)

        // then
        assertThat(stack.top).isEqualTo(2)
    }

    @Test
    fun `pop을 하면 가장 최근에 삽입된 아이템을 제거한다`() {
        // given
        val item = 3
        stack.push(item)

        // when
        val poppedItem = stack.pop()

        // then
        assertThat(poppedItem).isEqualTo(item)
        assertThat(stack.size).isEqualTo(0)
    }

    @Test
    fun `스택이 비어있을 때 peek을 하면 null을 반환한다`() {
        assertThat(stack.peek()).isEqualTo(null)
    }

    @Test
    fun `스택이 비어있을 때 pop을 하면 null을 반환한다`() {
        assertThat(stack.pop()).isEqualTo(null)
    }
}
