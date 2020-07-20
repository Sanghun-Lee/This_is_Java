package nio_19.buffer.kind;

import java.nio.ByteBuffer;

/**
 * non-direct buffer와 direct buffer 크기 비교
 *
 * 1600MB의 buffer를 생성하는데
 * non-direct는 에러를 일으키고, direct는 에러없이 잘 생성될 것이다.
 *
 * 둘 다 에러없이 잘 생성된다...
 */

public class BufferSizeExample {
    public static void main(String[] args) {
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(1600 * 1024 * 1024);
        System.out.println("다이렉트 buffer 1600MB가 생성되었습니다.");

        ByteBuffer nonDirectBuffer = ByteBuffer.allocate(1600 * 1024 * 1024);
        System.out.println("non-direct buffer 1600MB가 생성되었습니다.");
    }
}
