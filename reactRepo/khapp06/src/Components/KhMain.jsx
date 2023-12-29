import React from "react";
import KhAside from './KhAside';
import KhSection from './KhSection';
import styled from "styled-components";
const StyledMainDiv = styled.main`
    width: 100vw;
    height: 70vh;
    background-color: lightgray;
    display: grid;
    grid-template-rows: 1fr;
    grid-template-columns: 1fr 3fr 1fr;
    place-items: center center;
`;

const KhMain = () => {
    return (<main>
        <StyledMainDiv>
            <KhAside />
            <KhSection />
            <KhAside />
        </StyledMainDiv>
        </main>);    
}
export default KhMain;