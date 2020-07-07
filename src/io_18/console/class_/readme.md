#### Console 클래스

Java6부터 콘솔에서 입력받은 문자열을 쉽게 읽을 수 있도록 `System.console();` 메소드를 제공하고 있다.

`System.console()` 메소드는 이클립스에서 실행하면 `null`을 리턴하기 때문에

터미널에서 명령어를 이용해서 java 파일을 실행해야 한다.

Console 클래스에서 읽기 메소드는 다음과 같다.

- String readLine()
    + `Enter`키를 입력하기 전의 모든 문자열을 읽는다.
    
- char[] readPassword()
    + 키보드 입력 문자를 콘솔에 보여주지 않고 문자열을 읽는다.