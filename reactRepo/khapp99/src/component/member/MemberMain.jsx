import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MemberJoin from './MemberJoin';
import MemberEdit from './MemberEdit';
import MemberLogin from './MemberJoin';
import ErrorPageNotFound from '../ErrorPageNotFound';
const MemberMain = () => {
    return (
        <Routes>
            <Route path='/join'element={<MemberJoin />}/>
            <Route path='/edit'element={<MemberEdit />}/>
            <Route path='/login'element={<MemberLogin />}/>
            <Route path='*' element={<ErrorPageNotFound/>}/>
        </Routes>
    );
};

export default MemberMain;