function f01(){
    const x = document.createTextNode("ㅎㅇㅎㅇ");
    const result = document.querySelector("#result");
    result.appendChild(x);
    
}
function f02(){
    const x = document.createElement("h1");
    const t = document.createTextNode("JS로 만든 텍스트");
    x.appendChild(t);

    const result = document.querySelector("#result");
    result.appendChild(x);
    
}
function f03(){
    const elemArr = document.querySelectorAll("h1");
    elemArr[0].remove();
    console.log(elemArr);
}