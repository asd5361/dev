import {useState} from "react";

function Counter(){
    // const arr = useState();
    // const num = arr[0];
    // const setNum = arr[1];
    
    const [num, setNum] = useState();

    function plus(){
        setNum(num+1);
        console.log("증가완료된 num의 값 :" + num);
    }
    
    return <>
        <h1>카운터값 : {x}</h1>
        <button onClick ={plus}>플러스</button>
    </>
}
export default Counter;

