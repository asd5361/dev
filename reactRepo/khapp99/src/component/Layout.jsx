import React from 'react';
import styled from 'styled-components';
import Header from './Header';
import Navi from './Navi';
import Main from './Main';
import Footer from './Footer';

const StyledLayoutDiv = styled.div`

    width: 100vw;
    height: 100vh;
    /*${ (obj) => { return obj.abc ? obj.abc : '#ccc' } }*/
    background-color: ${ obj => obj.abc ? obj.abc : '#ccc' };
    display: grid;
    grid-template-rows: 1.5fr 1fr 6fr 1.5fr;
    grid-template-columns: 1fr;
    place-items: center center;

`;


const Layout = ({color}) => {
    return (
        <StyledLayoutDiv abc={color}>
            <Header />
            <Navi />
            <Main />
            <Footer />
        </StyledLayoutDiv>            
    );
};

export default Layout;