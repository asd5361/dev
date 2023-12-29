import styled from 'styled-components';
import React from "react";


const StyledSectionDiv = styled.div`
    width:100%;
    height:100%;
    background-color:red;
    display: flex;
    justify-content: center;
    align-items: center;
    
    & > table{
        width: 80%;
        height: 80%;
        border: 3px solid black;
        text-align: center;

        & tr {
            background-color: green;
        }
    }
`;

const KhSection =()=>{

    return(<>
        <StyledSectionDiv>  
            <table>
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>0</td>
                    <td>제목111</td>
                    <td>내용111</td>
                </tr>
                </tbody>
            </table>
        </StyledSectionDiv>
    </>);
}
export default KhSection;
