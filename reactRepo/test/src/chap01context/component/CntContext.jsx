import { createContext, useContext, useState } from "react";

//context 생성
const CntContext = createContext();

// 함수 안에 useContext를 실행함.
const useCntContext = () => {
    return useContext(CntContext);
}

//Provider를 꺼내옴 *(Provider, value 는 Context 안에 있다.)
const CntContextProvider = (props) => {

    const [cnt,setCnt] = useState(10);
    const obj ={
        cnt,
        setCnt
    }

    return <>
        <CntContext.Provider value={obj}>
            {props.children}
        </CntContext.Provider>
    </>
};


export {useCntContext,CntContextProvider}