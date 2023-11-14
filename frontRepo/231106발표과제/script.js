const x = document.querySelector("#inp_01");
const y = document.querySelector("#btn_01");
let z = null;
x.addEventListener("blur",(e)=>{
    z = e.target.value;
    console.log(z);
});
y.addEventListener("click",()=>{
    if(z == null || z == ""){
        alert("검색어를 입력해주세요");
        console.log(z);
    }else{
        alert("검색을 진행하였습니다.");
        console.log(z);
    }
});