import React from 'react';
import styled from 'styled-components';
import Aside from './Aside';
import {Routes, Route} from 'react-router-dom';
import MemberMain from './member/MemberMain';
import BoardMain from './board/BoardMain';
import NoticeMain from './notice/NoticeMain';
import GalleryMain from './gallery/GalleryMain';
import ErrorPageNotFound from './ErrorPageNotFound';

const StyledMainDiv = styled.div`
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-columns: 1.5fr 7fr 1.5fr;
    grid-template-rows: 1fr;
    place-items: center center;
`;

const Main = () => {
    return (
        <StyledMainDiv>
            <Aside x='https://www.thinkfood.co.kr/news/photo/202206/94885_123761_226.jpg' />
            <Routes>
                <Route path='/' element={<h1>환영합니다.~!</h1>}></Route>
                <Route path='/member/*' element={<MemberMain />}></Route>
                <Route path='/board/*' element={<BoardMain />}></Route>
                <Route path='/notice/*' element={<NoticeMain />}></Route>
                <Route path='/gallery/*' element={<GalleryMain />}></Route>
                <Route path='/*' element={<ErrorPageNotFound />}></Route>
            </Routes>
            <Aside x='https://cdn.news.cauon.net/news/photo/202203/36524_26498_1343.png' />
        </StyledMainDiv>
    );
};

export default Main;