package nio_19.buffer.position;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Buffer의 위치 속성값
 */

public class BufferExample {
    public static void main(String[] args) {
        System.out.println("[7바이트 크기로 버퍼 생성]");
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(7);   // 다이렉트 버퍼로 생성
        printState(byteBuffer);

        byteBuffer.put((byte)10);
        byteBuffer.put((byte)11);   // position에 상대적으로 저장한다.
        System.out.println("[2바이트 저장 후]");
        printState(byteBuffer);

        byteBuffer.put((byte)12);
        byteBuffer.put((byte)13);   // position에 상대적으로 저장한다.
        byteBuffer.put((byte)14);
        System.out.println("[3바이트 저장 후]");
        printState(byteBuffer);

        // 데이터를 읽기 위해 위치 속성값 변경
        byteBuffer.flip();
        System.out.println("[flip() 실행 후]");
        printState(byteBuffer);

        byteBuffer.get(new byte[3]);    // 상대적 읽기
        System.out.println("[3바이트 읽은 후]");
        printState(byteBuffer);

        byteBuffer.mark();
        System.out.println("------ [현재 위치를 마크 해놓음] ------");

        byteBuffer.get(new byte[2]);
        System.out.println("[2바이트 읽은 후]");
        printState(byteBuffer);

        byteBuffer.reset(); // mark위치로 position 이동
        System.out.println("---- [position을 mark 위치로 옮김] -----");
        printState(byteBuffer);

        byteBuffer.rewind();    // position을 0으로 이동
        System.out.println("[rewind() 실행 후]");
        printState(byteBuffer);

        byteBuffer.clear();
        System.out.println("[clear() 실행 후]");
        printState(byteBuffer);

    }

    public static void printState(Buffer buffer) {
        System.out.print("\tposition : " + buffer.position() + ", ");
        System.out.print("\tlimit : " + buffer.limit() + ", ");
        System.out.println("\tcapacity : " + buffer.capacity());
    }
}
