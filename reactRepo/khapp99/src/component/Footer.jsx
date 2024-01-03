import React from 'react';
import styled from 'styled-components';

const StyledFooterDiv = styled.div`

    width: 100%;
    height: 100%;
    display: grid;
    color: #fff;
    grid-template-columns: 1.5fr 7fr 1.5fr;
    place-items: center center;
    background-color: #ccc;
`;

const Footer = () => {
    return (
        <StyledFooterDiv>
            <div></div>
            <div>footer, footer, footer, footer</div>
            <div></div>
        </StyledFooterDiv>
    );
};

export default Footer;