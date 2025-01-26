let ulSet = document.getElementById("ulSet");   //우측 직사각형 박스 부분
let totalNum = ulSet.childElementCount;

let currentNum;
let indexNum = 0;
let imgRoof;

for (var i = 1; i <= totalNum; i++) {
    var list = document.getElementById("list" + i);
    //앞은 배경과 배경 색상 뒤는 작은 선부분
    list.innerHTML = "<span></span><span></span>" + list.innerHTML + "<span><span></span><span></span></span>";
    list.onclick = function () {    //요소를 클릭했을 때
        currentNum = Number(this.id.slice(4, 5));   //list4
        console.log("currentNum은 ? : "+currentNum);
        clearInterval(imgRoof); // 이전 타이머 정리
        imgSetting();
        ResetContents();
    }
}

let ResetContents = function () {//초기화
    for (var i = 1; i <= totalNum; i++) {
        //document.getElementById("img" + i).classList.remove("imgChange");
        document.getElementById("text" + i).classList.remove("textShow");
        //document.getElementById("button" + i).classList.remove("buttonShow");
        document.getElementById("list" + i).classList.remove("listShow");
    }

    //document.getElementById("img" + currentNum).style.zIndex = ++indexNum;// z인덱스와 이미지가 함께 붙어서
    document.getElementById("text" + currentNum).style.zIndex = ++indexNum;//스타일에서 인덱스 처리를 안해줬기 때문에 text와 button도 z 인덱스 같이 올려준다. 이걸 안해주면 이미지만 움직이는 것을 볼 수 있다.
    //document.getElementById("button" + currentNum).style.zIndex = ++indexNum;// 버튼도 zindex 숫자를 올려준다.
    document.getElementById("ulSet").style.zIndex = ++indexNum;

    //document.getElementById("img" + currentNum).classList.add("imgChange");
    document.getElementById("text" + currentNum).classList.add("textShow");
    //document.getElementById("button" + currentNum).classList.add("buttonShow");
    document.getElementById("list" + currentNum).classList.add("listShow");
   //이미 실행되고 나서의 애니메이션을 제거해줌.
    // let clear = setInterval(function () {
    //     if (currentNum != 1) {
    //         document.getElementById("img" + (currentNum - 1)).classList.remove("imgChange");
    //     }
    //     clearInterval(clear);
    // }, 5000);
 }

 //계속 반복해주는 함수
let imgSetting = function () {
    imgRoof = setInterval(function () {    //setInterval을 변수에 담아 clearInterval을 실행시키기 위함.
        if (currentNum == totalNum) {
            currentNum = 1;
        } else {
            currentNum++;
        }
        console.log(currentNum);
        ResetContents();//이걸 해줘야 이미지,텍스트, 버튼 다 올라와져서 보임,
    }, 8000)
}

currentNum = 1;/*그림이 1부터 시작한다.*/
imgSetting();
ResetContents();

