window.onload=function(){
    
    const target= document.querySelector("#target");
    target.addEventListener('click',function(e){

        const str = "010-156-1615";
        const reg = /^[\d]{3}-[\d]{3,4}-[\d]{4}$/;
        // const reg = /^010-?([0-9]{4}-?([0-9]){4})$/;
        //reg.test(str);
        const result = str.replace(reg,"V");
        console.log(result);
    });

}