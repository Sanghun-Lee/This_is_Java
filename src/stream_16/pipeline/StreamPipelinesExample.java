package stream_16.pipeline;

import java.util.Arrays;
import java.util.List;

/**
 * 스트림 파이프라인
 * 중간 처리 및 최종 처리
 */

public class StreamPipelinesExample {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("홍길동", Member.MALE, 30),
                new Member("김나리", Member.FEMALE, 20),
                new Member("신용권", Member.MALE, 45),
                new Member("박수미", Member.FEMALE, 27)
        );

        double agvAvg = list.stream()
                .filter(m->m.getSex() == Member.MALE)
                .mapToInt(Member::getAge)
                .average()
                .getAsDouble();

        // filter : list에서 남자만 따로 집계 (중간 처리)
        // mapToInt : 집계된 남자 중 나이만 따로 집계 (중간 처리)
        // average : 중간 처리 결과인 나이의 평균을 계산 (최종 처리)
        // getAsDouble : OptionalDouble을 double로 변환

        System.out.println("남자 평균 나이 : " + agvAvg);
    }
}
