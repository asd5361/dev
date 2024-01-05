import React from 'react';
import { useKhMemory, KhMemoryProvider } from '../context/KhContext';

const Main = () => {

    const {cnt, plus} = useKhMemory();
    return (
        <>
            <h1>
                Mainnnnnnnnnnnn
            </h1>
            <h1 onClick={plus}>{cnt}</h1>
        </>
    );
};

export default Main;