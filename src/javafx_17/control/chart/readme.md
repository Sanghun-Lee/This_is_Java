#### 차트 컨트롤

JavaFx에서는 아래와 같은 차트들을 지원해 준다.

- PieChart
- LineChart
- AreaChart
- BarChart
- BubbleChart
- ScatterChart

##### PieChart

> 선언방법

xml에서는 X축과 Y축이 없으므로 아래와 같이만 작성하면 된다.

`<PieChart />`

> 데이터 추가

데이터 추가는 `setData` 메소드를 이용하고, `PieChart.Data` 객체를 생성해서 데이터를 추가하면 된다.

아래와 같은 코드로 추가하면 된다.

```java
@FXML private PieChart pieChart;
pieChart.setData(FXCollections.observableArrayList(
    new PieChart.Data("AWT", 10),
    new PieChart.Data("Swing", 30),
    new PieChart.Data("SWT", 25),
    new PieChart.Data("JavaFx", 35)
));
```

##### LineChart, AreaChart, BarChart

> xml 선언방법

위 차트들을 x축은 위, 아래, y축은 왼쪽, 오른쪽에 올 수 있기 때문에

`<xAxis>`와 `<yAxis>`로 X축과 Y축이 어디에 있어야 하는지 위치를 지정해야 한다.

예시

```xml
<BarChart>
    <xAxis>
        <CategoryAxis side="BOTTOM" />
    </xAxis>
    <yAxis>
        <CategoryAxis side="LEFT" />
    </yAxis>
</BarChart>
```

> 데이터 추가

`XYChart.Series`는 하나의 그래프를 의미한다.

막대 그래프에는 여러 그래프들이 올 수 있기 때문에, `XYChart.Series`로 그래프들을 생성하고

`lineChart.getData().add(XYChart.Series field)`로 그래프를 추가할 수 있다.

```java
XYChart.Series series1 = new XYChart.Series();
series1.setName("남자");
series1.setData(FXCollections.abservableArrayList(
    new XYChart.Data("2015", 70),
    new XYChart.Data("2016", 50),
    new XYChart.Data("2017", 40),
    new XYChart.Data("2018", 30),
));
barChart.getData().add(series1);
```