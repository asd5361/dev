import React from "react";
import styled from "styled-components";

const StyledLoginArea = styled.div`
    width: 100%;
    height: 100%;
    border: 1px solid #000;
    background-color: #fff;

    & form{
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-rows: repeat(3, 1fr);
        grid-template-columns: 1fr 1fr;
        place-items: center center;
        
        & input{
            width: 100%;
            height: 100%;
        }

        & input:nth-child(1),
        input:nth-child(2)
        {
            grid-column: span 2;
        }
    }

`;

const LoginArea = () => {
    return(
    <StyledLoginArea>
        <form action="127.0.0.1:8888/app/member/login" method="post">
            <input type="text" name="id" placeholder="아이디"></input>
            <input type="password" name="pwd" placeholder="비밀번호"></input>
            <input type="button" value="회원가입"></input>
            <input type="submit" value="로그인"></input>
        </form>
    </StyledLoginArea>
    );
}

export default LoginArea;
