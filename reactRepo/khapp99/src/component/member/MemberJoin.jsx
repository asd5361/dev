import React from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledJoinDiv = styled.div`
    width: 100%;
    height: 100%;
    & > form {
        width: 100%;
        height: 100%;
        margin: auto;
        border : 5px dashed black;
        & > table {
        width: 50%;
        height: 50%;
        table-layout: fixed;
        }
    }
`;

const MemberJoin = () => {
    const navigate = useNavigate();
    const handleJoinSubmit = (event) => {
        event.preventDefault();

        const vo = {};
        vo.id="user010203";
        vo.pwd = "1234";
        vo.nick = "유저0103";

        fetch("http://127.0.0.1:8888/app/rest/member/join",{
            method: "post",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(vo)
        })
        .then(resp => resp.json())
        .then(data => {
            if(data.msg == "good"){
                alert('회원가입 성공!');
                navigate('/');
            }else{
                alert('회원가입 실패!');
                navigate('/fail');
            }

        })
        ;
    }
    
    return (
        <StyledJoinDiv>
            <form onSubmit={handleJoinSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>아이디</td>
                            <td><input type='text' name='id' /></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type='password' name='pwd' /></td>
                        </tr>
                        <tr>
                            <td>닉네임</td>
                            <td><input type='text' name='nick' /></td>
                        </tr>
                        <tr>
                            <td><input type='reset' /></td>
                            <td><input type='submit' value='회원가입' /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </StyledJoinDiv>
    );
};

export default MemberJoin;