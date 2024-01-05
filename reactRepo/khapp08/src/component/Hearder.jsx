import React from 'react';
import { useKhMemory } from '../context/KhContext';

const Hearder = () => {

    const {cnt, plus} = useKhMemory();

    return (
        <>
            <h1>
                headerrrrrrrrrrr
            </h1>
            <h1 onClick={plus}>{cnt}</h1>
        </>
    );
};

export default Hearder;