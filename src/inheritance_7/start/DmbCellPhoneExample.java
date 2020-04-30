package inheritance_7.start;

public class DmbCellPhoneExample {
    public static void main(String[] args) {
        // DmbCellPhone 객체 생성, 자식 객체가 생성되면 부모 객체도 자동으로 생성된다.
        DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);

        // Cellphone 으로 부터 상속받은 필드
        System.out.println("모델 : " + dmbCellPhone.model);
        System.out.println("색상 : " + dmbCellPhone.color);

        // DmbCellPhone 의 필드
        System.out.println("채널 : " + dmbCellPhone.channel);

        // CellPhone 으로부터 상속받은 메소드 호출
        dmbCellPhone.powerOn();
        dmbCellPhone.bell();
        dmbCellPhone.sendVoice("여보세요");
        dmbCellPhone.receiveVoice("안녕하세요");
        dmbCellPhone.sendVoice("네");
        dmbCellPhone.hangUp();

        // DmbCellPhone 의 메소드 호출
        dmbCellPhone.turnOnDmb();
        dmbCellPhone.changeChannelDmb(12);
        dmbCellPhone.turnOffDmb();
    }
}
