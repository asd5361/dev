function f02(){
    console.log("f02 called");
}

window.onload = ()=>{
    const btn03 = document.querySelector("#btn03");
    btn03.addEventListener("click",()=>{
        console.log("f03 called...");
    });

    const btn01 = document.querySelector("#btn01");
    btn01.onclick = ()=>{
        console.log("f01 called");
    };
};

// const btn03 = document.querySelector("#btn03");
// btn03.addEventListener("click",()=>{
//     console.log("f03 called...");
// });

function f04(){
    alert("a 태그 클릭 네이버로 이동?");
}

// 아이디 input 값이 비어있으면 false 값이 있으면 true 리턴하기
function f05(){
    const memberId = document.querySelector("input[name=memberId]");
    const memberPwd = document.querySelector("input[name=memberPwd]");
    const memberPwd2 = document.querySelector("input[name=memberPwd2]");
    const memberNick = document.querySelector("input[name=memberNick]");

    if(memberId.value.length < 1){
        alert("아이디는 빈칸일 수 없습니다.");
        memberId.focus();
        return false;
    }
    
    if(memberPwd.value.length < 1){
        alert("비밀번호는 빈칸일 수 없습니다.");
        memberPwd.focus();
        return false;
    }
    if(memberNick.value.length < 1){
        alert("닉네임은 빈칸일 수 없습니다.");
        memberNick.focus();
        return false;
    }
    if(memberPwd2.value !== memberPwd.value){
        alert("비밀번호가 일치하지 않습니다.");
        memberPwd2.focus();
        return false;
    }

    return true;    //회원가입 진행
    
}