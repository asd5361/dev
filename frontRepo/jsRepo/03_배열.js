function f01(){
    arr01 = new Array();
    arr02 = new Array(3);
    arr03 = new Array("핸드폰","페브리즈",100,true,null);
    arr04 = ["핸드폰","페브리즈",100,true,null];
    arr05 = [];
    arr05[0] = '하나';
    arr05[1] = '둘';
    arr05[7] = '셋';


    console.log(arr01);
    console.log(arr02);
    console.log(arr03);
    console.log(arr04);
    console.log(arr05);

}

// f01();
function f02(){
    const arr= ["사과","귤","파인애플","골드키워"];
    const arr02=["바지","양말"];

    // indexOf()   배열에서 요소가 위치한 인덱스를 반환한다.
    const x = arr.indexOf("파인애플");
    console.log(x);
    // concat()    여러 개의 배열을 결합하여 새로운 배열을 리턴한다.
    const y = arr.concat(arr02);
    console.log(y);
    // join()      배열의 요소들을 결합해서 하나의 문자열로 반환한다.
    const z = arr.join();
    console.log(z);
    // reverse()   원본 배열의 순서를 뒤집는 메소드이다.
    const d = arr.reverse();
    console.log(d);
    // sort()      배열을 오름차순(문자기준)으로 정렬하는 메소드이다.
    const a = arr.sort();
    console.log(a);
    // push()      배열의 맨 뒤에 요소를 추가한다.
    arr02.push("치마");
    console.log(arr02);
    // pop()       배열의 맨 뒤에 요소를 반환 후 제거한다.
     arr02.pop()
     console.log(arr02);
    // shift()     배열의 맨 앞의 요소를 반환 후 제거한다.
    const b = arr02.shift();
    console.log(b);
    // unshift()   배열의 맨 앞의 요소를 추가한다.  
    arr02.unshift("바지");
    console.log(arr02);
    // slice()     배열의 요소를 뽑아내는 메소드이다.
    const c=arr02.slice();
    console.log("slice"+c);
    // splice()    배열의 특정 인덱스 위치에 요소 제거 및 추가하는 메소드이다.
    arr02.splice(1,0,"치마") 
    console.log(arr02);
}
f02();