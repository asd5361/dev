import { useEffect, useRef, useState } from 'react';
import './App.css';


function App() {

  const x = useRef();

  useEffect(()=>{
    const t =setInterval(() => {
      console.log("안녕하세여");
    }, 3000);
    return ()=>{
      clearInterval(t);
    };
  });
  function f02(){
    console.log(x.current);
  };

  const [data,setData] = useState(0);

  function f01(){
    setData(data+1);
  }

  return (
  <>
    <h1 ref={x}>안녕</h1>
    <button onClick={f02}>output</button>
    <br />
    <button onClick={f01}>plus</button>
    <br />
    <h1>num : {data} </h1>
  </>
  );
}

export default App;
