package collection_framework_15.queue;

import java.util.LinkedList;
import java.util.Queue;

// Queue interface

// 값 추가 : offer
// 값 제거 : poll

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> queue = new LinkedList<>();

        queue.offer(new Message("sendMail", "홍길동"));
        queue.offer(new Message("sendSMS", "신용권"));
        queue.offer(new Message("sendKakaotalk", "홍두께"));

        while(!queue.isEmpty()) {
            Message message = queue.poll();
            switch (message.command) {
                case "sendMail" :
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;

                case "sendSMS" :
                    System.out.println(message.to + "님에게 SMS를 보냅니다.");
                    break;

                case "sendKakaoTalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
