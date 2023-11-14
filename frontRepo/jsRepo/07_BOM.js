function f01(){
    /*
        함수들은 실행 후 객체를 반환한다. 그렇기 때문에 변수에 담아 확인할 수 있다.
    */
    //open
    // window.open("https://www.naver.com","abc","width=500 , height=500");

    //setTimeout        //window 생략 가능
    // window.setTimeout(()=>{
    //     console.log("3초 지났음")
    // }, 3000);

    //setInterval       //window 생략 가능
    // window.setInterval(()=>{    
    //     console.log("3초마다 실행");
        
    // },3000);

    // 창이 열리고 3초 뒤에 닫힘
    const abcTab = window.open("https://www.naver.com","abc");
    
    const closeTimer = window.setTimeout(()=>{
        abcTab.close();
    },3000);

    //타이머 없애기
    clearTimeout(closeTimer);
    // clearInterval(타이머);

}

function f02(){
    // location.href="https://www.naver.com";
    location.reload();
}

function f03(){
    console.log(history);
    history.forward();
    history.back();
    history.go(-2);
}

function f04(){
    console.log(navigator);
    console.log(screen);
}
f04();


