#### JavaFx 다이얼로그

다이얼로그란, 알림 또는 사용자의 입력을 위해서 실행되는 `서브 윈도우`라고 볼 수 있다.

다이얼로그는 자체적으로 실행될 수 없고, `주 윈도우`에 의해서 실행된다.

다이얼로그를 띄우는 주 윈도우를 `다이얼로그 소유자(owner) 윈도우`라고 한다.

> 다이얼로그 종류

- 모달
    - 다이얼로그를 닫기 전까지 소유자 윈도우를 사용할 수가 없다.
    
- 모달리스
    - 다이얼로그가 있어도 소유자 윈도우를 사용할 수 있다.
    

##### FileChooser, DirectoryChooser

`FileChooser`는 로컬 PC에서 `파일을 선택할 수 있는` 다이얼로그인다.

예시

```java
FileChooser fileChooser = new FileChooser();    // FileChooser 객체 생성
fileChooser.getExtensionFilters().addAll(
    new ExtensionFilter("Text Files", "*.txt"),
    new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
    new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
    new ExtensionFilter("All Files", "*.*")
);

File selectedFile = fileChooser.showOpenDialog(primaryStage);   // 다이얼로그 띄우기
String selectedFilePath = selectedFile.getPath();               // 선택한 파일 경로 얻기
```

파일 확장명으로 필터링하려면 `ExtensionFilter`를 추가하면 된다.

`showOpenDialog`, `showSaveDialog` 메소드를 호출할 때에는 `소유자 윈도우`를 매개값으로 넣어야 한다.

---

##### 컨트롤러에서 primaryStage 사용

`RootController.java`파일에서 `popup`을 호출하기 위해선 `stage`를 넘겨주어야 한다.

이를 위해서 먼저 `RootController.java` 파일에서는 다음과 같이 `Stage 필드와 Setter`를 선언해야 한다.

```java
public class RootController implements Initializable {
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
```

그리고 `RootController`의 객체를 생성하고, `setPrimaryStage`를 호출해서 `AppMain에 있는 Stage`를 넘겨 주어야 하는데,

`RootController`의 객체를 얻기 위해선 `FXMLLoader`의 `getController` 메소드를 이용해서 객체를 얻는다.

`getController`는 인스턴스 메소드 이기 때문에, FXMLLoader 객체를 생성해야 한다.

```java
FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
Parent root = loader.load();
RootController controller = loader.getController();
controller.getController(stage);
```