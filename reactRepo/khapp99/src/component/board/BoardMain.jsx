import React from 'react';
import BoardList from './BoardList';
import BoardDetail from './BoardDetail';
import BoardEdit from './BoardEdit';
import BoardWrite from './BoardWrite';
import { Routes,Route } from 'react-router-dom';

const BoardMain = () => {
    return (
    <Routes>
        <Route path='list' element={<BoardList />}></Route>
        <Route path='write' element={<BoardWrite />}></Route>
        <Route path='detail' element={<BoardDetail/>}></Route>
        <Route path='edit' element={<BoardEdit />}></Route>
    </Routes>
    );
};

export default BoardMain;