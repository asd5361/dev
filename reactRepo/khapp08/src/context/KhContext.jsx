import { useContext } from "react";
import { useState } from "react";
import { createContext } from "react";

const KhMemory = createContext();

const KhMemoryProvider = ({children}) => {
    const [cnt , setCnt] = useState(1);
    const plus = () =>{setCnt(cnt+1)};
    
    const obj = {
        cnt : cnt,
        plus : plus,

    };

    return (
        <>
            <KhMemory.Provider value={obj}>
                {children}
            </KhMemory.Provider>
        </>
    );
}

const useKhMemory = () => {
    const obj = useContext(KhMemory);
    return obj;
}


export {KhMemoryProvider, useKhMemory};

//복수인 경우 export {KhMemory1, KhMemory2, KhMemory3} 이런식으로 내보낸다.


