import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledNaviDiv = styled.div`
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-rows: 1fr;
    grid-auto-columns: 1fr ;
    grid-auto-flow: column;
    place-items: center center;
    background-color: #000;
    color: #fff;
    font-size: 2rem;
    border-top: 5px solid white;
`;

const Navi = () => {
    
    const f01 = useNavigate();
    
    return (
        <StyledNaviDiv>
            <div onClick={ ()=>{f01('/board/list')} }>게시판</div>
            <div onClick={ ()=>{f01('/notice/list')} }>공지사항</div>
            <div onClick={ ()=>{f01('/board/gallery')} }>갤러리</div>
        </StyledNaviDiv>
    );
};

export default Navi;